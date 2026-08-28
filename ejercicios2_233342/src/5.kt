package Spices

// 1. Data class que recibe una especia y genera la propiedad 'label'
data class SpiceContainer(val spice: Spice) {
    val label: String = spice.name
}

fun main() {
    // 2. Crear instancias de especias
    val curryRojo = Curry("Curry Rojo", "very spicy")
    val curryVerde = Curry("Curry Verde", "mild")
    val curryDorado = Curry("Curry Dorado", "medium")

    // 3. Crear los contenedores
    val contenedor1 = SpiceContainer(curryRojo)
    val contenedor2 = SpiceContainer(curryVerde)
    val contenedor3 = SpiceContainer(curryDorado)

    val contenedores = listOf(contenedor1, contenedor2, contenedor3)

    // 4. Imprimir las etiquetas
    println("--- Etiquetas de los Contenedores ---")
    contenedores.forEach { println("Etiqueta: ${it.label}") }
}