package basic

fun main(){

    /**
     *  3 tane çift tırnak kullanılmasına Row String denilmektedir.
     *  Row stringler ide'ye nasıl yazılıyorsa oyle kullanılabilir.Halihazırda bozulma olmaz
     *  trimIndent() fonks. ile bu Row String'in kenar bosluklarını alabiliriz
     *  Bu silme işlemini yaparken tum satırlardaki ve soldaki krakeri baz alarak silme islemi sağlanır
     *  Alttaki ornek için 3 satirdan da $ işraetinin solundaki bosluğa kadarini siler
     *  Row Stringlerin içinde escape krakterler çalışmaz
     */

    val rowPineTree = """
         *
    $   ***
       ***** 
    """.trimIndent()
}
