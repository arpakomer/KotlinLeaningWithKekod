package functions


fun main() {

    /**
     *      İnfix daha okunaklı kodlar yazmak için kullanılır
     *      .(Nokta) kullanımını kaldırır //  false.or(true) ---> false or true
     *      5 sartı vardır.
     *              1- İnfix keyword ile basla
     *              2- bir sınıfa ait olmalı
     *              3- Ya da bir extension fonks. olmalı
     *              4- Sadece 1 parametre almalı . Bu vararg olamaz. Bir akıllı sen degilsin canim:)
     *              5- infix metodu -function- parametresi default deger alamaz.
     */


    val isSutudent = false
    val isMale = true

    /**
     *      and, or, xor gibi onlarca infix method vardir
     */
    if (!isSutudent and isMale) {
        kotlin.io.print("Ogrenci olmayan Erkek")
    }

    // infix kullanimi

    isSutudent and isMale
    isSutudent.and(isMale)

    val awesomeInstance = AwesomeClass()

    // infix kullanimi
    awesomeInstance downLoadImage "www.google.com.tr"
    // infix yoksa ,normal fonksiyon cagirmak istersem
    /* awesomeInstance.downLoadImage("......")*/


}

class AwesomeClass {


    infix fun downLoadImage(imageUrl: String) {

    }

    infix fun downLoadImage(number: Int): Int {
        return 3
    }

    // Bir sinif icindeyken this kullanimi bize bulundugu sinifi isaret eder
    // asagıdaki kullanim AwosomeClass().downLoadImage(imageUrl) kullanimi olusur  *İmplicit*

    fun logWhenImageDownloaded(imageUrl: String) {
        downLoadImage(imageUrl) // infix kullanmamıs normal duz fonks cagrımı

        //downLoadImage imageUrl infixi boyle kullanamayiz
        this downLoadImage imageUrl // ilgili sinifin icerisindeysem this ile yapabilirim


    }

}

/*------------------------------------------------------------------------------------------------------------ */

// bir sinifin disindayken infix method cagirimi yapilirsa this kullanilmaz

fun logWhenImageDownloaded(imageUrl: String) {
// this downLoadImage imageUrl
}

