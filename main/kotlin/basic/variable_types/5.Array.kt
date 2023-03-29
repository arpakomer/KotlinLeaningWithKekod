package basic

fun main (){

    /**
     *  Dizi tanimlari için kullanılabilir
     *  arrayOf(ayni tip degerler) seklinde tanımlanabilir
     *  arrayOf<Any>(farkli tip değerler)
     *  arrayOfNull<Type>(size) şeklinde ise verilen boyut kadar null deger
     *  içeren dizi tanımlanabilir.
     */
       //                index = 0   1   2   3   4
    val studentNumber = arrayOf(16, 24, 28, 35, 40)
    val studentNames = arrayOf("Omer", "ARPAK", "Van")
    val firstCharOfNames = arrayOf('A', 'B', 'C', 'D')
    val mixedArray = arrayOf<Any>(13, "Omer", 'A', false)
    val arrayOfNulls = arrayOfNulls<String>(3)

//  High Order Function

    /**
     *       Array<Type>(size){higher order function} şeklinde de tanımlanabilir
     *       Bu durum higher order function içersinde son satira gelen degerleri diziyi olusturur
     *       Higher order function, içerisi dizinin boyutu kadar index'i (it) artirarak çalışır
     */

    // 5 elemanli, tüm elemanlari 3.14 x indexDegeri olan bir dizi olusturur
    val carNameMini = Array<Double>(5){
//        pseudo Codes
//        pseudo Codes
//       pseudo Codes
         3.14 * it

    }
    //ByteArray, CharArray, IntArray, DoubleArray primitive array tanımları yapılablir

    val firstCharOfContries = CharArray(5) // {U,L,K,E,M}
    firstCharOfContries[0] = 'U'
    firstCharOfContries.set(1, 'L')
    firstCharOfContries.set(3, 'E')


    firstCharOfContries[2] = 'K'
}