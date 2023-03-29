package functions


fun main(){

    /**
     *          COK COK COK ONEMLİ BİR KONU
     *
     *      Uzerinde degisiklik yapamadigimiz(readOnly) siniflara ya da yapmak istemedigimiz siniflara bu siniflarin
     *      icine yazmadan fonksiyon tanimlayabilmemizi saglar. Boylece o sinifa uye bir fonksiyon kazandirabiliriz.
     *      Bunu yaparken unutmamiz gereken; Yazdigimiz extension fonksiyon aslinda o sinifin gercek bir fonks. olmayacak
     *
     *      Sad but true story.Olsundu. Extension fonksiyonlar kalbinize girecek. Bir sinifa ait olmalari gerekmez :)
     *
     *      Reciver diye adlandiricagimiz bir sinifa ihtiyac duyar. Extension yazacaginiz sinifi ifade eder Reciever tanimi.
     *
     *      Yapisal olarak;
     *
     *      fun String.exPrint(hansameValue . HandsomeOne) : Unit {
     *
     *      }
     *
     */

    val pi: Double = 3 + 0.14
    println(pi)

    val schoolNumber: Int = 1234
    println(schoolNumber)

    val tcIdentityNumber: Long = 1234567895654
    println(tcIdentityNumber)

    //  Yukardaki kullanim yerine normal bir log2 fonks yazilabilir ve asagidaki gibi kullanabiliriz
    log2(pi)
    log2(schoolNumber)
    log2(tcIdentityNumber)


//    Cagirdigi yer
//    fun log2 (number: Number) {
//        println(number)
//
//    }


/* ----------------------------------------------------------------------------------------------------------*/


    //Extension fonksiyonlar ister direkt value'lar uzerinden cagrilabilirler.
    (3+ 0.14).log("")
    1234.log("")
    1234.log("")
    1234567895654.log("")

//    (3+ 0.14) log ""
//    1234 log ""          ------------- >>> İnfix yaparsak
//    1234 toFloat()
//    1234567895654 log ""

    // degiskenler uzerinde bu sekilde kullanabiliriz
    pi.log("")
    schoolNumber.log("")
    tcIdentityNumber.log("")


/*  ---------------------------------------------------------------------------------------- */

    // Extension fonksiyonlar sari renkte gözukur
    val result: Int = "3".extPlus("5")
    val result2 : Int = "3" extPlus "5"

//     İnfix fonksiyonlar extension fonksiyonlari kullanabilir
//    extPlus infix extension oldugu icin . (nokta) kullanimina ihtiyac duymaz
//    log ise sadece extension fonksiyon oldugu icin .(nokta) ile cagirilabilir

    ("3" extPlus "5").log ("")

/* ------------------------------------------------------------------------------------------------------------------ */
    /**
     *          Extensions fonksiyonlar bir sinifin icerisinde yazildilar ise kullanimi sadece o sinifin icerisinde
     *          olacaktır
     *          Sinifin disinda, Global yapilamaz
     *
     *          Int.extToString() methodu Shape sinifin icinde yazilmistir. Dolayısıyla Shape disinda erisilemez
     */

// 4.extToString()  -----------> Calismaz

    // Yine de extension methodu veren asagıdaki main gibi bir method ile erisilebilir.
    val shape = Shape()
    shape.setNumber(65)
    shape.main()





}

//  Normal fonksiyon

fun log2 (number: Number) {
    println(number)

}

/**
 *      Number (reciever) sinifindan extension olarak yazilmis log fonks. Ayni zamanda infix yapalım
 *      this ifadesi, extension yapilan degeri verir . 3 log "4" yaparsak
 *      asagidaki kod bize emptyParam = "4", this = 3 olarak verir.
 *
 */
infix  fun Number.log(emptyParam: String){
    println(emptyParam + this)
}
/**
 *
 *          İnfix extension fonksiyonu expression formunda kullanilabilir
 * **/
infix fun String.extPlus(otherString: String): Int = this.toInt() + otherString.toInt()

/* ------------------------------------------------------------------------------------------------------------- */


open  class  Shape {

    var intNumber = 0

    fun setNumber(intNumber: Int) {
        this.intNumber * intNumber
    }

    fun  main () {
        intNumber.extToString()
        intNumber.log("")
    }

/* --------------------------------------------------------------------------------------------------------------- */


        /**
        *   Bir sinifin  icinde, farkli bir sinifa ait extension fonksiyon yazilirsa, bu sinifin icinde normal
        *   bir fonksiyon olsa bile, extension fonksiyonun icerisinde, ayni isme sahip fonksiyon cagrilirsa, bu extension
         *  fonksiyonu isaret eder demektir. Sinifa ayni isimdeki uye fonksiyonun icerisinde cagirmak
         *  this@sinifismi.uyefonksiyon() seklinde cagırım yapmaliyiz.
        *
        *
        */

    open fun Int.extToString() {
        println("")


    // Int.extToString() methodu isaret eder
    extToString()

    // Shape'e ait asagıdaki uye methodu isaret eder
    this@Shape.extToString()

    println("Awesome class printi")
    }

    fun  extToString() {
        println("Keko class printi")
    }
}
/* ---------------------------------------------------------------------------------------------------------------- */

/**
 *  Bir sinifin, yazilmis extension fonksiyonun aynisini (isim ayni, parametre sayisi ve tipleri ayni, ayrica geri donus tipi de ayni)
 *  kendi icinde barindiriyorsa, bu durumda yazilan extension fonkisiyon gecersizdir. Sinifin uye fonks. cagrilir.
 *
 */

fun Shape.setNUmber(intNumber: Int) {
    val result = intNumber * intNumber              // Gecirsizdir cunku istediğimiz cağrilir asıl Shape classtaki setNumber fonk. gider
    println(result)
}

/* --------------------------------------------------------------------------------------------------------------------------------- */

/**
 *      Bir sinifin extension yazilabildigi gibi extension property de yazilabilir
 *      Bunun sebebi aslinda property'lerin get() ve set() methodlarindan olusmasinindan dolayidir.
 *      Bu extension propert'lerin icersinde field tanimlanamaz
 *      Dolayisiyla aslinda gercek anlamda bir degisken extension yapilamaz
 *      Bu konu property vs field konusu ile beraber siniflar islenirken detayli anlasilacaktir.
 *
 *
 * **/

var Shape.type
    get() = "Rectangle"
    set(value) {
        type = value
    }

/*   ---------------------------------------------------------------------------------------------------------------  */

/**
 *      Open (Extend edilebilir) bir sinifa, sinifin icinde bir open (override edilebilir) extension fonksiyon yazilirsa,
 *      bu sinifa miras(inherit) alan siniflar, ilgili fonksiyonu override edilebilir.
 * **/

class  Rectangle : Shape() {
    override fun Int.extToString(){

    }


}