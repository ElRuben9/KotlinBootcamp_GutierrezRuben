package Buildings

open class BaseBuildingMaterial2(open val numberNeeded: Int = 1)

class Wood2 : BaseBuildingMaterial2(numberNeeded = 4)
class Brick2 : BaseBuildingMaterial2(numberNeeded = 8)

class Building2<T : BaseBuildingMaterial2>(val material: T) {
    val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int
        get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("$actualMaterialsNeeded ${material::class.simpleName} required")
    }
}

// Función genérica para tipos que extienden de BaseBuildingMaterial
fun <T : BaseBuildingMaterial2> isSmallBuilding(building: Building2<T>) {
    if (building.actualMaterialsNeeded < 500) {
        println("small building")
    } else {
        println("large building")
    }
}

fun main() {
    val woodBuilding = Building2(Wood2()) // 100 * 4 = 400
    woodBuilding.build()
    isSmallBuilding(woodBuilding) // Imprime: small building

    val brickBuilding = Building2(Brick2()) // 100 * 8 = 800
    brickBuilding.build()
    isSmallBuilding(brickBuilding) // Imprime: large building
}