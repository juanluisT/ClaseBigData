import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
import org.apache.log4j._
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics

Logger.getLogger("org").setLevel(Level.ERROR)

val spark = SparkSession.builder().getOrCreate()

val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("bank.csv")


data.show(0)
data.describe().show()
val yIndexer = new StringIndexer().setInputCol("y").setOutputCol("yIndex")
val data1 = yIndexer.fit(data).transform(data)
data1.printSchema()
val logregdataall = (data1.select(data1("yIndex").as("label"), $"age",$"job", $"marital",
                    $"education", $"default", $"balance", $"housing", $"loan", $"contact", $"day", $"month", $"duration", $"campaign", $"pdays", $"previous", $"poutcome"))

val logregdata = logregdataall.na.drop()

// Convertir strings a valores numericos - Transforming string into numerical values
val jobIndexer = new StringIndexer().setInputCol("job").setOutputCol("jobIndex")
val educationIndexer = new StringIndexer().setInputCol("education").setOutputCol("educationIndex")
val maritalIndexer = new StringIndexer().setInputCol("marital").setOutputCol("maritalIndex")
val defaultIndexer = new StringIndexer().setInputCol("default").setOutputCol("defaultIndex")
val housingIndexer = new StringIndexer().setInputCol("housing").setOutputCol("housingIndex")
val loanIndexer = new StringIndexer().setInputCol("loan").setOutputCol("loanIndex")
val contactIndexer = new StringIndexer().setInputCol("contact").setOutputCol("contactIndex")
val monthIndexer = new StringIndexer().setInputCol("month").setOutputCol("monthIndex")
val poutcomeIndexer = new StringIndexer().setInputCol("poutcome").setOutputCol("poutcomeIndex")

// Convertir los valores numericos a One Hot Encoding 0 - 1
val jobEncoder = new OneHotEncoder().setInputCol("jobIndex").setOutputCol("jobVec")
val educationEncoder = new OneHotEncoder().setInputCol("educationIndex").setOutputCol("educationVec")
val maritalEncoder = new OneHotEncoder().setInputCol("maritalIndex").setOutputCol("maritalVec")
val defaultEncoder = new OneHotEncoder().setInputCol("defaultIndex").setOutputCol("defaultVec")
val housingEncoder = new OneHotEncoder().setInputCol("housingIndex").setOutputCol("housingVec")
val loanEncoder = new OneHotEncoder().setInputCol("loanIndex").setOutputCol("loanVec")
val contactEncoder = new OneHotEncoder().setInputCol("contactIndex").setOutputCol("contactVec")
val monthEncoder = new OneHotEncoder().setInputCol("monthIndex").setOutputCol("monthVec")
val poutcomeEncoder = new OneHotEncoder().setInputCol("poutcomeIndex").setOutputCol("poutcomeVec")
// Assemble everything together to be ("label","features") format
//Haga la transformación pertinente para los datos categóricos los cuales serán nuestras etiquetas a clasificar.
val assembler = new VectorAssembler().setInputCols(Array("age","jobVec","maritalVec","educationVec","defaultVec","balance","housingVec","loanVec","contactVec","day","monthVec","duration","campaign","pdays","previous","poutcomeVec")).setOutputCol("features")

val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 45354)

val lr = new LogisticRegression()

val pipeline = new Pipeline().setStages(Array(jobIndexer,maritalIndexer,educationIndexer,defaultIndexer,housingIndexer,loanIndexer,contactIndexer,monthIndexer,poutcomeIndexer,jobEncoder,maritalEncoder,educationEncoder,defaultEncoder,housingEncoder,loanEncoder,contactEncoder,monthEncoder,poutcomeEncoder,assembler,lr))

val model = pipeline.fit(training)

val results = model.transform(test)

val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

// Matriz de confusion
println("Confusion matrix:")
println(metrics.confusionMatrix)

metrics.accuracy