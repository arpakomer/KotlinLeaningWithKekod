package basic

fun main(){

    /**
     *
     *  Bir değişkene null deger ataması yapabilmek için değişken tipinin sonuna ? işareti konulur.
     *  Eğer bir değişkene tip verilmez ve direkt null deger atamasi yapilirse , IDE tip çikarimi yaparken
     *  bu degiskenin degerini Nothing? olarak işaretler.Cunku hangi tipe karşılık geldigini bilemez
     *
      */

    val name: String? = null
    val age : Int? = null


    val numberr = null // Degisken tipi NOTHING? dir

    val number3 : Nothing? = null


    val number1 : Int? = null
    val number2 : Int? = null  // Iki number daha sonra kullandığımız için burda null girilesecek bu da redundant oldugunu gosterir

// ? ile !! çok onemlidir. A4 bakmalısın. orda yazdınnnn.
}