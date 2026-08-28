fun main() {
    val fortuna = getFortuneCookie()
    println("Tu fortuna es: $fortuna")
}

fun getFortuneCookie(): String {
    val fortunas = listOf(
        "Hoy te va a ir a toda madre.",
        "Llévala relax y con calma, todo va a salir bien.",
        "Tómate un respiro y disfruta la vida.",
    )

    print("Pon tu día de cumpleaños (número): ")
    val entrada = readLine()
    val cumple = entrada?.toIntOrNull() ?: 1

    val index = cumple % fortunas.size
    return fortunas[index]
}