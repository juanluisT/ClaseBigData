# Creación Unit2
# Practica 1
************************* LINEAR REGRESSION EXERCISE *************************
``` sh
scala> import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.regression.LinearRegression
scala> import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession
``` sh
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@1035ec3c
``` 

data: org.apache.spark.sql.DataFrame = [Email: string, Avatar: string ... 5 more fields]
root
``` sh
 |-- Email: string (nullable = true)
 |-- Avatar: string (nullable = true)
 |-- Avg Session Length: double (nullable = true)
 |-- Time on App: double (nullable = true)
 |-- Time on Website: double (nullable = true)
 |-- Length of Membership: double (nullable = true)
 |-- Yearly Amount Spent: double (nullable = true)
``` 
res2: Array[org.apache.spark.sql.Row] = Array([mstephenson@fernandez.com,Violet,34.49726773,12.65565115,39.57766802,4.082620633,587.951054])
``` sh
colnames: Array[String] = Array(Email, Avatar, Avg Session Length, Time on App, Time on Website, Length of Membership, Yearly Amount Spent)
firstrow: org.apache.spark.sql.Row = [mstephenson@fernandez.com,Violet,34.49726773,12.65565115,39.57766802,4.082620633,587.951054]
587.951054
``` 

import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
res6: Array[String] = Array(Email, Avatar, Avg Session Length, Time on App, Time on Website, Length of Membership, Yearly Amount Spent)        
df: org.apache.spark.sql.DataFrame = [label: double, Length of Membership: double ... 3 more fields]
assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_069a4d55310b, handleInvalid=error, numInputCols=4
output: org.apache.spark.sql.DataFrame = [label: double, features: vector]
``` sh
+-----------+--------------------+
|      label|            features|
+-----------+--------------------+
| 587.951054|[4.082620633,39.5...|
|392.2049334|[2.664034182,37.2...|
|487.5475049|[4.104543202,37.1...|
| 581.852344|[3.120178783,36.7...|
| 599.406092|[4.446308318,37.5...|
|637.1024479|[5.493507201,34.4...|
|521.5721748|[4.685017247,36.6...|
|549.9041461|[4.434273435,37.3...|
| 570.200409|[3.273433578,37.5...|
|427.1993849|[3.202806072,37.1...|
|492.6060127|[2.482607771,37.2...|
|522.3374046|[3.713209203,37.0...|
|408.6403511|[4.046423164,37.4...|
|573.4158673|[3.918541839,36.1...|
|470.4527333|[2.494543647,36.6...|
|461.7807422|[3.357846842,36.2...|
|457.8476959|[3.136132716,34.8...|
|407.7045475|[2.420806161,38.3...|
|452.3156755|[1.516575581,38.2...|
|605.0610388|[4.06454855,37.19...|
+-----------+--------------------+
only showing top 20 rows
``` 

import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_224476b17b3e, handleInvalid=error, numInputCols=6
lr: org.apache.spark.ml.regression.LinearRegression = linReg_4673a0994372
22/11/16 20:41:38 WARN Instrumentation: [cc39df75] regParam is zero, which might cause numerical instability and overfitting.
22/11/16 20:41:38 WARN InstanceBuilder$NativeLAPACK: Failed to load implementation from:dev.ludovic.netlib.lapack.JNILAPACK
lrModel: org.apache.spark.ml.regression.LinearRegressionModel = LinearRegressionModel: uid=linReg_4673a0994372, numFeatures=4
trainingSummary: org.apache.spark.ml.regression.LinearRegressionTrainingSummary = org.apache.spark.ml.regression.LinearRegressionTrainingSummary@3c37e224
Coefficients: [61.577323749792654,0.43673882830766236,38.7091538136038,25.734271083500158] Intercept: -1051.5942549968393
trainingSummary: org.apache.spark.ml.regression.LinearRegressionTrainingSummary = org.apache.spark.ml.regression.LinearRegressionTrainingSummary@3c37e224
numIterations: 0
objectiveHistory: List(0.0)
``` sh
+-------------------+
|          residuals|
+-------------------+
|-6.7882342077535895|
| 11.841128372830951|
|-17.652627154230174|
| 11.454889368167755|
|  7.783382546062512|
| -1.834733254999719|
|   4.62023243733222|
| -8.526545892172521|
| 11.012210629852461|
| -13.82803256192102|
|-16.044564612523857|
|  8.786634455008993|
| 10.425717160518957|
| 12.161293905138791|
|  9.989313832885614|
| 10.626662882477547|
|  20.15641400620899|
|-3.7708444841739492|
|-4.1295054332299514|
|  9.206694577639382|
+-------------------+
only showing top 20 rows
``` 

``` sh
RMSE: 9.923256786178927
``` 

``` sh
scala> println(s"r2: ${trainingSummary.r2}")
r2: 0.9843155370195906
``` 
# Practica 2
************************* LOGISTIC REGRESSION EXERCISE *************************
Loading Practica2.scala...
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@40fd518f
data: org.apache.spark.sql.DataFrame = [Daily Time Spent on Site: double, Age: int ... 8 more fields]
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@40fd518f
data: org.apache.spark.sql.DataFrame = [Daily Time Spent on Site: double, Age: int ... 8 more fields]
root
``` sh
 |-- Daily Time Spent on Site: double (nullable = true)
 |-- Age: integer (nullable = true)
 |-- Area Income: double (nullable = true)
 |-- Daily Internet Usage: double (nullable = true)
 |-- Ad Topic Line: string (nullable = true)
 |-- City: string (nullable = true)
 |-- Male: integer (nullable = true)
 |-- Country: string (nullable = true)
 |-- Timestamp: timestamp (nullable = true)
 |-- Clicked on Ad: integer (nullable = true)
``` 
``` sh
res3: Array[org.apache.spark.sql.Row] = Array([68.95,35,61833.9,256.09,Cloned 5thgeneration orchestration,Wrightburgh,0,Tunisia,2016-03-27 00:53:11.0,0])
colnames: Array[String] = Array(Daily Time Spent on Site, Age, Area Income, Daily Internet Usage, Ad Topic Line, City, Male, Country, Timestamp, Clicked on Ad)
``` 
firstrow: org.apache.spark.sql.Row = [68.95,35,61833.9,256.09,Cloned 5thgeneration orchestration,Wrightburgh,0,Tunisia,2016-03-27 00:53:11.0,0]


Example data row
``` sh
Age
35
``` 

Area Income
``` sh
61833.9
``` 

Daily Internet Usage
``` sh
256.09
``` 

Ad Topic Line
Cloned 5thgeneration orchestration


City
``` sh
Wrightburgh
``` 

Male
0


Country
Tunisia


Timestamp
2016-03-27 00:53:11.0


Clicked on Ad
0


timedata: org.apache.spark.sql.DataFrame = [Daily Time Spent on Site: double, Age: int ... 9 more fields]
logregdata: org.apache.spark.sql.DataFrame = [label: int, Daily Time Spent on Site: double ... 5 more fields]
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_4b13f8d2df54, handleInvalid=error, numInputCols=6
training: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: int, Daily Time Spent on Site: double ... 5 more fields]
test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: int, Daily Time Spent on Site: double ... 5 more fields]
import org.apache.spark.ml.Pipeline
lr: org.apache.spark.ml.classification.LogisticRegression = logreg_3aec9b7957ab
pipeline: org.apache.spark.ml.Pipeline = pipeline_ce9486e30191
model: org.apache.spark.ml.PipelineModel = pipeline_ce9486e30191
results: org.apache.spark.sql.DataFrame = [label: int, Daily Time Spent on Site: double ... 9 more fields]
import org.apache.spark.mllib.evaluation.MulticlassMetrics
predictionAndLabels: org.apache.spark.rdd.RDD[(Double, Double)] = MapPartitionsRDD[78] at rdd at Practica2.scala:37
metrics: org.apache.spark.mllib.evaluation.MulticlassMetrics = org.apache.spark.mllib.evaluation.MulticlassMetrics@1501766b
``` sh
Confusion matrix:
136.0  1.0    
4.0    146.0
``` 
``` sh
res9: Double = 0.9825783972125436
``` 

# Practica 3 
************************* Decision Tree Classification Model *************************
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}

# Load the data stored in LIBSVM format as a DataFrame.
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

# Index labels, adding metadata to the label column.
# Fit on whole dataset to include all labels in index.
val labelIndexer = new StringIndexer()
  .setInputCol("label")
  .setOutputCol("indexedLabel")
  .fit(data)

``` sh
scala> val labelIndexer = new StringIndexer()
labelIndexer: org.apache.spark.ml.feature.StringIndexer = strIdx_b77291ed0f44
scala>   .setInputCol("label")
res39: labelIndexer.type = strIdx_b77291ed0f44
scala>   .setOutputCol("indexedLabel")
res40: res39.type = strIdx_b77291ed0f44
scala>   .fit(data)
res41: org.apache.spark.ml.feature.StringIndexerModel = StringIndexerModel: uid=strIdx_b77291ed0f44, handleInvalid=error
```

# Automatically identify categorical features, and index them.
val featureIndexer = new VectorIndexer()
``` sh
  .setInputCol("features")
  .setOutputCol("indexedFeatures")
  .setMaxCategories(4) // features with > 4 distinct values are treated as continuous.
  .fit(data)
```
``` sh
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
``` sh
# Split the data into training and test sets (30% held out for testing).
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```
``` sh
scala> val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
trainingData: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
testData: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
```

# Train a DecisionTree model.
val dt = new DecisionTreeClassifier()
``` sh
  .setLabelCol("indexedLabel")
  .setFeaturesCol("indexedFeatures")
  ```
  ``` sh
scala> val dt = new DecisionTreeClassifier()
dt: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_e511b167324f
scala>   .setLabelCol("indexedLabel")
res46: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_e511b167324f
scala>   .setFeaturesCol("indexedFeatures")
res47: org.apache.spark.ml.classification.DecisionTreeClassifier = dtc_e511b167324f
```

# Convert indexed labels back to original labels.
``` sh
val labelConverter = new IndexToString()
  .setInputCol("prediction")
  .setOutputCol("predictedLabel")
  .setLabels(labelIndexer.labelsArray(0))
  
  scala> val labelConverter = new IndexToString()
labelConverter: org.apache.spark.ml.feature.IndexToString = idxToStr_5aef20e0ba13
``` 
``` sh
scala>   .setInputCol("prediction")
res48: labelConverter.type = idxToStr_5aef20e0ba13

scala>   .setOutputCol("predictedLabel")
res49: res48.type = idxToStr_5aef20e0ba13

scala>   .setLabels(labelIndexer.labelsArray(0))
<console>:42: error: value labelsArray is not a member of org.apache.spark.ml.feature.StringIndexer
       res49  .setLabels(labelIndexer.labelsArray(0))                                      ^
```


# Chain indexers and tree in a Pipeline.
``` sh
val pipeline = new Pipeline()
  .setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
```
``` sh
scala> val pipeline = new Pipeline()
pipeline: org.apache.spark.ml.Pipeline = pipeline_2793c58805ab

scala>   .setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
res51: pipeline.type = pipeline_2793c58805ab
```


# Train model. This also runs the indexers.
val model = pipeline.fit(trainingData)
``` sh
scala> val model = pipeline.fit(trainingData)
model: org.apache.spark.ml.PipelineModel = pipeline_2793c58805ab
```


# Make predictions.
val predictions = model.transform(testData)
``` sh
#this throws an error
```

# Select example rows to display.
predictions.select("predictedLabel", "label", "features").show(5)
``` sh 
scala> predictions.select("predictedLabel", "label", "features").show(5)
<console>:40: error: not found: value predictions
       predictions.select("predictedLabel", "label", "features").show(5)
       ````



# Select (prediction, true label) and compute test error.
val evaluator = new MulticlassClassificationEvaluator()
  .setLabelCol("indexedLabel")
  .setPredictionCol("prediction")
  .setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")
``` sh
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
``` sh
scala> val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
treeModel: org.apache.spark.ml.classification.DecisionTreeClassificationModel = DecisionTreeClassificationModel: uid=dtc_e511b167324f, depth=1, numNodes=3, numClasses=2, numFeatures=692
```


println(s"Learned classification tree model:\n ${treeModel.toDebugString}")
``` sh
scala> println(s"Learned classification tree model:\n ${treeModel.toDebugString}")
Learned classification tree model:
 DecisionTreeClassificationModel: uid=dtc_e511b167324f, depth=1, numNodes=3, numClasses=2, numFeatures=692
  If (feature 517 <= 43.0)
   Predict: 1.0
  Else (feature 517 > 43.0)
   Predict: 0.0
   ```

# Practica 4
************************* Multilayer Perceptron Classifier *************************
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

# Load the data stored in LIBSVM format as a DataFrame.
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
``` sh
scala> val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
22/11/17 11:38:40 WARN ProcfsMetricsGetter: Exception when trying to compute pagesize, as a result reporting of ProcessTree metrics is stopped
22/11/17 11:38:40 WARN LibSVMFileFormat: 'numFeatures' option not specified, determining the number of features by going though the input. If you know the number in advance, please specify it via 'numFeatures' option to avoid the extra scan.
data: org.apache.spark.sql.DataFrame = [label: double, features: vector]
```


# Split the data into train and test
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)
``` sh
scala> val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
splits: Array[org.apache.spark.sql.Dataset[org.apache.spark.sql.Row]] = Array([label: double, features: vector], [label: double, features: vector])

scala> val train = splits(0)
train: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]

scala> val test = splits(1)
test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: double, features: vector]
```


# specify layers for the neural network:
# input layer of size 4 (features), two intermediate of size 5 and 4
# and output of size 3 (classes)
val layers = Array[Int](4, 5, 4, 3)
``` sh
scala> val layers = Array[Int](4, 5, 4, 3)
layers: Array[Int] = Array(4, 5, 4, 3)
```


# create the trainer and set its parameters
val trainer = new MultilayerPerceptronClassifier()
  .setLayers(layers)
  .setBlockSize(128)
  .setSeed(1234L)
  .setMaxIter(100)
``` sh
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


# train the model
val model = trainer.fit(train)
``` sh
scala> val model = trainer.fit(train)
model: org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel = MultilayerPerceptronClassificationModel: uid=mlpc_5067aa771461, numLayers=4, numClasses=3, numFeatures=4
```


# compute accuracy on the test set
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator()
  .setMetricName("accuracy")
``` sh
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
``` sh
scala> println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
Test set accuracy = 0.9523809523809523
```

# Evaluation Practice Unit 2
************************* Multilayer Perceptron Classifier *************************
# Se cargo un dF Iris.csv se importo las librerias que se usaran para hacer un modelo de ML.
Iris.csv
``` sh
scala> import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier

scala> import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

scala> import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.IndexToString

scala> import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.StringIndexer

scala> import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorIndexer

scala> import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.VectorAssembler

scala> import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.Pipeline
``` 
#Cargar la sesión de Spark

scala> val iris = spark.read.option("header", "true").option("inferSchema", "true").format("csv").load("iris.csv")
``` sh
iris: org.apache.spark.sql.DataFrame = [sepal_length: double, sepal_width: double ... 3 more fields]
``` 
# Imprimir es esquema 
scala> iris.printSchema()
``` sh
root
 |-- sepal_length: double (nullable = true)
 |-- sepal_width: double (nullable = true)
 |-- petal_length: double (nullable = true)
 |-- petal_width: double (nullable = true)
 |-- species: string (nullable = true)
``` 
# Se imprimen las principales 5 columnas
scala> iris.show(5)
``` sh
+------------+-----------+------------+-----------+-------+
|sepal_length|sepal_width|petal_length|petal_width|species|
+------------+-----------+------------+-----------+-------+
|         5.1|        3.5|         1.4|        0.2| setosa|
|         4.9|        3.0|         1.4|        0.2| setosa|
|         4.7|        3.2|         1.3|        0.2| setosa|
|         4.6|        3.1|         1.5|        0.2| setosa|
|         5.0|        3.6|         1.4|        0.2| setosa|
+------------+-----------+------------+-----------+-------+
only showing top 5 rows
``` 
# se utiliza el siguiente método para conocer e identificar más el DF.
scala> iris.describe().show()
``` sh
+-------+------------------+-------------------+------------------+------------------+---------+
|summary|      sepal_length|        sepal_width|      petal_length|       petal_width|  species|
+-------+------------------+-------------------+------------------+------------------+---------+
|  count|               150|                150|               150|               150|      150|
|   mean| 5.843333333333335| 3.0540000000000007|3.7586666666666693|1.1986666666666672|     null|
| stddev|0.8280661279778637|0.43359431136217375| 1.764420419952262|0.7631607417008414|     null|
|    min|               4.3|                2.0|               1.0|               0.1|   setosa|
|    max|               7.9|                4.4|               6.9|               2.5|virginica|
+-------+------------------+-------------------+------------------+------------------+---------+
``` 
# Clasificar las etiquetas, debido a que solo hay un string se utilizaran los metodos assembler para hacer los arreglos en las caracteristicas para clasificar Features.
``` sh
scala> val assembler = new VectorAssembler().setInputCols(Array("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features")
assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_027f5f955c4e, handleInvalid=error, numInputCols=4
# se indica que todas las columnas sera nuestro features.
scala> val features = assembler.transform(iris)
features: org.apache.spark.sql.DataFrame = [sepal_length: double, sepal_width: double ... 4 more fields]
# Con Indexer label se va convertir un dato categorico a uno numerico en este caso el indexer sería Species y el string indexedlebel.
scala> val indexerLabel = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(features)
indexerLabel: org.apache.spark.ml.feature.StringIndexerModel = StringIndexerModel: uid=strIdx_d7cf7574a153, handleInvalid=error
# En este se creara el nuevo vector indexedFeatures para terminar de limpiar los datos.
scala> val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4)
indexerFeatures: org.apache.spark.ml.feature.VectorIndexer = vecIdx_73016f4578db
# Se van a separar los datos en un 70% y un 30% en el sandomsplit con un Seed = 12345 que siempre nos va dar el mismo valor.
scala> val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 12345)
training: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [sepal_length: double, sepal_width: double ... 4 more fields]
test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [sepal_length: double, sepal_width: double ... 4 more fields]
# Aqui es donde se proyectaban en una red neuronal en un arreglo dividida en entradas, intermedias y salida donde nuestro modelo tiene 4 Features.
scala> val layers = Array[Int](4, 5, 4, 3)
layers: Array[Int] = Array(4, 5, 4, 3)
# en esta instancia se ponen parametros y ajustes de la arquitectura para la creación de la red neuronal.
scala> val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(1234).setMaxIter(100)
trainer: org.apache.spark.ml.classification.MultilayerPerceptronClassifier = mlpc_58ebf9981beb
# en este parametro se vuelve a convertir las variables de un index a un string.
scala> val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)
warning: one deprecation (since 3.0.0); for details, enable `:setting -deprecation' or `:replay -deprecation'
converterLabel: org.apache.spark.ml.feature.IndexToString = idxToStr_5e4840944eb8
``` 
#  en este arreglo que integraran todas las transformaciones para crear un ajuste para el Fit.
``` sh
scala> val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, trainer, converterLabel))
pipeline: org.apache.spark.ml.Pipeline = pipeline_e46ef96f0d2a
 # Entrenamiento del modelo.
scala> val model = pipeline.fit(training)
model: org.apache.spark.ml.PipelineModel = pipeline_e46ef96f0d2a
# con los test se prueba el modelo 
scala> val results = model.transform(test)
results: org.apache.spark.sql.DataFrame = [sepal_length: double, sepal_width: double ... 10 more fields]
``` 
# Se va evaluar las clasificaciones realizadas ejecutando un reporte con las metricas.
``` sh
scala> val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
evaluator: org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator = MulticlassClassificationEvaluator: uid=mcEval_aa8ced32e6dd, metricName=accuracy, metricLabel=0.0, beta=1.0, eps=1.0E-15
```
# Aqui Probamos el modelo y sacamos el accuracy donde si es mayor de 0.95 es un buen modelo, entre mas cercano al 1 = 100% es mejor. 
``` sh
scala> val accuracy = evaluator.evaluate(results)
accuracy: Double = 0.9705882352941176

scala> println("Error = " + (1.0 - accuracy))
Error = 0.02941176470588236
``` 