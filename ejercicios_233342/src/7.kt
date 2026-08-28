import kotlin.random.Random

fun main() {
    // 1. Lambda básica (1 a 12)
    val rollDiceBasic = { Random.nextInt(1, 13) }

    // 2 y 3. Lambda con argumento (lados) y validación de 0
    val rollDice = { sides: Int ->
        if (sides == 0) 0 else Random.nextInt(1, sides + 1)
    }

    // 4. Misma lambda usando notación de tipo de función: (Int) -> Int
    val rollDice2: (Int) -> Int = { sides ->
        if (sides == 0) 0 else Random.nextInt(1, sides + 1)
    }

    // Pruebas directas
    println("Dado básico (12 lados): ${rollDiceBasic()}")
    println("Dado de 6 lados: ${rollDice(6)}")
    println("Dado con 0 lados: ${rollDice(0)}")
    println("rollDice2 con 20 lados: ${rollDice2(20)}")

    // 6. Pasar rollDice2 como argumento a gamePlay()
    gamePlay(rollDice2)
}

fun gamePlay(diceRoll: (Int) -> Int) {
    val result = diceRoll(6)
    println("Resultado del juego (dado de 6 lados): $result")
}