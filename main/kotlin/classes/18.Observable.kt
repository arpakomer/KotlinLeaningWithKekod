package classes

import kotlin.properties.Delegates


class User65 {
    var name: String by Delegates.observable("Initialized Value") { property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }

}

var max: Int by Delegates.vetoable(0) {property, oldValue, newValue ->

//    throw IllegalArgumentException("New value must be larger than old")
    newValue > oldValue
}


var max2: Int by Delegates.observable(0) {property, oldValue, newValue ->
    true
}

fun main () {

    val user = User65()
    user.name = "first"
    user.name = "second"


    println(max)  // 0

    max = 10
    println(max) // 10

    max = 5 //

    println(max) // with exception  to IllegalArgumentException

    max2 = 10
    println("max2: $max2") //


    max2 = 5 //
    println("max2: $max2") //

// Observable pattern kullanmasak. Interface kullanımı   // object: Notify --> Object-Expresion kullanimi (Cagrilimi)
    val deneme = DenemeObservable(object : Notify{
        override fun onNotify(oldValue: Int, newValue: Int) {
            println("Old balance : $oldValue, new balance : $newValue")
        }
    })

    deneme.balance = 1231

// Observable pattern kullanmasak.Higher order kullanımı

    val deneme1 = DenemeObservable1{ oldValue, newValue ->
        println("Old balance : $oldValue, new balance : $newValue")
    }

    deneme1.balance = 1234


}

// Interface ornegi icin
interface  Notify {
    fun onNotify(oldValue: Int, newValue: Int)
}

class  DenemeObservable(val notify: Notify) {
    var balance: Int = 0
    set(value) {
        notify.onNotify(field, value) // field --> backing field
        field = value // degerler esitlendi
    }
}


//Higher Order ornegi

class DenemeObservable1(val notify: (Int, Int) -> Unit){
    var balance: Int = 0
    set(value) {
        notify(field, value)
        field = value
    }
}

