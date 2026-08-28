//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    var fishName = "Alejandro"

    when(fishName.length){
        0 -> println("No hay ningun texto")
        in 3..12 -> println("Hay texto en el atributo")
        else -> println("Sirve")
    }

    val numbers = intArrayOf(11, 12, 13, 14, 15)
    val stringList = mutableListOf<String>()
    for (num in numbers) {
        stringList.add(num.toString())
    }
    println(stringList)
}

