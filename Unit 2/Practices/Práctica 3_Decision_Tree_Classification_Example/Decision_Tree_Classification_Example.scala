import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}

// Load the data stored in LIBSVM format as a DataFrame.
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Index labels, adding metadata to the label column.
// Fit on whole dataset to include all labels in index.
val labelIndexer = new StringIndexer()
  .setInputCol("label")
  .setOutputCol("indexedLabel")
  .fit(data)

```
scala> val labelIndexer = new StringIndexer()
labelIndexer: org.apache.spark.ml.feature.StringIndexer = strIdx_b77291ed0f44
scala>   .setInputCol("label")
res39: labelIndexer.type = strIdx_b77291ed0f44
scala>   .setOutputCol("indexedLabel")
res40: res39.type = strIdx_b77291ed0f44
scala>   .fit(data)
res41: org.apache.spark.ml.feature.StringIndexerModel = StringIndexerModel: uid=strIdx_b77291ed0f44, handleInvalid=error
```

// Automatically identify categorical features, and index them.
val featureIndexer = new VectorIndexer()
  .setInputCol("features")
  .setOutputCol("indexedFeatures")
  .setMaxCategories(4) // features with > 4 distinct values are treated as continuous.
  .fit(data)
```

scala> val featureIndexer = new VectorIndexer()
featureIndexer: org.apache.spark.ml.feature.VectorIndexer = vecIdx_8317768000be

scala>   .setInputCol("features")
res42: featureIndexer.type = vecIdx_8317768000be

scala>   .setOutputCol("indexedFeatures")
res43: res42.type = vecIdx_8317768000be

scala>   .setMaxCategories(4) // features with > 4 distinct values are treated as continuous.
res44: res43.type = vecIdx_8317768000be

scala>   .fit(data)
res45: org.apache.spark.ml.feature.VectorIndexerModel = VectorIndexerModel: uid=vecIdx_8317768000be, numFeatures=692, handleInvalid=error

```

// Split the data into training and test sets (30% held out for testing).
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```
scala> val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
trainingData: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
testData: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
```

// Train a DecisionTree model.
val dt = new DecisionTreeClassifier()
  .setLabelCol("indexedLabel")
  .setFeaturesCol("indexedFeatures")
  ```
scala> val dt = new DecisionTreeClassifier()
dt: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_e511b167324f
scala>   .setLabelCol("indexedLabel")
res46: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_e511b167324f
scala>   .setFeaturesCol("indexedFeatures")
res47: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_e511b167324f
```

// Convert indexed labels back to original labels.
val labelConverter = new IndexToString()
  .setInputCol("prediction")
  .setOutputCol("predictedLabel")
  .setLabels(labelIndexer.labelsArray(0))
  ```
  scala> val labelConverter = new IndexToString()
labelConverter: org.apache.spark.ml.feature.IndexToString = idxToStr_5aef20e0ba13

scala>   .setInputCol("prediction")
res48: labelConverter.type = idxToStr_5aef20e0ba13

scala>   .setOutputCol("predictedLabel")
res49: res48.type = idxToStr_5aef20e0ba13

scala>   .setLabels(labelIndexer.labelsArray(0))
<console>:42: error: value labelsArray is not a member of org.apache.spark.ml.feature.StringIndexer
       res49  .setLabels(labelIndexer.labelsArray(0))                                      ^
```


// Chain indexers and tree in a Pipeline.
val pipeline = new Pipeline()
  .setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
```
scala> val pipeline = new Pipeline()
pipeline: org.apache.spark.ml.Pipeline = pipeline_2793c58805ab

scala>   .setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
res51: pipeline.type = pipeline_2793c58805ab
```


// Train model. This also runs the indexers.
val model = pipeline.fit(trainingData)
```
scala> val model = pipeline.fit(trainingData)
model: org.apache.spark.ml.PipelineModel = pipeline_2793c58805ab
```


// Make predictions.
val predictions = model.transform(testData)
```
//this throws an error
```

// Select example rows to display.
predictions.select("predictedLabel", "label", "features").show(5)
```scala> predictions.select("predictedLabel", "label", "features").show(5)
<console>:40: error: not found: value predictions
       predictions.select("predictedLabel", "label", "features").show(5)
       ````



// Select (prediction, true label) and compute test error.
val evaluator = new MulticlassClassificationEvaluator()
  .setLabelCol("indexedLabel")
  .setPredictionCol("prediction")
  .setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")
```
scala> val evaluator = new MulticlassClassificationEvaluator()
evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_ef831678264a, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setLabelCol("indexedLabel")
res53: evaluator.type = MulticlassClassificationEvaluator: uid=mcEval_ef831678264a, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setPredictionCol("prediction")
res54: res53.type = MulticlassClassificationEvaluator: uid=mcEval_ef831678264a, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setMetricName("accuracy")
res55: res54.type = MulticlassClassificationEvaluator: uid=mcEval_ef831678264a, metricName=accuracy, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala> val accuracy = evaluator.evaluate(predictions)
<console>:40: error: not found: value predictions
       val accuracy = evaluator.evaluate(predictions)

scala> println(s"Test Error = ${(1.0 - accuracy)}")
<console>:40: error: not found: value accuracy
       println(s"Test Error = ${(1.0 - accuracy)}")
 ```



val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
```
scala> val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
treeModel: org.apache.spark.ml.classification.DecisionTreeClassificationModel = DecisionTreeClassificationModel: uid=dtc_e511b167324f, depth=1, numNodes=3, numClasses=2, numFeatures=692
```


println(s"Learned classification tree model:\n ${treeModel.toDebugString}")
```
scala> println(s"Learned classification tree model:\n ${treeModel.toDebugString}")
Learned classification tree model:
 DecisionTreeClassificationModel: uid=dtc_e511b167324f, depth=1, numNodes=3, numClasses=2, numFeatures=692
  If (feature 517 <= 43.0)
   Predict: 1.0
  Else (feature 517 > 43.0)
   Predict: 0.0
   ```