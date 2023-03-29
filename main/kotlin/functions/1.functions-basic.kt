package functions


/**
 *
 *      fun keyword'u ile fonks baslar
 *      fonksiyon ismi verilir
 *      parametre parantizleri acilir ve parantezler girilir
 *      : operatoru ve geri donus degeri yazilir
 *      fonksiyon body'si acilir ve kapatilabilir
 *      Geri donus degeri verilmeyen fonksiyonlar unit tipini geri dondurur
 *
 */

//val name : String = "Omer"
//fun name : String = "Omer"
//fun name(val surName : String = "Omer") : String = "Omer"
//fun name(surName: String = "Omer") : String = "Omer"

fun  main(){
/**
 *       @param number degiskeni tanimlanir gibi tanimlanir
 *      Fonksiyon parametresi tanimlanirken ,val var betimleyiciler kullanilmaz
 *
  **/
//        fun  manin(number : Int): Int{...}

/* ---------------------------------------------------------------------------------------------------------------- */

    // Bir classi'in fonksiyonu cagrirsak nokta isaretini kullaniriz

    Math.pow(3.1, 4.1)


/* ---------------------------------------------------------------------------------------------------------------- */

    /**
     *     = ile fonksiyonlara default deger verilebilir( Default Argument)
     *     Default deger atamasi yapmak function overload islemi yapmamizi saglar
     *     Tekrar tekrar ayni fonks. farkli varyasyonlari yazmak durumunda kalmayiz
     */



    // Default degeri olan parametrelere sahip bir fonksiyon cagirilirken, default degeri olan parametrelere deger ataması
    // sart degiildir. Default degeri olan bu parametreler opsiyonel parametrelerdi
    //  Default degeri olan parametrelere deger atamadan fonksiyon cagrilacaksa bu durumda paremetre sirasi degisir
    //    Ide'ye hangi parametreye deger atadiginizi soylemek icin NAMED ARGUMENT'leri kullanmamiz gerekir

    reformatMessage("Message",true,7, "tr")
    reformatMessage(message = "Message", size = 7, lang = "tr")
    reformatMessage("Message", true, 7)
    reformatMessage("Message", size = 7)

  /*  --------------------------------------------------------------------------------------------------------------- */

/**
 *     Cok uzun sure parametreniz olacaksa "variable number of arguments" - vararg tanimlayabiliriz
 *     Bu sayede fonksiyon tek bir parametre aliyor gibi gozukurken kendisine cok miktarda degisken atanabilir.
 *     Bu degiskenlere array'e erisir gibi erissebiliriz. [index] ya da .get(index) seklinde
 *
 *     vararg tek ya da son paremetre olarak yazilirsa, Jvm'e hazirlanirken, Java'daki "String..." gibiayni kod derler
 *     Ancak vararg param birden fazla tanimlanirken ortada ya da basta yer alirsa, Jvm'e hazirlanirken, Array'e donustu
 *     Bu da performans farki olusturur demektir.
 *
 **/


    // *********  vararg bittigini soyelemek icin sonradan NAMED argument kullaniyoruz


//vararg kullanimina key = 3'den onceki parametreler vararg parametresine denk gelir
    getUserInfo("Omer", "Arpak", "Van", "Türkiye", "", "", key = 3)

// vararg parametresi olarak arrayOf kullanilmak istenirse  * operatoru kullanmaliyiz (spread operatoru)
//Bu operator diger diilerdeki pointer kullanimi anlamina gelir. KOtlinde pointer'lar yoktur

 getUserInfo(* arrayOf("Omer", "ARPAK", "Van", "Türkiye"), key = 3)


 getUserInfo2(3,"Omer", "Arpak", "Van", "Türkiye", "", "","")


 getUserInfo3(3,"Omer", "Arpak", "Van", "Türkiye", "", "", true, 3.14, "")


 /**
  *      Ayni fonksiyon icerisinde birden fazla tanimi yapilmasina izin verilmez
  *      Calismaz. Commet'i kaldir kontrol et
  *
  * **/
// fun getUserInfo(vararg userInfo: String, vararg userInfo2: string){
// userInfo[3]
// }

/* -----------------------------------------------------------------------------------------------*/

}

fun reformatMessage(message: String, isUpperCase: Boolean = false, size: Int, lang: String = "tr"){
    println("Message : " + message + "isUpperCase : " + isUpperCase + "size : " + size + "lang : " + lang)
}



fun getUserInfo(vararg userInfo: String, key: Int){
    userInfo[3]
    userInfo.get(3)
}

fun getUserInfo2(key: Int, vararg  userInfo: String){
    userInfo[3]
    userInfo.get(3)
    println(key)
}
fun getUserInfo3(vararg  userInfo: Any){

}

  /**
   *  Bir fonksiyon = koyularak ya da return edecegi deger yazilabilir (Sİngle-Experrsion kullanim)
   *  Tek satirsa tabi
   * **/

val userList = arrayOfNulls<String>(5)

fun getListCount(): Int = userList.size

    fun getListCount2(): Int {
        return userList.size
    }
