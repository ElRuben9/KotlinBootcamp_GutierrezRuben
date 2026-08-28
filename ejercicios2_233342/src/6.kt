package Spices

// 1. Enum con los colores y sus valores RGB
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}

interface Grinder2 {
    fun grind() {
        println("Moliendo hasta hacerlo polvo fino.")
    }
}

// 2. SpiceColor ahora usa el enum Color en lugar de String
interface SpiceColor2 {
    val color: Color
}

object YellowSpiceColor2 : SpiceColor2 {
    override val color = Color.YELLOW
}

// 3. Spice convertida a sealed class
sealed class Spice2(
    val name: String,
    val spiciness: String = "mild",
    color: SpiceColor2 = YellowSpiceColor2
) : SpiceColor2 by color {

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

// 4. Subclases directas dentro del mismo paquete/archivo
class Curry2(
    name: String,
    spiciness: String,
    color: SpiceColor2 = YellowSpiceColor2
) : Spice2(name, spiciness, color), Grinder {

    override fun prepareSpice() {
        println("Preparando $name:")
        grind()
    }
}

fun main() {
    val curry = Curry2("Curry Amarillo", "spicy")
    println("Especia: ${curry.name}")
    println("Color Enum: ${curry.color} (RGB: 0x${curry.color.rgb.toString(16).uppercase()})")
}