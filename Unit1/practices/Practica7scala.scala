import org.apache.spark.sql.SparkSession
package com.sparkbyexamples.spark.dataframe

import org.apache.spark.sql.functions._

val spark = SparkSession.builder().getOrCreate()

val INEGI_df = spark.read.option("header", "true").option("inferSchema","true")csv("denue_inegi_02_.csv")
package com.sparkbyexamples.spark.dataframe

INEGI_df.printSchema()

import spark.implicits._

INEGI_df.show()
//per_ocu //tipo_asent //nomb_asent //municipio //localidad //fecha_alta //nombre_act 

//CUENTA TODO SLODATAO
 INEGI_df.count()
// #1MUESTRA LOS DTOS fecha_alta MENORES A 2019-11
INEGI_df.filter("fecha_alta" < 2019-11).show()
//#2 MUESTRA LOS DTOS codigo_act MAYOREAS A 115111
INEGI_df.filter("codigo_act > 115111").show()
// #3MUESTRA LOS DTOS codigo_act ENTRE 114119 Y 115111
INEGI_df.filter("codigo_act BETWEEN 114119 AND 115111").show()
// #4 MUESTRA LOS DTOS AGRUPADOS y CONTADOS POR cod_postal 
INEGI_df.groupBy("cod_postal").count().show()
// #5 MUESTRA LOS DTOS AGRUPADOS por cod_postal y municipio y CONTADOS POR cod_postal 
INEGI_df.groupBy("cod_postal" , "municipio").count().show()
// #6 muestra los datos ordenado porcve_mun (clave municipal)
INEGI_df.orderBy("cve_mun").show()
//#7
INEGI_df.filter("cod_postal < 22163").show()
//#8
INEGI_df.filter("cve_loc > 192").show()
//#9
INEGI_df.filter("cve_loc BETWEEN 192 AND 250").show()
//#10

//#11

//#12

//#13

//#14

//#15