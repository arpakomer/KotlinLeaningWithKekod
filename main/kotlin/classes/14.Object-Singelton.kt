package classes





// Kotlinde Singelton kullanimi

object  Profilekotlin {
    var nickName: String? = null
    var counter: Int = 0
}

fun main() {

    Profilekotlin.nickName = "ArkHu"

    println(Profilekotlin.counter)
}