package classes



interface  McDonaldsService {
    fun motoCarrier()
// fun sellCoffee(): McCoffee
}

/**
 *  Final ve open modifier'lari kullanmak anlamsiz ve yanlistir.
 *  Abstract olarak yazilmis class'a yeni eklenen tum abstract yapilar, tum child class'lara override edilmek zorunda.
 *  Eger abstract class'iniza eklemek istediginiz opsiyonel yapilar varsa, bunlari child class'larin override
 etmek zorunda olmayalim diye, open keyword'u ile tanimlayabiliriz
 *  abstract bir class, abstract bir class'i miras alirsa, abstract yapilar override etmek zorunda degil.
 *  abstract fun. bodys'si olmaz. Property'lerin de default degeri olmaz
 *
 *  abstract class'larin ayni zamanda instance'i olusturulamayan class'lar. Bu sebeple singleton gibi pattern'ler icin
 *  kullanilabiliyorlar
 * */

abstract  class  McDonalds {
    abstract  val fridge: Fridge         // İlk deger ataması olmaz
    abstract  val superVisor: SuperVisor
    abstract  val employeeOne: Employee
    abstract  val employeeTwo: Employee
    abstract  val employeeThree: Employee
    abstract  val menuList: List<McHamburger>

//    val specialBranchName: String = "Taksim" ---> Duz bir fonks. ya da duz bir degiskende tanimlayabilirim.

    abstract  fun clean(clock: Int)  // Body olmaz .Ne yapacaksın nasıl yapacaksin bunu yap

    //Opsiyonel
    open  val policeOfficer: Police  = Police()

    open fun sellIceDream(amount: Int){}
}

abstract  class  McDonaldsExpress : McDonalds() {
    abstract  fun sellCoffee(): McCoffee
                                                /* Bir abstract class baska bir abstract classı miras alabilir
                                                      miras aldigi classi degisken veya fonks override edebilir de
                                                      etmeyebilirde .
                                                  */
    override fun clean(clock: Int) {
        println("Clean time : $clock")
    }
//    fun  main () {
//        fridge              // İstedigim degiskenide cagirabilirim
//        superVisor
//        menuList
//    }


}

class McDonaldsSultangazi : McDonalds(), McDonaldsService {
// Normal (Düz) bir class  yada open bir class  abstract bir classı miras alacaksa
// degiskenleri ve fonks. override etmesi Zorundaaaaaaaaaaaaaaaaaaaaaa.
    override  val fridge: Fridge
        get() = TODO("Not yet implemented")


    override val superVisor: SuperVisor
        get() = TODO("Not yet implemented")

    override val employeeOne:  Employee
        get() = TODO("Not yet implemented")

    override val employeeTwo: Employee
        get() = TODO("Not yet implemented")

    override val employeeThree:  Employee
        get() = TODO("Not yet implemented")

    override val menuList: List< McHamburger>
        get() = TODO("Not yet implemented")

     override  fun clean(clock: Int) {
        TODO("Not yet implemented")

    }

    override fun motoCarrier() {
        TODO("Not yet implemented")
    }
}

class  McDonaldsEminonu: McDonalds() {
    override  val fridge: Fridge
        get() = TODO("Not yet implemented")

    override val superVisor: SuperVisor
        get() = TODO("Not yet implemented")

    override val employeeOne:  Employee
        get() = TODO("Not yet implemented")

    override val employeeTwo: Employee
        get() = TODO("Not yet implemented")

    override val employeeThree:  Employee
        get() = TODO("Not yet implemented")

    override val menuList: List< McHamburger>
        get() = TODO("Not yet implemented")

    override  fun clean(clock: Int) {
        TODO("Not yet implemented")

    }

    // Opsiyonel
    override  val policeOfficer : Police
        get() = Police()
}

class McDonaldsSultangaziExpress : McDonaldsExpress() {
    override fun sellCoffee(): McCoffee {
        TODO("Not yet implemented")
    }
    override  val fridge: Fridge
        get() = TODO("Not yet implemented")

    override val superVisor: SuperVisor
        get() = TODO("Not yet implemented")

    override val employeeOne:  Employee
        get() = TODO("Not yet implemented")

    override val employeeTwo: Employee
        get() = TODO("Not yet implemented")

    override val employeeThree:  Employee
        get() = TODO("Not yet implemented")

    override val menuList: List< McHamburger>
        get() = TODO("Not yet implemented")

    override  fun clean(clock: Int) {
       super.clean(clock)
       println("Clean flor: 1")

    }
}



fun main() {
//     val mcDonalds = McDonalds()   ---->> Open class (Duz) ile abstract class arasindaki fark.Abstract Instance olmaz
//     val mcDonalds = McDonaldsSultangazi() ---->> Düz bir classin bir nesnesini olusturabilirim
}



class Fridge


class SuperVisor

class Employee

class McHamburger

class McCoffee

class Police