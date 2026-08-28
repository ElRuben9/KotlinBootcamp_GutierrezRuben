class Book2(val title: String, val author: String, val year: Int) {

    // Método que retorna título y autor como un Pair
    fun getTitleAuthor(): Pair<String, String> {
        return Pair(title, author)
    }

    // Método que retorna título, autor y año como un Triple
    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun main() {
    val book = Book2("Cien años de soledad", "Gabriel García Márquez", 1967)

    // Usando Pair
    val (title, author) = book.getTitleAuthor()
    println("Libro: $title | Autor: $author")

    // Usando Triple y destructuración para imprimir la frase completa
    val (bookTitle, bookAuthor, bookYear) = book.getTitleAuthorYear()
    println("Here is your book $bookTitle written by $bookAuthor in $bookYear.")
}