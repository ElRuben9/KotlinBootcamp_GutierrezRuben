fun main() {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    // 1. Curries ordenados
    val curriesSorted = spices
        .filter { it.contains("curry") }
        .sortedBy { it.length }
    println("Curries ordenados por longitud: $curriesSorted")

    // 2. Forma 1 y Forma 2
    val cAndE1 = spices.filter { it.startsWith('c') && it.endsWith('e') }
    val cAndE2 = spices.filter { it.first() == 'c' && it.last() == 'e' }
    println("Forma 2 (first/last): $cAndE2")

    // 3. Primeros 3 que empiezan con 'c'
    val firstThreeStartWithC = spices
        .take(3)
        .filter { it.startsWith('c') }
    println("Primeros 3 que empiezan con 'c': $firstThreeStartWithC")
}