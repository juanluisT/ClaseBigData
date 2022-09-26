import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("INEGI_DF.csv")

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