fun main(args: Array<String>) {
    var fortune: String
    for (i in 1..10) {
        fortune = getFortune(getBirthday())
        println("\nTu fortuna es: $fortune")
        if (fortune.contains("con calma")) break
    }
}

fun getBirthday(): Int {
    print("Ingresa tu día de cumpleaños (número): ")
    val entrada = readLine()
    return entrada?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
    val fortunas = listOf(
        "Hoy vas a tener un excelente día.",
        "Las cosas van a salir bien hoy, ten paciencia.",
        "Aprovecha el día para sacar tus pendientes.",
        "Llévala con calma y todo va a salir bien.",
        "Hoy es buen día para no complicarte la vida.",
        "Tómate un descanso y disfruta el momento.",
        "Valora a tus buenos amigos, son un gran apoyo."
    )

    return when (birthday) {
        28, 31 -> "Cierras el mes de la mejor manera, se vienen cosas buenas."
        in 1..7 -> "Inicias el mes con buena energía, aprovéchala."
        else -> fortunas[birthday % fortunas.size]
    }
}