package classes


class  Car(wheelCount: Int, color: String = "Red") {
    // Car sinifinin yanina ben (Car Constructor)Constructor yazsam da yazmasamda --> primary Cons deriz
    private  val nWheelCount: Int
    private val nColor = color

    init {
        nWheelCount = wheelCount
        "primary const. created".printLog()
        "WheelCount : $nWheelCount, Color : $nColor".printLog()
    }

    constructor(wheelCount: Int, color: String = "Red",name: String) : this(4){
        "1.secondary const. created".printLog()
    }
    constructor(wheelCount: Int, color: String = "Red",name: String, madeOf: String ): this(wheelCount){
        "2.secondary const. created".printLog()

    }
}

fun main() {
    val car0 = Car(4)
    val car1 = Car(4, "Blue")
    val car2 = Car(4, "Blue", "Passat")
    val car3 = Car(4, "Blue", "Passat", "Gold")
}



fun String.printLog() {
    println(this)
    println("-----------------------------------")
}