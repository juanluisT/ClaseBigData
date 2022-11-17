import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.Pipeline

val iris = spark.read.option("header", "true").option("inferSchema", "true").format("csv").load("iris.csv")

//val df = iris.withColumn("sepal_length",$"sepal_length".cast("double")).withColumn("sepal_width",$"sepal_width".cast("double")).withColumn("petal_length", $"petal_length".cast("double")).withColumn("petal_width", $"petal_width".cast("double"))

iris.printSchema()

iris.show(5)

iris.describe().show()

val assembler = new VectorAssembler().setInputCols(Array("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features")

val features = assembler.transform(iris)

val indexerLabel = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(features)

val indexerFeatures = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4)

val Array(training, test) = features.randomSplit(Array(0.7, 0.3), seed = 12345)

val layers = Array[Int](4, 5, 4, 3)

val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(1234).setMaxIter(100)

val converterLabel = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(indexerLabel.labels)

val pipeline = new Pipeline().setStages(Array(indexerLabel, indexerFeatures, trainer, converterLabel))

val model = pipeline.fit(training)

val results = model.transform(test)

val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

val accuracy = evaluator.evaluate(results)

println("Error = " + (1.0 - accuracy))
