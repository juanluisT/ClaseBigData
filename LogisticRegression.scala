import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator


import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").option("sep",";").load("bank.csv")

//Create  numerical "x" column from string "y" column
val cols = data.select("age","job","marital","education","default","balance","housing","loan","contact","day","month","duration","campaign","pdays","previous","poutcome","y").withColumn("x", when(col("y") === "yes", 1).when(col("y") === "no", 0))

cols.printSchema()

cols.head(1)

val logregdataall = (cols.select(cols("x").as("label"), $"age", $"job",
                    $"marital", $"education", $"day", $"month", $"duration", $"campaign", $"pdays", $"previous", $"poutcome"))

val logregdata = logregdataall.na.drop()


//Convert string values into numerical values
val jobIndexer = new StringIndexer().setInputCol("job").setOutputCol("jobIndex")
val maritalIndexer = new StringIndexer().setInputCol("marital").setOutputCol("maritalIndex")
val educationIndexer = new StringIndexer().setInputCol("education").setOutputCol("educationIndex")
val monthIndexer = new StringIndexer().setInputCol("month").setOutputCol("monthIndex")
val poutcomeIndexer = new StringIndexer().setInputCol("poutcome").setOutputCol("poutcomeIndex")

//Convert numerical values into OneHot Encoding 0 -1
val jobEncoder = new OneHotEncoder().setInputCol("jobIndex").setOutputCol("JobVec")
val maritalEncoder = new OneHotEncoder().setInputCol("maritalIndex").setOutputCol("MaritalVec")
val educationalEncoder = new OneHotEncoder().setInputCol("educationIndex").setOutputCol("EducationVec")
val monthEncoder = new OneHotEncoder().setInputCol("monthIndex").setOutputCol("monthVec")
val poutcomeEncoder = new OneHotEncoder().setInputCol("poutcomeIndex").setOutputCol("PoutcomeVec")


// ====================================================================
//                         Logistic Regression
// ====================================================================


val assembler = (new VectorAssembler()
                  .setInputCols(Array("age","JobVec","MaritalVec","EducationVec","day","monthVec","duration","campaign","pdays","previous","PoutcomeVec"))
                  .setOutputCol("features"))


val Array(training, test) = logregdata.randomSplit(Array(0.6, 0.5), seed = 12345)

val lr = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(jobIndexer,maritalIndexer,educationIndexer,monthIndexer,poutcomeIndexer,
                    jobEncoder,maritalEncoder,educationalEncoder,monthEncoder,poutcomeEncoder,assembler,lr))

val model = pipeline.fit(training)

val results = model.transform(test)

//Model testing
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

val evaluador = new MulticlassClassificationEvaluator().setMetricName("accuracy")

println("Confusion matrix:")
println(metrics.confusionMatrix)
println(s"accuracy = ${evaluador.evaluate(results)}")