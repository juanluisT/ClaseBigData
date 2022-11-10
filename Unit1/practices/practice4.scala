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
