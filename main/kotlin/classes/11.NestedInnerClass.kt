package classes




/**
 *  Nested class'lar outer class'in uye property'lerine ya da fonksiyonlarina erismezler.
 *
 *   Nested class'lar static olarak saklanilar. outer class uzerinden nested erismek istersek
 *   Outer.NestedClass() erisebiliriz.
 *
 *  İnner class'lar static olarak tutulamazlar. Erismek istersek
 *  Outer().InnerClass() seklinde Outer class'in da instance'ini olusturmamiz gerekmektedir.
 *  Bundan dolayi inner class outer clas'in tum elemanlarina erisebilirler. private olanlar  da dahil.
 *
 *  İnner class'in icerisine yeni bir nested class eklenememektedir.
 *
 *  Nested class'in icerisine ise bir nested ya da inner fark etmeksizin
 */


class  Outer {
    private val nam = "Gokhan"
    val surName = "OZTURK"

    fun getAge() : Int = 25

    class  NestedClass {



        fun printName() {
//            name
//            surName
//            getAge()
        }
    }

}

interface OuterInterface {
    class  DenemeA
    interface NestedInterface
}

class Outer2 {
    private val name = "Gokhan"
    val surName = "OZTURK"
    fun getAge() : Int = 25

    inner class InnerClass {


        fun printName() {
            name
            surName
            getAge()
        }
    }
}


fun  main () {


    Outer.NestedClass().printName()
//    Outer().NestedClass().printName()

    val outer = Outer2()
    outer.getAge()
    outer.surName
//    Outer.name

    outer.InnerClass().printName()

}