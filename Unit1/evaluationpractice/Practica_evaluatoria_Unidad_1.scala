
// Evaluation Practice
// 1. Comienza una simple sesión Spark.
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
//# 2. Cargue el archivo Netflix Stock CSV en dataframe llamado df, haga que Spark infiera los tipos de datos.

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

import spark.implicits._
//# 3. ¿Cuáles son los nombres de las columnas? 
df.columns
``` sh
res1: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
```
//# 4. ¿Cómo es el esquema?
df.printSchema()
//# 5. Imprime las primeras 5 renglones.
df.show(5)
//# 6. Usa el método describe () para aprender sobre el DataFrame.
df.describe().show()
//# 7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la relación que existe entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día. Hint - es una operación
val df2 = df.withColumn("HV Ratio", df("High")*df("Volume"))