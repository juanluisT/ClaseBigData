
//## Evaluation Practice 
//# 1. Comienza una simple sesión Spark. #Edgar Cadena
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
//# 2. Cargue el archivo Netflix Stock CSV en dataframe llamado df, haga que Spark infiera los tipos de datos. #Edgar Cadena

val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

import spark.implicits._
//# 3. ¿Cuáles son los nombres de las columnas? #Edgar Cadena
df.columns
``` sh
res1: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
```
//# 4. ¿Cómo es el esquema? #Edgar Cadena
df.printSchema()
``` sh 
res2: |-- Date: timestamp (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)
 ```
//# 5. Imprime las primeras 5 renglones. #Edgar Cadena
df.show(5)
``` sh 
|               Date|      Open|              High|       Low|            Close|   Volume|         Adj Close|
+-------------------+----------+------------------+----------+-----------------+---------+------------------+
|2011-10-24 00:00:00|119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|
|2011-10-25 00:00:00| 74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|
|2011-10-26 00:00:00|     78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|
|2011-10-27 00:00:00| 82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|
|2011-10-28 00:00:00| 80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|
+-------------------+----------+------------------+----------+-----------------+---------+------------------+
only showing top 5 rows
```
//# 6. Usa el método describe () para aprender sobre el DataFrame. #Edgar Cadena
df.describe().show()
``` sh 
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|summary|              Open|              High|               Low|             Close|              Volume|         Adj Close|
+-------+------------------+------------------+------------------+------------------+--------------------+------------------+
|  count|              1259|              1259|              1259|              1259|                1259|              1259|
|   mean|230.39351086656092|233.97320872915006|226.80127876251044|  230.522453845909|2.5634836060365368E7|55.610540036536875|
| stddev|164.37456353264244| 165.9705082667129| 162.6506358235739|164.40918905512854| 2.306312683388607E7|35.186669331525486|
|    min|         53.990001|         55.480001|             52.81|              53.8|             3531300|          7.685714|
|    max|        708.900017|        716.159996|        697.569984|        707.610001|           315541800|        130.929993|
```
//# 7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la relación que existe entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día. Hint - es una operación #Edgar Cadena
val df2 = df.withColumn("HV Ratio", df("High")*df("Volume"))
``` sh 
df2: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 6 more fields]
```
//#8. ¿Qué día tuvo el pico más alto en la columna “Open”?

//#9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de información
financiera, explíquelo no hay que codificar nada?

//#10. ¿Cuál es el máximo y mínimo de la columna “Volumen”?


//#11. Con Sintaxis Scala/Spark $ conteste lo siguiente:

a) ¿Cuántos días fue la columna “Close” inferior a $ 600? 
scala> df .filter ($"Close" > 600) .show ()
```sh
+-------------------+-----------------+-----------------+-----------------+-----------------+--------+-----------------+
|               Date|             Open|             High|              Low|            Close|  Volume|        Adj Close|
+-------------------+-----------------+-----------------+-----------------+-----------------+--------+-----------------+
|2015-05-15 00:00:00|       604.550018|618.4400019999999|       600.290001|       613.249977|37053100|         87.60714|
|2015-05-18 00:00:00|        612.81002|       619.740005|       609.169991|       617.870003|14812000|        88.267143|
|2015-05-19 00:00:00|       622.220009|       628.499992|       614.669983|       616.480011|19101600|        88.068573|
|2015-05-20 00:00:00|       617.500008|       623.760017|       611.539978|       621.530006|12756800|        88.790001|
|2015-05-21 00:00:00|           623.57|626.9999849999999|       617.269989|       623.019974|12767300|        89.002853|
|2015-05-22 00:00:00|624.2500150000001|       625.849998|       620.849991|       621.869987| 7466200|88.83856999999999|
|2015-05-26 00:00:00|622.1199799999999|       623.430023|       614.499992|       615.950012| 9646000|        87.992859|
|2015-05-27 00:00:00|       617.000023|       629.349998|615.5000150000001|       628.999977|10506300|         89.85714|
|2015-05-28 00:00:00|       628.000008|        628.98999|       622.510002|       626.549988| 7821800|        89.507141|
|2015-05-29 00:00:00|       626.309982|        631.43998|        622.68998|624.0599980000001|12712000|89.15142800000001|
|2015-06-01 00:00:00|       621.860001|       623.850006|615.6099780000001|       623.019974| 9926000|        89.002853|
|2015-06-02 00:00:00|        620.97998|627.7500150000001|       618.840012|623.9099809999999| 7529200|        89.129997|
|2015-06-03 00:00:00|       624.700012|       628.129997|        620.51001|       621.659996| 6223700|        88.808571|
|2015-06-04 00:00:00|       618.649994|626.0000150000001|        616.29998|625.4400019999999|10074400|89.34857199999999|
|2015-06-05 00:00:00|       624.500008|       633.780006|623.8800200000001|       633.219994|11624200|        90.459999|
|2015-06-08 00:00:00|       635.000008|       635.709984|622.9699860000001|       627.230003|11148900|        89.604286|
|2015-06-09 00:00:00|625.3399730000001|       649.000008|625.3399730000001|       647.149979|22024800|        92.449997|
|2015-06-10 00:00:00|       653.769997|692.7900089999999|       652.580009|       671.100006|57121400|        95.871429|
|2015-06-11 00:00:00|       678.229996|           678.43|       658.610001|       665.659988|26623100|        95.094284|
|2015-06-12 00:00:00|664.4100269999999|       667.400002|658.8699799999999|           660.93|10278800|        94.418571|
+-------------------+-----------------+-----------------+-----------------+-----------------+--------+-----------------+
only showing top 20 rows
```
b) ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?

c) ¿Cuál es la correlación de Pearson entre columna “High” y la columna
“Volumen”?
df .select(corr("High", "Low")) .show ()
d) ¿Cuál es el máximo de la columna “High” por año?
scala> df .groupBy ("Volumen") . Max () .Show ()

e) ¿Cuál es el promedio de la columna “Close” para cada mes del calendario?

