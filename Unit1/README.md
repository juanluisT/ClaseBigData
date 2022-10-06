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

# 11. Con Sintaxis Scala/Spark $ conteste lo siguiente:

# a) ¿Cuántos días fue la columna “Close” inferior a $ 600? #Edgar Cadena
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

