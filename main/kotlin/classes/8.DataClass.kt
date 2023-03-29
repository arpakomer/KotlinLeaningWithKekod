package classes


/*
    Constructor icinde bir degiskeni val ya da var yazmak
 */

/**
 *  En az 1 parametre olmak zorundadir
 *  Parametreler mutlaka val ya da var ile tanimlanmak zorunda
 *  Open, abstract ,sealed, inner class yapilamaz
 *  Tum data class'lari final oldugu icin final modifier'i redundant uyarisi verir
 *
 *  Equals, hashCode, toString, copy, companentN fonks. arka planda default olarak olusturulurlar.
 *
 *  yukardakilerden  fonks. birisi override edilirse, oto generate hali yazilmaz
 *
 *  yukardaki fonks. sadece primary const. icerisindeki degiskenlerle calisir.
 *
 *  companentN  fonksiyonlari sebebiyle destructuring declaration olarak data class'lar set edilebilirler
 *
 *  toString gibi fonksiyonlarda primary const. degiskenleri kullanildigi icin val ya da var yazilmak zorunda
 *
 *  Pair, Triple ozellestirilmis generic data class'lar mevcut
 */

data class News(
    val title: String = "Title",
    val description: String,
    val hasMediaContent: Boolean,         //Primary cons. icerisinde degisken tanimlamakla const. disinda uye bir degisken tanımlamak
    val mediaList: List<Media>           // arasında fark vardır
) {
    val relatedNewsList: List<News> =
        arrayListOf() //Equals, hashCode, toString, copy, companentN override arka planda olusmaz

    override fun toString(): String {
        return " return super.toString()"
    }

    fun log() {
        println("Title : $title, description : $description")
    }
}

class NewsData(
    val title: String = "Title", val description: String, val hasMediaContent: Boolean, val mediaList: List<Media>
) {
    val relatedNewsList: List<News> = arrayListOf()
    override fun toString(): String {
        return "NewsData(title='$title', description='$description', hasMediaContent=$hasMediaContent, mediaList=$mediaList)"
    }

    fun copy(): NewsData {
        return NewsData(title, description, hasMediaContent, mediaList)
    }
}


class Media


fun main() {
    // Data classimiz
    val newsOne = News(
        title = " Data classlari ogrenmeye basladım",
        description = "ViraBismillAllah diyelim ",
        hasMediaContent = true,
        mediaList = arrayListOf()
    )
//    val newsOne = News(
//         " Data classlari ogrenmeye basladım", NAME ARGUMENT Yazmadıgımız (yukardaki title = ..)
//    "ViraBismillAllah diyeilim ",
//         true,
//        arrayListOf()
//    )

    // Duz classimiz
    val newsTwo = NewsData(
        title = " Data classlari ogrenmeye basladım",
        description = "ViraBismillAllah diyeilim ",
        hasMediaContent = true,
        mediaList = arrayListOf()
    )
//    val NewsTwo = NewsData(
//         " Data classlari ogrenmeye basladım", NAME ARGUMENT Yazmadıgımız (yukardaki title = ..)
//         "ViraBismillAllah diyeilim ",
//         true,
//         arrayListOf()
//    )

    //destructuring declaration
    val (title, description, hasMediaContent, mediaList) = newsOne


// newsOne.equals()

    newsOne.toString()
    newsOne.hashCode()


    val newsThree = newsOne.copy(description = "Farkli description") // İlgili data class'i description ozelligini copyaladım.
    newsOne.component1()

    newsOne.relatedNewsList
    newsOne.title

//    newsTwo.equals()
    newsTwo.toString()
    newsTwo.hashCode()
//    newsTwo.copy()
//    newsTwo.component1()

    println("Data Class toString : $newsOne")
    println("Data Class toString : $newsTwo")

    val pair = Pair("Gokhan", "Gokhan")
    val (firsasdadsa, sfdsfsd, asfasfa) = Triple("Gokhan", "Gokhan", "32")

}