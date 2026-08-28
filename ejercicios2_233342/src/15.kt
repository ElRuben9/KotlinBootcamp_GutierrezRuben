import kotlin.math.absoluteValue

enum class Directions2 {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

// Clase para gestionar el mapa y las coordenadas (Challenge)
class Location(val width: Int = 4, val height: Int = 4) {
    val map = Array(width) { arrayOfNulls<String>(height) }

    init {
        // Inicializar descripciones para cada casilla del mapa (4x4)
        map[0][0] = "Estas en la entrada del bosque oscuro."
        map[0][1] = "Ves un lago cristalino con peces brillantes."
        map[0][2] = "Llegaste a una cueva humeda y fria."
        map[0][3] = "Hay un acantilado con vista a las montanas."

        map[1][0] = "Caminas por un sendero cubierto de flores."
        map[1][1] = "Estas en una cabana abandonada."
        map[1][2] = "Un puente de piedra cruza un pequeno rio."
        map[1][3] = "Encontraste una fogata apagada."

        map[2][0] = "Hay ruinas antiguas con simbolos extranos."
        map[2][1] = "Un arbol gigante bloquea parte del camino."
        map[2][2] = "Un claro soleado ideal para descansar."
        map[2][3] = "Suelo pantanoso, huele bastante raro."

        map[3][0] = "Un campamento con suministros basicos."
        map[3][1] = "Un pozo de agua que parece profundo."
        map[3][2] = "Ves una estatua de piedra cubierta de musgo."
        map[3][3] = "Una torre de vigilancia antigua."
    }

    // Actualiza coordenadas manteniendo al jugador dentro de los limites con rem() y absoluteValue
    fun updateLocation(x: Int, y: Int): String {
        val safeX = (x.rem(width) + width).rem(width).absoluteValue
        val safeY = (y.rem(height) + height).rem(height).absoluteValue
        return map[safeX][safeY] ?: "Un lugar misterioso y vacio."
    }
}

class Game2 {
    var path = mutableListOf(Directions2.START)
    val location = Location()

    private var x = 0
    private var y = 0

    // Lambdas de movimiento
    val north = {
        y++
        path.add(Directions2.NORTH)
        true
    }

    val south = {
        y--
        path.add(Directions2.SOUTH)
        true
    }

    val east = {
        x++
        path.add(Directions2.EAST)
        true
    }

    val west = {
        x--
        path.add(Directions2.WEST)
        true
    }

    val end = {
        path.add(Directions2.END)
        println("Game Over: $path")
        path.clear()
        false
    }

    // Higher-order function que ejecuta el movimiento y actualiza la posicion
    fun move(where: () -> Boolean) {
        val keepPlaying = where()
        if (keepPlaying) {
            val description = location.updateLocation(x, y)
            println("-> $description")
        }
    }

    // Procesa la entrada del usuario
    fun makeMove(direction: String?) {
        when (direction?.trim()?.lowercase()) {
            "n" -> move(north)
            "s" -> move(south)
            "e" -> move(east)
            "w" -> move(west)
            else -> move(end)
        }
    }
}

fun main() {
    val game = Game2()

    println("=== Bienvenido a la Aventura ===")
    println("-> ${game.location.updateLocation(0, 0)}")

    while (true) {
        print("\nEnter a direction: n/s/e/w: ")
        val input = readLine()
        game.makeMove(input)

        // Si la lista de ruta se reinicia a 0 (por llamar a end), termina el juego
        if (game.path.isEmpty()) {
            break
        }
    }
}