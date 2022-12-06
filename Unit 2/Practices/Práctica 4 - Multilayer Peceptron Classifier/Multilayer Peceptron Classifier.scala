import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Load the data stored in LIBSVM format as a DataFrame.
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
```
scala> val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
22/11/17 11:38:40 WARN ProcfsMetricsGetter: Exception when trying to compute pagesize, as a result reporting of ProcessTree metrics is stopped
22/11/17 11:38:40 WARN LibSVMFileFormat: 'numFeatures' option not specified, determining the number of features by going though the input. If you know the number in advance, please specify it via 'numFeatures' option to avoid the extra scan.
data: org.apache.spark.sql.DataFrame = [label: double, features: vector]
```


// Split the data into train and test
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)
```
scala> val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
splits: Array[org.apache.spark.sql.Dataset[org.apache.spark.sql.Row]] = Array([label: double, features: vector], [label: double, features: vector])

scala> val train = splits(0)
train: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]

scala> val test = splits(1)
test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
```


// specify layers for the neural network:
// input layer of size 4 (features), two intermediate of size 5 and 4
// and output of size 3 (classes)
val layers = Array[Int](4, 5, 4, 3)
```
scala> val layers = Array[Int](4, 5, 4, 3)
layers: Array[Int] = Array(4, 5, 4, 3)
```


// create the trainer and set its parameters
val trainer = new MultilayerPerceptronClassifier()
  .setLayers(layers)
  .setBlockSize(128)
  .setSeed(1234L)
  .setMaxIter(100)
```
scala> val trainer = new MultilayerPerceptronClassifier()
trainer: org.apache.spark.ml.classification.MultilayerPerceptronClassifier = mlpc_5067aa771461
scala>   .setLayers(layers)
res0: trainer.type = mlpc_5067aa771461
scala>   .setBlockSize(128)
res1: res0.type = mlpc_5067aa771461
scala>   .setSeed(1234L)
res2: res1.type = mlpc_5067aa771461
scala>   .setMaxIter(100)
res3: res2.type = mlpc_5067aa771461
```


// train the model
val model = trainer.fit(train)
```
scala> val model = trainer.fit(train)
model: org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel = MultilayerPerceptronClassificationModel: uid=mlpc_5067aa771461, numLayers=4, numClasses=3, numFeatures=4
```


// compute accuracy on the test set
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator()
  .setMetricName("accuracy")
```
scala> val result = model.transform(test)
result: org.apache.spark.sql.DataFrame = [label: double, features: vector ... 3 more fields]
scala> val predictionAndLabels = result.select("prediction", "label")
predictionAndLabels: org.apache.spark.sql.DataFrame = [prediction: double, label: double]
scala> val evaluator = new MulticlassClassificationEvaluator()
evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_891fa4cb82a0, metricName=f1, metricLabel=0.0, beta=1.0, eps=1.0E-15

scala>   .setMetricName("accuracy")
res4: evaluator.type = MulticlassClassificationEvaluator: uid=mcEval_891fa4cb82a0, metricName=accuracy, metricLabel=0.0, beta=1.0, eps=1.0E-15

```


println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```
scala> println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
Test set accuracy = 0.9523809523809523
```