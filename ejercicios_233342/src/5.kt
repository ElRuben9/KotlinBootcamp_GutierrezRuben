fun main() {
    println(whatShouldIDoToday("feliz"))
    println(whatShouldIDoToday("triste"))
    println(whatShouldIDoToday("feliz", "lluvioso", 18))
    println(whatShouldIDoToday("aburrido", "nublado", 22))
    println(whatShouldIDoToday("motivado", "soleado", 30))
}

fun whatShouldIDoToday(
    mood: String,
    weather: String = "soleado",
    temperature: Int = 24
): String {
    return when {
        mood == "feliz" && weather == "soleado" && temperature in 20..30 -> "Sal a dar una vuelta y aprovecha el día."
        mood == "triste" || weather == "lluvioso" -> "Quédate en casa a descansar y ver una película."
        mood == "motivado" && temperature > 25 -> "Ve al gimnasio o sal a hacer ejercicio al aire libre."
        mood == "aburrido" && weather == "nublado" -> "Ponte a jugar videojuegos o escucha buena música."
        temperature > 35 -> "Quédate en el aire acondicionado y tómate algo frío."
        temperature < 15 -> "Ponte una sudadera y tómate un café caliente."
        else -> "Quédate en casa y lee algo tranquilo."
    }
}