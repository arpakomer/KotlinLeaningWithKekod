package classes

import java.lang.reflect.Field

class  WallPaper {
    /**
     *      Neden boyle yaptigimizi anlamak adina Show Kotlin Byte Code yapip arka plani anlayabilirsin.
     *
     */

    // Arkadaslar imageUrl her zaman 2. degisken olmali. Cunku reflection'da kullaniliyor
    private  var type: Int = 3
    private  var imageUrl: String = "www.kekod.com"
    private   var id: Int = 1242

    private  var wigth: Int = 1920
    private  var height: Int = 1080
    private  var isGif: Boolean = false
    private  var previewUrl : String = "www.kekod.com"
}

fun main() {
    val wallPaper = WallPaper()

//    wallPaper.imageUrl = "djfkljs"
//    wallPaper.id = 1242                   Burdaki degiskenlere ulamayiz cunku bunların erisim beliryecisi --> Private
//    wallPaper.type = 3
//    wallPaper.wigth = 1920
//    wallPaper.height = 1080
//    wallPaper.isGif = false
//    wallPaper.previewUrl = "dkjgldkjg"


    // Bu hatali gibi cunku apk dosyada officeCat yapılir ki String olmaz neye gore yapilmasini bilmedgiden yanlıs olur
    val imageUrlField: Field = wallPaper.javaClass.getDeclaredField("imageUrl")
    imageUrlField.isAccessible = true

    // Degiskenleri nerde oldugunu bilmiyorsam
    val imageUrlName = wallPaper.javaClass.declaredFields[1].name
    val imageUrlField2: Field = wallPaper.javaClass.getDeclaredField(imageUrlName)
    imageUrlField2.isAccessible = true


    val imageUrlString = imageUrlField.get(wallPaper)
    val imageUrlString2 = imageUrlField2.get(wallPaper)
    println(imageUrlString)
    println(imageUrlString2)


}