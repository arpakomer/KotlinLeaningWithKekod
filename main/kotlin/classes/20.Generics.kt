package classes

interface TransportationFunctions {
    fun run()
}


open class  Auto: TransportationFunctions{
    open val name: String = ""
    open val color: String = ""

    override fun run() {
        println("Run boy run")
    }

}

open class Bycle  {
    open val name: String = ""
    open val color: String = ""
}

// *********************************************************************************************************************


open class MiniCooper(
    override val name: String = "MiniCooper",
    override val color: String = "Red"
): Auto() {
    override fun toString(): String {
        return "name: $name, color $color"
    }

    init {
        super.run()
    }
}

open class John : MiniCooper() {
    init {
        super.run()
    }
}

open class JohnCabrio: John() {
    init {
        super.run()
    }

}

class Beetle(
    override  val name: String = "Beetle",
    override val color: String = "Yellow"
): Auto() {
    override fun toString(): String {
        return "name: $name, color $color"
    }
    init {
        super.run()
    }
}


open class Bisan(
    override val name: String = "Bisan",
    override val color: String = "Blue"
): Bycle(), TransportationFunctions {

    override fun toString(): String {
        return "name: $name, color $color"
    }


    override fun run() {
        println("Run boy run")
    }
}
class  BlackBisan(): Bisan()

class Corelli(
    override val name: String = "Corelli",
    override val color: String = "Gray"
): Bycle() {
    override fun toString(): String {
        return  "name: $name, color: $color"
    }
                        // Java karsiligi <? extends Auto>

}                       // <T> Arayuzler esitse ilgili class'lari alir
                        // <T: Auto> Nesnenin kendisi ve tipi ayniysa  sadece Auto class'i alir.
                      // <out --> Kendisi ve child class'lar kabulum diyorsunuz.
class  TransportFactory<out T: Auto>(transportationVehicle: T) {
                    // <in T: Bycle>  --> Kendisi ve parent class'lar kabulum diyorsunuz
    init {
        println(transportationVehicle.toString())
    }
}

fun main() {
    val miniCooper: MiniCooper = MiniCooper()
    val john: John = John()
    val johnCabrio: JohnCabrio = JohnCabrio()
    val beetle: Beetle = Beetle()


    val bycle : Bycle = Bycle()
    val bisan: Bisan = Bisan()
    val blackBisan: BlackBisan = BlackBisan()
    val corelli: Corelli = Corelli()

    val miniCooperFactory: TransportFactory<MiniCooper> = TransportFactory<MiniCooper>(miniCooper)
    val johnFactory: TransportFactory<John> = TransportFactory<John>(john)
    val johnCabrioFactory: TransportFactory<JohnCabrio> = TransportFactory<JohnCabrio>(johnCabrio)
    val beetleFactory: TransportFactory<Beetle> = TransportFactory<Beetle>(beetle)

//    val johnFactor2: TransportFactory<John> = TransportFactory<John>(miniCooper)
    val johnFactory3: TransportFactory<John> = TransportFactory<John>(johnCabrio)
    val johnFactory4: TransportFactory<John> = TransportFactory<John>(john)

//   val bisanFactory2 : TransportFactory<Bisan> = TransportFactory<Bycle>(bycle)
//    val bisanFactory3 : TransportFactory<Bisan> = TransportFactory<BlackBisan>(blackBisan)
//    val bisanFactory4 : TransportFactory<Bisan> = TransportFactory<Bisan>(bisan)
//
//    val  bisanFactory: TransportFactory<Bisan> = TransportFactory<Bisan>(bisan)
//    val  corelliFactory: TransportFactory<Corelli> = TransportFactory<Corelli>(corelli)

//    val something: Car = Car(2,"Red")
//    val somenthingFactory: TransportFactory<Car> = TransportFactory<Bycle>(bycle)

    println(miniCooper.toString())
    println(johnCabrio.toString())
    println(john.toString())
    println(beetle.toString())

    calculate<String>(2,5)
    calculate<Int>(2,5)

}

        //İnline -->fonksiyon body'si derleme zamaninda cagrildigi yere yapisir
inline fun <reified T> calculate(numberOne: Int, numberTwo: Int): T {
    return when (T::class.java) {
        String::class.java -> {
            (numberOne + numberTwo) as T
        }
        else -> {
            (numberOne - numberTwo) as T
        }
    }
}
