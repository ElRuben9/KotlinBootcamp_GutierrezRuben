fun main() {
    // 1. Crear un Set con títulos de libros
    val allBooks = setOf("Hamlet", "Macbeth", "Romeo and Juliet", "Othello")

    // 2. Crear un Map asociando el autor con su Set de libros
    val library = mapOf("William Shakespeare" to allBooks)

    // 3. Verificar con any() si algún libro de la librería es "Hamlet"
    val hasHamlet = library.any { it.value.contains("Hamlet") }
    println("¿Existe Hamlet en la librería?: $hasHamlet")

    // 4. Crear un MutableMap (Título -> Autor) y agregar una entrada inicial
    val moreBooks = mutableMapOf("The Hobbit" to "J.R.R. Tolkien")

    // 5. Usar getOrPut() para consultar/agregar libros
    // Si la clave existe, retorna el autor actual sin modificar el mapa
    val tolkien = moreBooks.getOrPut("The Hobbit") { "Autor Desconocido" }
    println("Autor de 'The Hobbit': $tolkien")

    // Si la clave no existe, la agrega con el valor suministrado en el bloque lambda
    val orwell = moreBooks.getOrPut("1984") { "George Orwell" }
    println("Autor asignado para '1984': $orwell")

    println("Contenido actual de moreBooks: $moreBooks")
}