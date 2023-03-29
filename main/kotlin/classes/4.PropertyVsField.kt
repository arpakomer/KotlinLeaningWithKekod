package classes


class  BankAccount {
    var balance = 1_000_000

    /* Arka kisminda nasil degismekte
     Modifier'imiz PUBLİC
    private var balance = 1_000_000
        fun getBalance(){

        }
        fun setBalance(value : Int) {

        }
     */

          get() {
                // Private izin vermez

            return field // baking field
            }
          private  set(value) {
            field = value

            }

    private  var dept = 450000
     //  Modifier PRİVATE BUNDAN DOLAYI GET_ SET Yok Arka kisminda ---> private var balance = 1_000_000 seklindedir.

    fun uyeFonksiyon(){
        balance
    }
}

fun main() {
    val bankAccount = BankAccount()
    println(bankAccount.balance)

}

// Gizlilik sirasi ========> Private > Protected > Internal > Public