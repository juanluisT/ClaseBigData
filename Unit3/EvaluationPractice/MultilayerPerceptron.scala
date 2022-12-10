import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Pipeline

//Importar librerias utilizables con el modelo multilayer
//Y los indexadores para clasificar

//Importar datos desde el csv, limpieza de datos, cambiamos var data a bank-full por el infer schema
val bank = spark.read.option("header", "true").option("inferSchema", "true").format("csv").load("bank-full.csv")

//Nombres de las columnas, Ver cómo es el esquema y describe () para aprender más sobre los datos del DataFrame.
bank.na.drop().show(false)
bank.show(0)
bank.describe().show()
bank.printSchema()

// Deal with Categorical Columns
// Transform string type columns to string indexer 
val jobIndexer = new StringIndexer().setInputCol("job").setOutputCol("jobIndex")
val educationIndexer = new StringIndexer().setInputCol("education").setOutputCol("educationIndex")
val maritalIndexer = new StringIndexer().setInputCol("marital").setOutputCol("maritalIndex")
val defaultIndexer = new StringIndexer().setInputCol("default").setOutputCol("defaultIndex")
val housingIndexer = new StringIndexer().setInputCol("housing").setOutputCol("housingIndex")
val loanIndexer = new StringIndexer().setInputCol("loan").setOutputCol("loanIndex")
val contactIndexer = new StringIndexer().setInputCol("contact").setOutputCol("contactIndex")
val monthIndexer = new StringIndexer().setInputCol("month").setOutputCol("monthIndex")
val poutcomeIndexer = new StringIndexer().setInputCol("poutcome").setOutputCol("poutcomeIndex")

val indexed = educationIndexer.fit(bank).transform(bank)
val indexed1 = jobIndexer.fit(indexed).transform(indexed)
val indexed2 = maritalIndexer.fit(indexed1).transform(indexed1)
val indexed3 = defaultIndexer.fit(indexed2).transform(indexed2)
val indexed4 = housingIndexer.fit(indexed3).transform(indexed3)
val indexed5 = loanIndexer.fit(indexed4).transform(indexed4)
val indexed6 = contactIndexer.fit(indexed5).transform(indexed5)
val indexed7 = monthIndexer.fit(indexed6).transform(indexed6)
val indexed8 = poutcomeIndexer.fit(indexed7).transform(indexed7)
//delete columns
indexed8.drop("job","marital","education","default","housing","loan","contact","month", "poutcome").show(false)
// Assemble everything together to be ("label","features") format
//Haga la transformación pertinente para los datos categóricos los cuales serán nuestras etiquetas a clasificar.
val assembler = new VectorAssembler().setInputCols(Array("age","jobIndex","maritalIndex","educationIndex","defaultIndex","balance","housingIndex","loanIndex","contactIndex","day","monthIndex","duration","campaign","pdays","previous","poutcomeIndex")).setOutputCol("features")
//val assembler = new VectorAssembler().setInputCols(Array("age","jobVec","maritalVec","educationVec","defaultVec","balance","housingVec","loanVec","contactVec","day","monthVec","duration","campaign","pdays","previous","poutcomeVec")).setOutputCol("features")

val features = assembler.transform(indexed8)
// Agarra un dato categorico y lo vuelve numerico
val indexerLabel = new StringIndexer().setInputCol("y").setOutputCol("indexedLabel").fit(features)
val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(16)
val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 7777)

// //Construir el modelo de clasificación y explique su arquitectura.
val layers = Array[Int](16, 3, 2)
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(12345).setSeed(1234).setMaxIter(123)
val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)
val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, trainer, converterLabel))
val model = pipeline.fit(training)

// //Resultados del modelo y de sus observaciones.
val results = model.transform(test)
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(results)
println("Error = " + (1.0 - accuracy))