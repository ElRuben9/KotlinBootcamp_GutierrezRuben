// 1. Top-level constant
const val MAX_BOOKS_BORROWED = 5

// 3. Objeto singleton para constantes globales
object Constants {
    const val BASE_URL = "https://library.catalog.com/books/"
}

class Book3(val title: String, val author: String, val year: Int) {

    // 2. Método para verificar si el usuario puede tomar más libros prestados
    fun canBorrow(borrowedCount: Int): Boolean {
        return borrowedCount < MAX_BOOKS_BORROWED
    }

    // 4. Companion object para limitar el scope de BASE_URL a la clase Book
    companion object {
        const val BASE_URL = "https://library.catalog.com/books/"
    }

    // Método para imprimir la URL del libro formateada
    fun printUrl() {
        val formattedTitle = title.replace(" ", "_").lowercase()
        val fullUrl = "$BASE_URL$formattedTitle.html"
        println(fullUrl)
    }
}

fun main() {
    val book = Book3("Kotlin Programming", "JetBrains", 2024)

    // Probar canBorrow()
    println("¿Puede pedir con 3 libros prestados?: ${book.canBorrow(3)}")
    println("¿Puede pedir con 5 libros prestados?: ${book.canBorrow(5)}")

    // Probar printUrl() usando la constante del companion object
    book.printUrl()
}