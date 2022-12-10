import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

// Optional: Utilizar el codigo de  Error reporting
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
// Cree un sesion Spark 

val spark = SparkSession.builder().getOrCreate()
```
//scala> val spark = SparkSession.builder().getOrCreate()
spark: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@7a3742ec
```

// Utilice Spark para leer el archivo csv .
val bank  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("bank.csv")
``` 
//scala> val bank  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("bank.csv")
bank: org.apache.spark.sql.DataFrame = [age: int, job: string ... 15 more fields]
```


// print Schema
bank.printSchema()
```
//scala> bank.printSchema()
//resultados:
root
 |-- age: integer (nullable = true)
 |-- job: string (nullable = true)
 |-- marital: string (nullable = true)
 |-- education: string (nullable = true)
 |-- default: string (nullable = true)
 |-- balance: integer (nullable = true)
 |-- housing: string (nullable = true)
 |-- loan: string (nullable = true)
 |-- contact: string (nullable = true)
 |-- day: integer (nullable = true)
 |-- month: string (nullable = true)
 |-- duration: integer (nullable = true)
 |-- campaign: integer (nullable = true)
 |-- pdays: integer (nullable = true)
 |-- previous: integer (nullable = true)
 |-- poutcome: string (nullable = true)
 |-- y: string (nullable = true)
 ```


 bank.describe().show()
 ```
 //resultados:
+-------+------------------+-------+--------+---------+-------+------------------+-------+-----+--------+-----------------+-----+-----------------+-----------------+------------------+------------------+--------+-----+
|summary|               age|    job| marital|education|default|           balance|housing| loan| contact|              day|month|         duration|       
  campaign|             pdays|          previous|poutcome|    y|
+-------+------------------+-------+--------+---------+-------+------------------+-------+-----+--------+-----------------+-----+-----------------+-----------------+------------------+------------------+--------+-----+
|  count|             45211|  45211|   45211|    45211|  45211|             45211|  45211|45211|   45211|            45211|45211|            45211|       
     45211|             45211|             45211|   45211|45211|
|   mean| 40.93621021432837|   null|    null|     null|   null|1362.2720576850766|   null| null|    null|15.80641879188693| null|258.1630797814691|2.763840658246887| 40.19782796222158|0.5803233726305546|    null| null|
| stddev|10.618762040975405|   null|    null|     null|   null|3044.7658291685257|   null| null|    null|8.322476153044594| null|257.5278122651706|3.098020883279192|100.12874599059828| 2.303441044931218|    null| null|
|    min|                18| admin.|divorced|  primary|     no|             -8019|     no|   no|cellular|                1|  apr|                0|       
         1|                -1|                 0| failure|   no|
|    max|                95|unknown|  single|  unknown|    yes|            102127|    yes|  yes| unknown|               31|  sep|             4918|       
        63|               871|               275| unknown|  yes|
+-------+------------------+-------+--------+---------+-------+------------------+-------+-----+--------+-----------------+-----+-----------------+-----------------+------------------+------------------+--------+-----+
````


val assembler = new VectorAssembler().setInputCols(Array("age", "job", "education", "default")).setOutputCol("features")
```
assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_fa96b125d117, handleInvalid=error, numInputCols=4
```

val features = assembler.transform(bank)
val indexerLabel = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(features)

// Imprima un renglon de ejemplo 

bank.head(1)
```
//scala> bank.head(1)
res4: Array[org.apache.spark.sql.Row] = Array([58,management,married,tertiary,no,2143,yes,no,unknown,5,may,261,1,-1,0,unknown,no])
```

val colnames = bank.columns
val firstrow = bank.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}

```
//scala> val colnames = bank.columns
colnames: Array[String] = Array("age";"job";"marital";"education";"default";"balance";"housing";"loan";"contact";"day";"month";"duration";"campaign";"pdays";"previous";"poutcome";"y")

//scala> val firstrow = bank.head(1)(0)
firstrow: org.apache.spark.sql.Row = [30;"unemployed";"married";"primary";"no";1787;"no";"no";"cellular";19;"oct";79;1;-1;0;"unknown";"no"]

//scala> println("\n")

//scala> println("Example data row")
//Example data row

scala> for(ind <- Range(1, colnames.length)){
     |     println(colnames(ind))
     |     println(firstrow(ind))
     |     println("\n")
     | }
     

// Importe VectorAssembler y Vectors
// Cree un nuevo objecto VectorAssembler llamado assembler para los feature
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

//"age";"job";"marital";"education";"default";"balance";"housing";"loan";"contact";"day";"month";"duration";"campaign";"pdays";"previous";"poutcome";"y"

val assembler = (new VectorAssembler().setInputCols(Array("age", "job","marital","education","default"," balance","housing","loan")).setOutputCol("features"))
```
assembler: org.apache.spark.ml.feature.VectorAssembler = VectorAssembler: uid=vecAssembler_b3022811ec1b, handleInvalid=error, numInputCols=8
```


////////////////////////////////////////////////////
//// Preparar el DataFrame para Machine Learning ////
//////////////////////////////////////////////////

//    - Cree una nueva clolumna llamada "Time" del duration conteniendo la  "Hour of the click"
val timebank = bank.withColumn("Time",hour(bank("month")))
```
timebank: org.apache.spark.sql.DataFrame = [age: int, job: string ... 16 more fields]
```

val logregbank = timebank.select(bank("month").as("label"), $"age", $"job", $"marital", $"education", $"default", $"Time", $"contact")
```
logregbank: org.apache.spark.sql.DataFrame = [label: string, age: int ... 6 more fields]
```

// Utilice randomSplit para crear datos de train y test divididos en 70/30
val Array(training, test) = logregbank.randomSplit(Array(0.7, 0.3), seed = 12345)
```
training: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: string, age: int ... 5 more fields]
test: org.apache.spark.sql.Dataset[org.apache.spark.sql.Row] = [label: string, age: int ... 5 more fields]
```

///////////////////////////////
// Configure un Pipeline ///////
/////////////////////////////

// Importe  Pipeline
// Cree un nuevo objeto de  LogisticRegression llamado lr

// Cree un nuevo  pipeline con los elementos: assembler, lr

// Ajuste (fit) el pipeline para el conjunto de training.


// Tome los Resultados en el conjuto Test con transform

val lr = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(assembler, lr))

val model = pipeline.fit(training)

val results = model.transform(test)

import org.apache.spark.mllib.evaluation.MulticlassMetrics

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy