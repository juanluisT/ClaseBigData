# ClaseBigData


#  ************************* Practice 2 "Edgar C."  *************************

1. Crear un repositorio con el nombre ClaseBigData
2. No creear el archivo README.md
3. Seguir las intrucciones de Github
4. Crear una rama llamada develop o development
5. Generar esta rama por default en Github
6. Crear una rama llamada Unit1
7. Agragar colaboradores para trabajar en equipo
8. Cada integrante generar algun cambio en el Archivo REDME.md y hacer todo el gitflow
9. Mostrar al profe la estructura de su repositorio.








# *****************practice #3 *************************
# 1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
var radio = "el radio de 2 es "+ 2 * Math.PI*3

# 1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
var radio = "el radio de 2 es "+ 2 * Math.PI*3


# 2. Desarrollar un algoritmo en scala que me diga si un numero es primo
var num = 5
if (num % 2 == 0) {
printf("No es número primo")
} else {
printf("Si es número primo")
}

# 3. Dada la variable bird = "tweet", utiliza interpolacion de string para
#   imprimir "Estoy ecribiendo un tweet"
val bird = "tweet"
val birdy = s"Estoy ecribiendo un ${bird}"


# 4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
#   secuencia "Luke"
val Luk = "Hola Luke yo soy tu padre!"
# Luk.slice (5,9)

# 5. Cual es la diferencia entre value y una variable en scala?
     "var se puede modificar"
     "val es constante"

# 6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416 
val my_tup = (2,4,5,1,2,3,3.1416,23)
#  my_tup._7

# 3. Dada la variable bird = "tweet", utiliza interpolacion de string para
#   imprimir "Estoy ecribiendo un tweet"
val bird = "tweet"
val birdy = s"Estoy ecribiendo un ${bird}"


# 4. Dada la variable mensaje = "Hola Luke yo soy tu padre!" utiliza slilce para extraer la
#   secuencia "Luke"
val Luk = "Hola Luke yo soy tu padre!"
# Luk.slice (5,9)

# 5. Cual es la diferencia entre value y una variable en scala?
     "var se puede modificar"
     "val es constante"

# 6. Dada la tupla (2,4,5,1,2,3,3.1416,23) regresa el numero 3.1416 
val my_tup = (2,4,5,1,2,3,3.1416,23)
# my_tup._7









#  *************************practice #4 *************************

# 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"

val lista = collection.mutable.Set("rojo", "blanco", "negro")
lista.toSet

# 2. Añadir 5 elementos mas a "lista" "verde" ,"amarillo", "azul", "naranja", "perla"
lista += ("verde", "amarillo", "azul", "naranja", "perla")
lista.toSet

# 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
for(list <- lista){
    if(list.startsWith("v") || list.startsWith("a")){
        println(s"$list")
    }
}

# 4. Crea un arreglo de numero en rango del 1-1000 en pasos de 5 en 5
Array.range(0, 1000, 5)

# 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
val mylst = List(1,3,3,4,6,7,3,7)
mylst.toSet

# 6. Crea una mapa mutable llamado nombres que contenga los siguiente
#    "Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27"
val mutbl = collection.mutable.Map(("Jose", 20), ("Luis", 24), ("Ana", 23), ("Susana", "27"))

# 6 a . Imprime todas la llaves del mapa
mutbl.keys

# 6 b . Agrega el siguiente valor al mapa("Miguel", 23)
mutbl += (("Miguel", 23))
mutbl.keys
mutbl.values










#  *************************practice #5 *************************

 def isEven(num:Int): Boolean = {
     return num%2 == 0
 }
 def isEven(num:Int): num%2 == 0
 println(isEven(6))
 println(isEven(3))
 Practice 3, analyse the following code with your own words

def listEvens(list:List[Int]): String ={ //starts function, prits a string 
    for(n <- list){ // open a 'for' which prints each number in  the list
        if(n%2==0){  //starts 'if' checks if the number is divisible by 2
            println(s"$n is even") //prints if the the number is even(divisible by 2)
        }//close 'if'
        else{ //start 'else' if is not divisible by 2 continues to print odd
            println(s"$n is odd") // prints if the number is odd (not divisible by 2)
        }///close 'else'
    }// ends 'for'
    return "Done" // prints when the list reaches the end
} //end function listEvens

val l = List(1,2,3,4,5,6,7,8) //list of values l
val l2 = List(4,3,22,55,7,8) //list of values l2
listEvens(l) // calls function with values from the list l
listEvens(l2)  // calls function with values from the list l2

## afortunado
def afortunado(list:List[Int]): Int={ ///start function 'afortunado' output integer
    var res=0 // initialize varible 'res'
    for(n <- list){ //starts 'for'
        if(n==7){ // start if
            res = res + 14 //add 'res' plus 14
        }//ends 'if
            else{ //start 'else'
            res = res + n //add 'res' plus 'n'
        }//end 'else'
    } //end 'for'
    return res  //returns results
} //close function

val af= List(1,7,7) //arbitray data for val 'af'
println(afortunado(af)) //print function with val 'af'


# inicializar funcion balance que regresa un valor verdadero o falso
def balance(list:List[Int]): Boolean={ // inicializar funcion balance que regresa un valor verdadero o falso
    var primera = 0 // inicia variable "primera"
    var segunda = 0 // inicia variable "segunda"

    segunda = list.sum // inicia suma de la lista "segunda"

    for(i <- Range(0,list.length)){ // inicio  de "for" con el rango de la lista 
        primera = primera + list(i) // la lista que se inicio mas la (i)
        segunda = segunda - list(i) // la lista que se inicia se resta a la (i)

        if(primera == segunda){ // inicia "if" y compara entre la variable 1ra y 2da 
            return true // regresa el valor verdadero
        }// termina "if"
    }// termina "For"
    return false //regresa el valor falso
} //Termina la funcion

val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)

balance(bl)
balance(bl2)
balance(bl3)

# initialize funtion 'palindromo' returns TRUE or FALSE
def palindromo(palabra:String):Boolean ={ // initialize funtion 'palindromo' returns TRUE or FALSE
    return (palabra == palabra.reverse) // revers string 'palabra'
}// end funtion 'palindromo'

val palabra = "OSO"   //initials veriables
val palabra2 = "ANNA" //
val palabra3 = "JUAN" //

println(palindromo(palabra)) //call funtion and the val 'palabra'
println(palindromo(palabra2))//call funtion and the val 'palabra2'
println(palindromo(palabra3))//call funtion and the val 'palabra3'









#  ************************* practice #6  *************************
##Algoritmo 3 Versión iterativa  (Complejidad {\displaystyle O(n)\,}O(n)\,)

 def fibonacci(n: Int): Int = {
   if ( n == 0 ) 0
   else if (  == 1 ) 1
   else fibonacci( n-1 ) + fibonacci( n-2 )
 }
 fibonacci(10)
/*********************************************/

#//Algoritmo 4 Versión iterativa
#//2 variables (Complejidad O(n)\,)
def fib(n: Int): Int = {
a = 0
b = 1
for(k <- 0 to n){
   b = b + b 
   a = b + a
}
return b
}
fib(10)


#Algoritmo 5 Versión iterativa vector (Complejidad {\displaystyle O(n)\,}O(n)\,)
//def fib(n: Int): Int = {
//if ( n <2 )
 // return n
//else if()

//for(a <- 0 to n+1){
//}
//}

//fib(10)









#  ************************* Practice 7  *************************

// #1MUESTRA LOS DTOS fecha_alta MENORES A 2019-11
INEGI_df.filter("fecha_alta" < 2019-11).show()
//#2 MUESTRA LOS DTOS codigo_act MAYOREAS A 115111
INEGI_df.filter("codigo_act > 115111").show()

// #3MUESTRA LOS DTOS codigo_act ENTRE 114119 Y 115111
INEGI_df.filter("codigo_act BETWEEN 114119 AND 115111").show()

// #4 MUESTRA LOS DTOS AGRUPADOS y CONTADOS POR municipio 
INEGI_df.groupBy("cod_postal").count().show()

// #5 MUESTRA LOS DTOS AGRUPADOS por cod_postal y municipio y CONTADOS POR cod_postal 
INEGI_df.groupBy("cod_postal" , "municipio").count().show()

// #6 muestra los datos ordenado porcve_mun (clave municipal)
INEGI_df.orderBy("cve_mun").show()


************************* Practica Evaluatoria Unidad 1  *************************

# 1. Comienza una simple sesión Spark. #Edgar Cadena
``` sh
import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()
``` 

# 2. Cargue el archivo Netflix Stock CSV en dataframe llamado df, haga que Spark infiera los tipos de datos. #Edgar Cadena
``` sh
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

import spark.implicits._
```
# 3. ¿Cuáles son los nombres de las columnas? #Edgar Cadena
df.columns
``` sh
res1: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)
```
# 4. ¿Cómo es el esquema? #Edgar Cadena
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

# 5. Imprime las primeras 5 renglones. #Edgar Cadena
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
# 6. Usa el método describe () para aprender sobre el DataFrame. #Edgar Cadena
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
# 7. Crea un nuevo dataframe con una columna nueva llamada “HV Ratio” que es la relación que existe entre el precio de la columna “High” frente a la columna “Volumen” de acciones negociadas por un día. Hint - es una operación 
val df2 = df.withColumn("HV Ratio", df("High")*df("Volume"))
``` sh 
df2: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 6 more fields]
```

//#8. ¿Qué día tuvo el pico más alto en la columna “Open”?

val dfx = df.groupBy("Date").agg(max($"Open"))
dfx.orderBy($"max(Open)".desc).limit(1).show()
`` sh 
scala> dfx.orderBy($"max(Open)".desc).limit(1).show()
+-------------------+----------+
|               Date| max(Open)|
+-------------------+----------+
|2015-07-14 00:00:00|708.900017|
+-------------------+----------+

``
//#9. ¿Cuál es el significado de la columna Cerrar “Close” en el contexto de información financiera, 
// # explíquelo no hay que codificar nada?

``` sh
Es el precio del cierre al dia de las acciones de NetFlix

```
//#10. ¿Cuál es el máximo y mínimo de la columna “Volumen”?
df.agg(min("Volume"), max("Volume")).show()
``` sh
scala> df.agg(min("Volume"), max("Volume")).show()
+-----------+-----------+
|min(Volume)|max(Volume)|
+-----------+-----------+
|    3531300|  315541800|
+-----------+-----------+
```

# 11. Con Sintaxis Scala/Spark $ conteste lo siguiente:

# a) ¿Cuántos días fue la columna “Close” inferior a $ 600? #Edgar Cadena
scala> df .filter ($"Close" < 600) .show ()
``` sh
+-------------------+-----------------+------------------+----------+-----------------+---------+------------------+
|               Date|             Open|              High|       Low|            Close|   Volume|         Adj Close|
+-------------------+-----------------+------------------+----------+-----------------+---------+------------------+
|2011-10-24 00:00:00|       119.100002|120.28000300000001|115.100004|       118.839996|120460200|         16.977142|
|2011-10-25 00:00:00|        74.899999|         79.390001| 74.249997|        77.370002|315541800|11.052857000000001|
|2011-10-26 00:00:00|            78.73|         81.420001| 75.399997|        79.400002|148733900|         11.342857|
|2011-10-27 00:00:00|        82.179998| 82.71999699999999| 79.249998|80.86000200000001| 71190000|11.551428999999999|
|2011-10-28 00:00:00|        80.280002|         84.660002| 79.599999|84.14000300000001| 57769600|             12.02|
|2011-10-31 00:00:00|83.63999799999999|         84.090002| 81.450002|        82.080003| 39653600|         11.725715|
|2011-11-01 00:00:00|        80.109998|         80.999998|     78.74|        80.089997| 33016200|         11.441428|
|2011-11-02 00:00:00|        80.709998|         84.400002| 80.109998|        83.389999| 41384000|         11.912857|
|2011-11-03 00:00:00|        84.130003|         92.600003| 81.800003|        92.290003| 94685500|13.184285999999998|
|2011-11-04 00:00:00|91.46999699999999| 92.89000300000001| 87.749999|        90.019998| 84483700|             12.86|
|2011-11-07 00:00:00|             91.0|         93.839998| 89.979997|        90.830003| 47485200|         12.975715|
|2011-11-08 00:00:00|91.22999899999999|         92.600003| 89.650002|        90.470001| 31906000|         12.924286|
|2011-11-09 00:00:00|        89.000001|         90.440001| 87.999998|        88.049999| 28756000|         12.578571|
|2011-11-10 00:00:00|        89.290001| 90.29999699999999| 84.839999|85.11999899999999| 39614400|             12.16|
|2011-11-11 00:00:00|        85.899997|         87.949997|      83.7|        87.749999| 38140200|         12.535714|
|2011-11-14 00:00:00|        87.989998|              88.1|     85.45|        85.719999| 21811300|         12.245714|
|2011-11-15 00:00:00|            85.15|         87.050003| 84.499998|        86.279999| 21372400|         12.325714|
|2011-11-16 00:00:00|        86.460003|         86.460003| 80.890002|        81.180002| 34560400|11.597142999999999|
|2011-11-17 00:00:00|            80.77|         80.999998| 75.789999|        76.460001| 52823400|         10.922857|
|2011-11-18 00:00:00|             76.7|         78.999999| 76.039998|        78.059998| 34729100|         11.151428|
+-------------------+-----------------+------------------+----------+-----------------+---------+------------------+
only showing top 20 rows
```
# b) ¿Qué porcentaje del tiempo fue la columna “High” mayor que $ 500?  Juan Luis Tellez
df .filter ($"High" > 500) .show ()
``` sh
scala> df .filter ($"High" > 500) .show ()
+-------------------+-----------------+-----------------+-----------------+-----------------+---------+-----------------+
|               Date|             Open|             High|              Low|            Close|   Volume|        Adj Close|
+-------------------+-----------------+-----------------+-----------------+-----------------+---------+-----------------+
|2015-04-16 00:00:00|            532.0|           568.75|       530.000008|        562.04998|104500900|        80.292854|
|2015-04-17 00:00:00|       558.450005|       575.000023|       558.000008|       571.550011| 58306500|        81.650002|
|2015-04-20 00:00:00|       572.499992|       576.129982|       562.670021|567.3900219999999| 30766400|        81.055717|
|2015-04-21 00:00:00|       568.639984|       570.389984|       558.600021|560.4400099999999| 15925700|        80.062859|
|2015-04-22 00:00:00|        561.47998|       564.990021|        556.81002|           557.68| 12089700|        79.668571|
|2015-04-23 00:00:00|       557.590012|       562.400002|        552.68998|559.0600049999999| 12687500|79.86571500000001|
|2015-04-24 00:00:00|       561.210014|       565.659996|       556.549988|       558.400017| 11045300|        79.771431|
|2015-04-27 00:00:00|        562.04998|       572.499992|561.6100230000001|       566.079979| 15246700|80.86856800000001|
|2015-04-28 00:00:00|564.1299740000001|       568.950005|559.6099780000001|563.0599900000001|  8826300|        80.437141|
|2015-04-29 00:00:00|       560.489998|567.3900219999999|        557.51001|       562.849998|  9534700|        80.407143|
|2015-04-30 00:00:00|       561.660011|       565.850014|553.8699799999999|            556.5| 10565100|             79.5|
|2015-05-01 00:00:00|        558.98999|559.7699809999999|        552.26001|       557.029999|  8906100|        79.575714|
|2015-05-04 00:00:00|556.9999849999999|       558.000008|       552.300011|       554.900017|  7967400|        79.271431|
|2015-05-05 00:00:00|568.6699980000001|       577.099991|       565.299988|        565.54998| 27116600|        80.792854|
|2015-05-06 00:00:00|       567.200005|       568.500008|       556.650017|       560.539986| 11504500|        80.077141|
|2015-05-07 00:00:00|       560.800018|        565.56002|        556.20002|       565.240013| 10220700|        80.748573|
|2015-05-08 00:00:00|       567.289993|       575.069984|       566.750008|       574.600014| 13828500|        82.085716|
|2015-05-11 00:00:00|576.2700120000001|       593.999977|575.3000030000001|       589.950005| 23882600|        84.278572|
|2015-05-12 00:00:00|       586.659996|       586.659996|       580.950012|583.6400070000001| 11907000|        83.377144|
|2015-05-13 00:00:00|       583.830025|       589.380005|       578.840004|580.1099929999999| 11155900|        82.872856|
+-------------------+-----------------+-----------------+-----------------+-----------------+---------+-----------------+
only showing top 20 rows
```

# c) ¿Cuál es la correlación de Pearson entre columna “High” y la columna  Juan Luis Tellez
“Volumen”?
df.select(corr("High", "Low")) .show ()
``` sh
scala> df.select(corr("High", "Low")) .show ()
+------------------+
|   corr(High, Low)|
+------------------+
|0.9996836884310145|
+------------------+
```

# d) ¿Cuál es el máximo de la columna “High” por año?  Juan Luis Tellez
val dfmax = df.groupBy("Date").max()
dfmax.select($"Date", $"max(High)").show()
``` sh
scala> dfmax.select($"Date", $"max(High)").show()
+-------------------+------------------+
|               Date|         max(High)|
+-------------------+------------------+
|2011-12-19 00:00:00|         69.790002|
|2012-05-04 00:00:00|              76.4|
|2015-04-30 00:00:00|        565.850014|
|2016-06-20 00:00:00|         95.879997|
|2011-11-08 00:00:00|         92.600003|
|2012-06-08 00:00:00|         66.119998|
|2013-08-13 00:00:00|        262.199993|
|2014-01-31 00:00:00|        412.400013|
|2015-02-12 00:00:00|459.24997699999994|
|2015-04-22 00:00:00|        564.990021|
|2015-05-21 00:00:00| 626.9999849999999|
|2015-10-08 00:00:00|        115.050003|
|2012-09-27 00:00:00|         56.100002|
|2012-10-04 00:00:00|         67.269998|
|2012-11-01 00:00:00|         79.690001|
|2014-02-25 00:00:00|        457.790024|
|2016-08-16 00:00:00|         95.610001|
|2013-01-28 00:00:00|        177.249998|
|2012-07-02 00:00:00|         68.900002|
|2012-12-18 00:00:00|         97.550003|
+-------------------+------------------+
only showing top 20 rows
```

# e) ¿Cuál es el promedio de la columna “Close” para cada mes del calendario? Juan Luis Tellez
val df2 = df.withColumn("Month", month(df("Date")))

val dfavgs = df2.groupBy("Month").mean()

dfavgs.select($"Month", $"avg(Close)").show()
``` sh
scala> dfavgs.select($"Month", $"avg(Close)").show()
+-----+------------------+
|Month|        avg(Close)|
+-----+------------------+
|   12| 199.3700942358491|
|    1|212.22613874257422|
|    6| 295.1597153490566|
|    3| 249.5825228971963|
|    5|264.37037614150944|
|    9|206.09598121568627|
|    4|246.97514271428562|
|    8|195.25599892727263|
|    7|243.64747528037387|
|   10|205.93297300900903|
|   11| 194.3172275445545|
|    2| 254.1954634020619|
+-----+------------------+
```

