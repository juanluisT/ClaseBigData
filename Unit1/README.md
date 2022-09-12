# ClaseBigData
#adding test
//1. Desarrollar un algoritmo en scala que calcule el radio de un circulo
var radio = "el radio de 2 es "+ 2 * Math.PI*3
/******************/

//3. Dada la variable bird = "tweet", utiliza interpolacion de string para
//   imprimir "Estoy ecribiendo un tweet"
val bird = "tweet"
val birdy = s"Estoy ecribiendo un ${bird}"

//5. Cual es la diferencia entre value y una variable en scala?
     //"var se puede modificar"
     //"val es constante"
/******************/

# Practice 4 
// 1. Crea una lista llamada "lista" con los elementos "rojo", "blanco", "negro"
val lista = collection.mutable.Set("rojo", "blanco", "negro")
lista.toSet


// 3. Traer los elementos de "lista" "verde", "amarillo", "azul"
for(list <- lista){
    if(list.startsWith("v") || list.startsWith("a")){
        println(s"$list")
    }
}


// 5. Cuales son los elementos unicos de la lista Lista(1,3,3,4,6,7,3,7) utilice conversion a conjuntos
val mylst = List(1,3,3,4,6,7,3,7)
mylst.toSet