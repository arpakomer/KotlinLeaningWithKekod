package functions

import java.math.BigDecimal


fun main() {
    var bankAccount: BankAccount? = null
    bankAccount = BankAccount(
        234522.32.toBigDecimal(),  "Omer"
    )

    if (bankAccount != null && bankAccount.accountName != null) {
        println(bankAccount.accountName)
    }

/*
Let kullanim yaratilan nesne Nullable ise bunu kullaniriz .Bir nevi "NULLCHECK" kontrolu  yapariz
 */
    bankAccount.let {

        //                 Generic<T,R> T.Let "Extension ( T tipinde R donus verir) En son Scoope da R dir
//        public inline fun <T, R> T.let(block: (T) -> R): R { }

        if (bankAccount != null && bankAccount.accountName != null) {
            println(bankAccount.accountName)
        }
        if (it != null && it.accountName != null) {
            println(bankAccount.accountName)
        }


    }


/*
With kullanim yaratilan nesne hali hazirda nullable degilse yani icerisinde deger varsa
 */
    //    bankAccount.with { ----------  }  olarak yazamadım neden ? With bir extension fonks. degil

    //public inline fun <T, R> with(receiver: T, block: T.() -> R): R
    with(bankAccount) {
        if (bankAccount != null && bankAccount.accountName != null) {
            println(bankAccount.accountName)
        }
        if (this != null && this.accountName != null) {
            println(bankAccount.accountName)
        }
    }


 /* let --->> public inline fun <T, R> T.let(block: (T) -> R): R { }

     */
    // Let le aynı fakat ilgili yerde T.() -- > it degil This'le Alırız
    //public inline fun <T, R> T.run(block: T.() -> R): R
    bankAccount.run {
        if (bankAccount != null && bankAccount.accountName != null) {
            println(bankAccount.accountName)
        }
        if (this != null && this.accountName != null) {
            println(bankAccount.accountName)
        }
    }


    /* Burdaki run yukardaki bankAccount gerek duyulmayan ozeliiklerde kullanilir*/
//    run{
//
//    }



    //            it vermektedir  .Son satir bir sey versende onem yok
    // public inline fun <T> T.also(block: (T) -> kotlin.Unit): T
    bankAccount.also {
        if (bankAccount != null && bankAccount.accountName != null) {
            println(bankAccount.accountName)
        }
        if (it != null && it.accountName != null) {
            println(bankAccount.accountName)
        }

    }







    //                                 this olarak verilir
    //public inline fun <T> T.apply(block: T.() -> kotlin.Unit): T
    BankAccount22().apply {
    // Nesneyi burda olusturduk.
//        if (bankAccount != null && bankAccount.accountName != null) {
//        println(bankAccount.accountName)
//    }
//        if (this != null && this.accountName != null) {
//            println(bankAccount.accountName)
//        }
//
//    }
        //Constructorda olmayan degiskenler kullandık.Ilk deger atamasi burda yaptik
         accountBalance = 1223.32.toBigDecimal()
         accountName = "dksflsdkf"
    }
    println(bankAccount.accountBalance)
}


data class BankAccount(
    val accountBalance: BigDecimal?,
    val accountName: String?
)

class BankAccount22(){
    var accountBalance: BigDecimal? = null
    var accountName: String? = null
}



