class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}

fun main() {
    val spice = SimpleSpice()
    println("Nombre: ${spice.name}, Nivel de picante (heat): ${spice.heat}")
}