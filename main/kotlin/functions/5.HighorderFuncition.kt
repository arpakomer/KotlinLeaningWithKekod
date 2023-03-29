package functions

import java.util.*
import kotlin.concurrent.schedule

fun main() {

    /**
     *  Function kotlinde "First Class Citizen"
     *                                                        1-) Yani bir degiskene deger olarak atanmasi
     *      val name = "Gokhan"
     *      val surName = "OZTURK"
     *      val fullName = name + "" + surName
     *
     *      fun deneme(fullName: String): String {
     *
     *                                                     Fonksiyonun geri degeri olabilir.
     *       return "Merhaba + $fullName"
     *   }
     *
     *      fun deneme2(fullName: String): String {
     *           return "Merhaba+ $fullName"
     *   }
     *                                                     2-) Baska fonksiyona parametre olarak verilebilir.
     *     val welcomeMessage =  deneme(fullName)
     *  deneme (deneme2(fullName))
     *
     * **/
/* ------------------------------------------------------------------------------------------------------------------ */

    /**
     *       Higher Order Function tanimlamamizin 3 yolu vardir.
     */
    // Bir degisken atayarak Higher Order Funciton tanimlayabiliriz.
    // Bu durumda suslu parantezler yanina higher order function'in aldigi parametre LAMBDA okundan once
    // koyularak yazilir. Higher order Funciton tek parametre aliyorsa, bu parametreleri yazmak zorunda degiliz.
    // Bu durumda higher order function bize "İT" kelimesiyle higher order function'in parametresi tipinde degisken verecektir.

    val higherOrderFunction = { surName: String ->
        println("surName : $surName")            // Bir fonksion badisini bir degiskene atamak
        "surName : $surName"
    }

    // Ismi olmayan "anonymous function" tanimlari da Higher Order Function olarak, normal bir fonksiyon
    // olarak verilebilir.
    val  ananyoumusFunction = fun(surName: String): String {
        return  "surName : $surName"
    }

    // Anonymous function'in expession kullanimi da yine Higher order function olarak normal bir fonksiyon
    // olarak verilebilir.

    val anonymousFunction = fun(surName: String): String = "surName: $surName"


    // Duz olarak gorunen fonksiyonumuz bir higher order fonksiyondur
    fun  logPrint(message: String): String {
        return  "Log: $message"
    }

    fun foo(higherOrderFunction: (message: String) -> String){
        higherOrderFunction("Codemy")
    }

    logPrint("Hersey Yolunda")
//    foo(::logPrint("Hersey yolunda"))
//    foo(logPrint("Hersey yolunda"))

    /**
     *    Higher order function'la ayni parametre sayisina sahip ve bu parametrelerin hepsinin tipleri Higher order
     *   parametre tipleri ile ayni ise, bu normal fonksiyon da Higher order Function olarak normal bir fonksiyon olarak
     *   verebiliriz. Bunu yapmak için sadece başına :: isareti koymak yeterlidir
     *  **/
    foo(::logPrint)





    val news = News()
    news.read(::println)
    news.read{ title ->
        print("asdsads")
    }
    news.read {title ->
        print(title)
    }
    news.read {              // H.O.F tek parametre ise
        print(it)
    }

    val titleFun = fun(title: String): Unit {
        print(title)               // İsimsiz fonksiyon
    }

    news.read(titleFun)

    printUserInfo(getName(), higherOrderFunction, getAge())
    printUserInfo(getName(), anonymousFunction, getAge())
    printUserInfo(getName(), fun(surName: String): String{
        return "surName :  $surName"
    }, getAge())

    //Suslu parantezler (body) direkt olarak Higher Order Function'in parametre beklemedigi alana
    printUserInfo(getName(), {
        "surName : $it"
    }, getAge())

    getItemClickListener{buttonName ->
        println("$buttonName tiklandi..")
    }

/*  ------------------------------------------------------------------------------------------------------ */
    /**
     *  Eger bir fonksiyon parametreleri icerisinde bir Higher Order Function son parametre olarak tanimlaniyorsa bu durumda
     *  -istenmiyorsa, bu Higher Order Function, fonksiyon parametrelerinin disina da yazilabilir. Daha temiz
     *  yapmis oluruz
     * **/
    val newsType = NewsType()
    news.getNewsFromServer("FoxTv",newsType, {
        println(this.toString())
    }) // Higher Order Function, fonksiyon parametrelerinin icerisinde tanimlanmistir.

    news.getNewsFromServer("FoxTv", newsType){
        println(this.toString())
    } // Higher Order Function, fonksiyon parametrelerinin disinda tanimlanmistir.

/* -------------------------------------------------------------------------------------------------------------------*/
    /**
     *      Higher Order Function birden fazla parametre iceriyorsa, aralarina virgul koyarak Lambda isareti ile tanimlamak zorunlu
     *      Tek parametreye sahipse bu durumda parametre ismi ve lambda isareti konulmayabilir. Bu durumda ilgili parametre "it"
     *      kelimesi ile cagrilabilecektir.
     *      Eger bir fonksiyon, parametre olarak sadece Higher Order Function aliyorsa bu durumda fonksiyon
     *      parantezlerini hic yazmayabilirsiniz
     */

    news.filterNews { filterType, getFilterName ->
        print("$filterType")
        getFilterName()
    }


}
/* -------------------------------------------------------------------------------------------------------------------*/

// Normal Fonksiyon
fun getName(): String {
    return "Gokhan"
}

//Normal FOnksiyon, expression kullanima ornek
fun  getAge(): Int = 25
/**
 *     2.parametre Higher Order Fonksiyon olarak tanimlanmistir
 *     Higher Order Fonksiyonlar default deger alabilirler. Bunun icin basitce suslu parantezler acmak yeterlidir.
 *     Dikkat edilmesi gereken konu bu suslu parantezler icine, Higher Order Function paramatre bekliyorsa, bunlar
 *     verilmelidir
 */

fun printUserInfo(name: String, getSurName: (surName: String) -> String = { surName -> ""}, age: Int): Unit{
    println("name: $name , age : $age")

    println(getSurName("ARPAK"))
}

/* -------------------------------------------------------------------------------------------------------------------*/

/**
 *      Higher Order Function'a parametre tanimlarken sadece degisken tipini tanimlayarak da (degisken adi olmadan) kullanabiliriz.
 */

fun getItemClickListener(onClick: (String) -> Unit) {
    println("Tiklama islemi baslatiliyor")

    Timer().schedule(3000){

        // Bir higher order function, parametre olarak yazildiktan sonra, bu parametrenin normal fonksiyon icerisinde
        // cagrilmasi gerekmektedir. Aksi halde bu higher order fonksiyonu tanimlamak mantiksiz olur. Normal  fonksiyonun
        //cagrildigi alandaki higher order function'in body kismi hicbir zaman cagrilmaz demek olur.

        onClick("Login")

        println("Tiklama İsi Bitti")
    }
}

/* ------------------------------------------------------------------------------------------------------------------ */
class  News{
    fun getNewsTypes(newsType: NewsType): String {
        return when (newsType.toString()) {
            NewsType.breakingNews -> "BreakingNews"
            NewsType.urgent -> "Urgent"
            NewsType.local -> "Local"
            NewsType.global -> "Global"
            else -> "Normal"
        }
    }

}
class NewsType {
    companion object {
        val breakingNews = "BreakingNews"
        val urgent = "Urgent"
        val local = "Local"
        val global = "Global"
        val normal = "Normal"

    }
}
/**
 *   Bir Higher Order Function'a parametre verirken Class ismi.() seklinde tanimlama yapilabilir
 *   Bu sayede ilgili class da parametre parantezi icerisine yazilabilir
 */
fun News.getNewsFromServer(channelType: String, newsType: NewsType, getNews: NewsType.(Int) -> Unit) {
    when(channelType) {
        "KanalD" -> {
            getNews(newsType,1)
        }"Show" -> {
            getNews(newsType,2)
        } "Tv8" -> {
            getNews(newsType,3)
        } "FoxTv" -> {
            getNews(newsType,3)
        } "CNN" -> {
            getNews(newsType,3)
        }
    }
}


/**
 *      Bir Higher Order Function'sin parametresi de yine Higher Order Function olabilir.
 */
 infix  fun News.filterNews (getFilter: (filterType: String, getFilterName: () -> String) -> Unit){

    val getFilterNameHO = {
        "String return label"
    }
    val getFilterNameHO2 = fun (): String{
        return "String return label"
    }

    val getFilterNameHO3 = fun(): String = "String return label"

    fun getFilterNameHO4(): String{
        return "String return label"
    }
    fun getFilterNameHO5(): String = "String return label"

    getFilter("FilterName") {
        "String return label"
    }
    getFilter("filterName", getFilterNameHO)
    getFilter("filterName", getFilterNameHO2)
    getFilter("filterName", getFilterNameHO3)
    getFilter("filterName",::getFilterNameHO4)
    getFilter("filterName",::getFilterNameHO5)

 }

 infix fun News.read(readTitle: (title: String) -> Unit) {
    readTitle("Codemy is Awesome")
}