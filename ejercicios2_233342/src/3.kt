open class Book(val title: String, val author: String) {
    private var currentPage: Int = 0

    open fun readPage() {
        currentPage++
    }

    fun getCurrentPage(): Int = currentPage
}

class eBook(
    title: String,
    author: String,
    val format: String = "text"
) : Book(title, author) {

    private var wordCount: Int = 0

    override fun readPage() {
        wordCount += 250
    }

    fun getWordCount(): Int = wordCount
}

fun main() {
    val physicalBook = Book("Clean Code", "Robert C. Martin")
    physicalBook.readPage()
    physicalBook.readPage()
    println("${physicalBook.title} - Páginas leídas: ${physicalBook.getCurrentPage()}")

    val myEBook = eBook("Kotlin in Action", "Dmitry Jemerov")
    myEBook.readPage()
    myEBook.readPage()
    println("${myEBook.title} (${myEBook.format}) - Palabras leídas: ${myEBook.getWordCount()}")
}