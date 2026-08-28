// 1. Función de extensión de orden superior sobre List<Int>
fun List<Int>.filterDivisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    // Pasamos una lambda que calcula el residuo (módulo) entre 3
    val divisibleByThree = numbers.filterDivisibleBy { it % 3 }

    println(divisibleByThree) // Output: [3, 6, 9, 0]
}