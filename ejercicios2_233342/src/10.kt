import kotlin.random.Random

// 1. Clase Book con propiedad mutable 'pages'
class Book4(val title: String, val author: String, val year: Int, var pages: Int)

// 2. Extension function para calcular el peso (1.5 gramos por página)
fun Book4.getWeight(): Double = pages * 1.5

// 3. Extension function para arrancar páginas del libro
fun Book4.tornPages(tornCount: Int) {
    pages = if (pages >= tornCount) pages - tornCount else 0
}

// 4. Clase Puppy que juega con el libro y le arranca páginas al azar
class Puppy {
    fun playWithBook(book: Book4) {
        if (book.pages > 0) {
            val pagesToTear = Random.nextInt(1, 20)
            book.tornPages(pagesToTear)
            println("El cachorro mordió el libro. Arrancó $pagesToTear páginas. Quedan: ${book.pages} páginas (Peso actual: ${book.getWeight()} g).")
        }
    }
}

fun main() {
    val book = Book4("El principito", "Antoine de Saint-Exupéry", 1943, 60)
    val puppy = Puppy()

    println("Inicio -> Libro: '${book.title}' con ${book.pages} páginas (Peso: ${book.getWeight()} g)\n")

    // 5. El cachorro juega con el libro hasta que no quedan páginas
    while (book.pages > 0) {
        puppy.playWithBook(book)
    }

    println("\nYa no quedan más páginas en el libro.")
}