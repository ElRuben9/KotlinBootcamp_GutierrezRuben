class Spice(val name: String, val spiciness: String = "mild") {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            "medium" -> 7
            "spicy" -> 10
            "very spicy" -> 15
            else -> 0
        }

    init {
        println("Especia creada -> Nombre: $name, Picante: $spiciness, Heat: $heat")
    }
}

// Función auxiliar para crear sal por defecto
fun makeSalt() = Spice("salt", "none")

fun main() {
    // Lista de objetos Spice
    val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "very spicy"),
        Spice("green curry", "spicy"),
        makeSalt()
    )
    val spicyOrLess = spices.filter { it.heat in 1..10 }

    println("\n--- Especias spicy o menos picantes ---")
    spicyOrLess.forEach { println("${it.name} (heat: ${it.heat})") }
}