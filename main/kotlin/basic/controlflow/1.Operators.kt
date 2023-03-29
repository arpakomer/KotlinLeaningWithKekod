package basic.controlflow

fun main (args: Array<String>) {

    var numberOne = 10
    val numberTwo = 5

    println("NumberOne : ${numberOne}")
    println("NumberOne : ${numberOne++}")
    println("NumberOne : ${numberOne}")
    println("NumberOne : ${++numberOne}")


    println("----------------------------------------------------------------------")


    var a = 20
    var b = 5
    a += b
    println("a+=b :"  +a)
    a -= b
    println("a-=b :"  +a)
    a *= b
    println("a*=b :"  +a)
    a /= b
    println("a/=b :"  +a)
    a %= b
    println("a%=b :"  +a)

    /*
        a += b   a.plusAssign(b)
        a -= b   a.minesAssign(b)
        a *= b   a.timesAssign(b)
        a /= b   a.divAssign(b)
        a %= b   a.remAssign(b)

    */



}