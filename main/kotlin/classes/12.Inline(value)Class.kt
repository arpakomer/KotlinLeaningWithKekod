package classes



//val blance: Int = 2500

open class BankAccount2(val blance: Int) {
    val branchCode: Long = 3245

}

interface  Print {
    fun printBalance()

}

@JvmInline
value class  Bankaccount3(val blance: Int): Print {
    init {
        println("balance: $blance")
    }
//    val accountNumber: Long = 12345565623432

    val accountNumber: Long
        get() {
            return  123456789
        }

    fun getAccountNumber2(): Long {
        return  123456789

    }

    override fun printBalance() {
        println("Interface print - blance: $blance")
    }
}

/**
 *  value clas'lar @jvmInline annotation olmadan henuz kullanilamiyor
 *
 *  value class'lar suan icin sadece tek bir degisken kabul etmektedir. Birden fazla degiskene izin verilmez
 *  Ancak value class'larin dokumantasyonunda inline class'larin ilerede birden fazla degisken olabilmesine
 *  izin verilecegi yaziliyor.
 *
 *
 * Inline class'lar ile init block'u kullanilabilir
 *
 *  Inline class'larin  belirtilen constructor'lari java kodunda private olarak bulunurlar
 *  Bundan dolayi zaten istesek de bu constructor'lari nesnesi olusturlamaz. Ama bunu yapabiliyor olarak gorunmemizin sebebi
 *  gercekte o nesnenin hic yaratilmiyor sebebiyledir.
 *  Bizim nesne olustururken gordugumuz sey aslinda const. icindeki degiskenin kendisi.
 *
 *  İnlene class'lar icinde property tanimlamasina izin verilir. Ancak bu property'in backing filed olamaz
 *
 *  İnline class'lar herhangi bir interface'i implement edebilirler, ama  bir baska class'i miras alamazlar
 *
 *  İnline class'lar miras alinamaz. Cunku default olarak final'lardir ve degistirilmezler
 *  Open keyword'u beraber kullanilmaz. final keyword'u vermek de redundant uyarisi verir.
 *  abstract keyword'u ile de kullanilmaz
 *
 */

interface I


@JvmInline
value class Foo2(val i: Int) : I

fun asInline(f: Foo2){}
fun <T> asGeneric(x: T){}
fun asinterface(i: I) {}
fun asNullable(i: Foo2?) {}

fun <T> id(x: T): T = x



fun main () {
    val blance2: BankAccount2 = BankAccount2(25000) //Reference (class nesnesi) olarak tutulur

    val blance3: Bankaccount3 = Bankaccount3(25000) // Primitive olarak tutulmakta



    val f = Foo2(42) //f'in tipi int -> primitive -> unboxed

//    val f2 : Int = 42

    asInline(f)     //Unboxed: used as Foo2 itself
    asGeneric(f)    //boxed: used as generic type f
    asinterface(f)  //boxed: used as type I
    asNullable(f)   //boxed: used as Foo2?, which in diffirent from Foo2

    //below, "f" first is boxed (while being passed to 'id') and then unboxed (when return from 'id')
    // ın the end, 'c' contains unboxed representation (just '42'), as 'f'
    val c = id(f)



}
