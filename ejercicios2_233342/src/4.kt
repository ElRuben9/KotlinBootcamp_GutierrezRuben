package Spices

// 1. Interfaz para la acción de moler
interface Grinder {
    fun grind() {
        println("Moliendo hasta hacerlo polvo fino.")
    }
}

// 2. Interfaz y Singleton para el color (Delegación)
interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "yellow"
}

// 3. Clase Abstracta Spice que delega la propiedad color
abstract class Spice(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor = YellowSpiceColor
) : SpiceColor by color {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            "medium" -> 7
            "spicy" -> 10
            "very spicy" -> 15
            else -> 0
        }

    abstract fun prepareSpice()
}

// 4. Subclase Curry implementando la interfaz Grinder
class Curry(
    name: String,
    spiciness: String,
    color: SpiceColor = YellowSpiceColor
) : Spice(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        println("Preparando $name:")
        grind()
    }
}

// 5. Función principal para probar todo
fun main() {
    val curry = Curry("Curry Amarillo", "spicy")

    println("Especia: ${curry.name}")
    println("Color: ${curry.color}")
    println("Nivel de picante (heat): ${curry.heat}")

    curry.prepareSpice()
}