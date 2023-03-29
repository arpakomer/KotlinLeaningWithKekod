package classes

/**
 *  Interface'lerin Abstract class'lardan en buyuk fark "STATE" tutmuyor olmalari
 *
 *  Interface icerisindeki initial degeri almayan bir property (field) ya da body'si olmayan bir fonks
 *  Abstract olarak da tanimlanabilir
 *
 *  İnterfaceleri anlami geregi final yapamazlar. open yazilmasi da gerekesizdir ( Redundant )
 *
 */

interface MyInterface {
    val prop: Int  // abstract

    val propertyWithImplementation: String     // State tutmak degildir. Basitce bu bir property
    get() = "Foo"

//val propertyWithImplementation: String = "jdsfksjdf"
//    get() = "Foo"

//    fun getPropertyWithImplementation(): String {
//        return "Foo"
//
//    }

//    abstract val propertyWithImplementation: String
//    get() = "Foo"

//    abstract fun foo() {
//        print(prop)
//    }
     fun foo() {
    print(prop)         //Override etmemize gerek yok
    }

    fun foo2()   // Boyle fonks yazacagizz  .OVERRİDE etme zorunlulugu bulunmaktadir.

    //abstract da olabilir
     open abstract  fun bar()
}

/**
 * Interface'lere tanimlanan property'lerde (field) initial deger olma zorunlulugu yoktur.
 */

interface  Named {
    val fullName: String?
}

interface Person : Named {
    val firstName: String
    val lastName: String

    override val fullName: String?
        get() = "$firstName $lastName"
}

interface  A {
    fun foo() {
        print("A")
    }

    fun  bar()
}

interface B {
    fun foo() {
        print("B")
    }
    fun  bar() {
        print("Bar")
    }
}

/**
 *  Eger implement edilen interface, baska bir interface'i implement ediyorsa;
 *  ve bu interface'in uyeleri child interface'de override edilmis ise,
 *  child interface'i implement eden class'da bu propert'nin override edilme zorunlulugu kalkar
 * */

 class  Employmee (
    override val firstName: String,
    override val lastName: String,
    override val fullName: String?,
    val position: String
    ): Person

/**
 *  Eger bir abstract class bir interface'i implement ediyorsa. o interface override edilmesi
 *  zorunlu fonksiyonlarini override etmeyebilir Abstract class'lar icin bu opsiyoneldir
 *
 */
abstract class  employmee2 : Person {

}

/*
Düz bir class olan  "employmee3" Person interface'mizden implement aldık .
Person icindeki iki degiskeni override etmememiz zoronlu oldu.
Fakat ; Asagıdaki override etmeye gerek yok zaten Personda overrride edilmis
 override val fullName: String?
        get() = "$firstName $lastName"

*/
class  employmee3 : Person {
    override val firstName: String
        get() = TODO("Not yet implemented")
    override val lastName: String
        get() = TODO("Not yet implemented")

}

/**
 *  Bir class Abstract ise bir interface'i implement ettikten sonra bu interface'in fonksiyonlarini
 *  override etmek zorunda kalmiyor.
 *
 *  Bir interface icerisindeki fonksiyonlardan body'si olanlar override edilmek zorunlu degildir.
 *  Body'si olmayan tum fonksiyonlar ise class'a implement edildiginde override edilmek zorunda
 *
 *  Property'ler (field) de interfacelere tanimlanabilirler.
 *  Property'lerden de deger atamasi yapilmis olanlar zorunlu olarak override edilebilirler
 *  eger property get fonksiyonu ile bir statik deger geri donuyorsa , override etme zorunlulugu kalkar.
 *
 * İnterface icerisinde tanimli ve override edilme zorunlulugu olan propery'ler (field)
 * primary constructor icerisinde de overrride edilebilirler
 *
 * Body'si olan (overrride edilme zorunlugu olmayan) bir interface fonksiyonu overrride edilirse,
 * override edildigi yerde body'si icerisinden super'i cagirilabilirler (cagirmak zorunda degilsiniz )
 *
 */

class  Child(override val prop: Int = 25) : MyInterface {

    // Override edilmesi zorunlu olmayan
    override  val propertyWithImplementation: String
    get() = "Implement Property"



    override fun foo2() {
    TODO("Not yet implement")
    }

    override fun bar() {
        TODO("Not yet implemented")
    }
//
//    override fun bar() {
//       super.bar    ----> Neden hata vermekte ? Abstract fonk body'si olmadıgından super diye cagrilmasina izin vermez
//
//    }



    // body'si oldugu icin override edilme zorunlulugu yok
//     override fun foo() {
//         super.foo()
//     }
}

open class E() {

}



/**
 *
 *  Birden fazla interface bir class'a tanimlanabilir
 *
 *  Birden fazla interface bir class'a tanimlanirken aralarina virgul koyulur
 *
 *  : İsaretinden sonra eklenen yapilar hangilerinin class(inheritance)
 *  hangilerinin  interface(imlepementation) oldugunu karistirmamak icin;
 *  bu yapilarin sonuna bakmamiz lazim. Sonuna () parantezlerini gorursek : den sonra
 *  gelen class'tir(Inheritance) miras alma islemi yapiliyordur. () yoksa Interface'dir(implement)
 *  islemi yapiliyordur.
 */


/**
 *  2 Farkli interface'in ayni fonksiyonlari olmasi durumunda , bu fonks. override edilmesi
 *  sirasinda ayni fonksiyonu 2 kere yazarak override edemeyiz.
 *
 *  Eger implement ettigimiz interface'lerin ayni isimde fonksiyonlari bulunuyorsa, tek bir fonks
 *  override islemi yapilir. Bunun icerisinden hangisinin body'sine erismek istiyorsak
 *  o interface'in ismine <> isaretleri arasina yazmamiz gerekiyor.
 *
 *
 *
 * Eger implement edilen 2 interface de ayni fonksiyonlar varsa bu durumda body'leri olan da
 * override edilmeleri zorunludur.
 *
 *
 */
class  D : E(), A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
//        super.foo() // Hangisine gidecegini bilemez uyarı verir.
    }

    override fun bar() {
//        super<A>.bar()  A interface'inin bar fonks body'si yoktur o yuzden direk oraya gidemeyiz
        super<B>.bar() // <B> sonuk oldu .Neden ? bu arayuzu yazmak zorunda degiliz.Buna reduntant uyarisi verilir.
        super.bar()
    }
}
