package Buildings

// 1. Clase base con la propiedad base
open class BaseBuildingMaterial(open val numberNeeded: Int = 1)

// 2. Subclases con valores específicos
class Wood : BaseBuildingMaterial(numberNeeded = 4)
class Brick : BaseBuildingMaterial(numberNeeded = 8)

// 3. Clase genérica restringida a tipos que hereden de BaseBuildingMaterial (Generic Constraint)
class Building<T : BaseBuildingMaterial>(val material: T) {
    val baseMaterialsNeeded: Int = 100
    val actualMaterialsNeeded: Int
        get() = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("$actualMaterialsNeeded ${material::class.simpleName} required")
    }
}

fun main() {
    // Crear un edificio de madera
    val woodBuilding = Building(Wood())
    woodBuilding.build()

    // Crear un edificio de ladrillo
    val brickBuilding = Building(Brick())
    brickBuilding.build()
}