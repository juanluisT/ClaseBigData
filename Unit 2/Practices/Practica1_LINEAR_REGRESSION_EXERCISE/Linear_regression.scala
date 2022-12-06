////////////////////////////////////////////
//// LINEAR REGRESSION EXERCISE ///////////
/// Coplete las tareas comentadas ///
/////////////////////////////////////////

// Import LinearRegression
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

// Opcional: Utilice el siguiente codigo para configurar errores
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Inicie una simple Sesion Spark
val spark = SparkSession.builder().getOrCreate()

// Utilice Spark para el archivo csv Clean-Ecommerce .
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Clean-Ecommerce.csv")

// Imprima el schema en el DataFrame.
data.printSchema()

// Imprima un renglon de ejemplo del DataFrane.

data.head(1)
val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}
//////////////////////////////////////////////////////
//// Configure el DataFrame para Machine Learning ////
//////////////////////////////////////////////////////

// Transforme el data frame para que tome la forma de
// ("label","features")

// Importe VectorAssembler y Vectors
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
// Renombre la columna Yearly Amount Spent como "label"
// Tambien de los datos tome solo la columa numerica 
// Deje todo esto como un nuevo DataFrame que se llame df
data.columns
val df = data.select(data("Yearly Amount Spent").as("label"), $"Length of Membership", $"Time on Website", $"Time on App", $"Avg Session Length")

// Que el objeto assembler convierta los valores de entrada a un vector
val assembler = new VectorAssembler().setInputCols(Array("Length of Membership", "Time on Website", "Time on App", "Avg Session Length")).setOutputCol("features")

// Utilice el objeto VectorAssembler para convertir la columnas de entradas del df
val output = assembler.transform(df).select($"label", $"features")

// a una sola columna de salida de un arreglo llamado  "features"
output.show()

// Configure las columnas de entrada de donde se supone que leemos los valores.
// Llamar a esto nuevo assambler.
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

val assembler = (new VectorAssembler()
                  .setInputCols(Array("Length of Membership", "Time on Website","Time on App","Avg Session Length","Avatar","Email"))
                  .setOutputCol("features"))
// Utilice el assembler para transform nuestro DataFrame a dos columnas: label and features


// Crear un objeto para modelo de regresion linea.
val lr = new LinearRegression()

// Ajuste el modelo para los datos y llame a este modelo lrModelo
val lrModel = lr.fit(output)
val trainingSummary = lrModel.summary
/*
trainingSummary.residuals.show()
trainingSummary.predictions.show()
trainingSummary.r2 //variaza que hay 
trainingSummary.rootMeanSquaredError
*/

// Imprima the  coefficients y intercept para la regresion lineal
println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

// Resuma el modelo sobre el conjunto de entrenamiento imprima la salida de algunas metricas!
// Utilize metodo .summary de nuestro  modelo para crear un objeto
// llamado trainingSummary
// Muestre los valores de residuals, el RMSE, el MSE, y tambien el R^2 .
  val trainingSummary = lrModel.summary
  println(s"numIterations: ${trainingSummary.totalIterations}")
  println(s"objectiveHistory: ${trainingSummary.objectiveHistory.toList}")
  trainingSummary.residuals.show()
  println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
  println(s"r2: ${trainingSummary.r2}")

// Buen trabajo!