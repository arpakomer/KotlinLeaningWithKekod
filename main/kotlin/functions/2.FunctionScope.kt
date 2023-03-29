package functions

fun main(){



    calculateAtomPhysics()
}

 /**
  *         Kotlinde biz fonk. icinde fonks yazabiliriz .Buna Local Functions denir.
  *         Sebibi yazdigimiz fonk. kendi siniflarında dahi cagrilmasini istememektir.
  *         Bu fonksiyonun herhangi bir baska ya da sinf icin degistirilmesini istemeyebiriz.
  *         Reflection ile fonksiyonlarimiza erisebilirken gizli kalsin da isteyebiliriz
  *         Bu gibi durumlarda bu cok onemli fonksiyonu baska bir fonksiyon icersine yazabiliriz.
  *
  * **/

fun calculateAtomPhysics(){

    val userName = "Gokhan"
     println("Initialize Process ...")

     fun getValueFromUserAndPrint(){
         userName.length
         val numberOne = readLine()!!.toInt()
         val numberTwo = readLine()!!.toInt()
         val result = numberOne + numberTwo
         println("$result")
     }

     getValueFromUserAndPrint()
     println("Process has been done")
}

/**
 *      Bir sinifin icerisindeki fonksiyonlara ----> Uye fonksiyonlar denilir
 */

class  Car {

    fun setColor (colorCodeId: Int) {

    }
}

/**
 *      Bir fonksiyon Generic tip aliyorsa  ----> Generic fonksiyonlar denilir
 */
fun <T> setColor(colorCodeId: T) {

}