package classes



data class User5(
    val name: String = "Gokhan",
    val surName: String = "OZTURK"
)

class  CardDetailFragment {
    val user: User5 by lazy(LazyThreadSafetyMode.PUBLICATION) {
        println("User5 Init")
        User5()
    }

    lateinit var user2: User5

    lateinit var userType: String

    fun printUserInfo() {
        println("name: ${user.name}, surName = ${user.surName}")


        //KProperty0: Kontrol islemi yapilabilir.
        if (this :: user2.isInitialized.not()) {
            user2 = User5()
        }
        println("name: ${user2.name}, surName = ${user2.surName}")
    }

    init {
        userType = "Premium"
    }
}

class BankAccount5 (
//    val balanceChanged: BalanceChanged
    inline val balanceChanged: (Long) -> Unit
){
    var balance: Long = 1_000_000
        set(value) {
            field = value


        if(value <= 100) {
            balanceChanged.invoke(value)
        }
    }
}

fun main() {
    val cardDetailFragment = CardDetailFragment()
    cardDetailFragment.printUserInfo()        //Aslinda bu  direct cagirim dogru kod olmaz ama dersi anlamak adina yazildi.
    cardDetailFragment.printUserInfo()

//    val balanceChanged = object : BalanceChanged {
//        override fun onBlanceChanged(changedBalance: Long) {
//            sendPushNotification(changedBalance)
//        }
//    }
//
//    val bankAccount5 = BankAccount5(balanceChanged)
//    val bankAccount5 = BankAccount5(onBalanceChanged)
//
//
//
//
//    val bankAccount5 = BankAccount5 {
//        sendPushNotification(it)
//    }
    val bankAccount5 = BankAccount5(::sendPushNotification)

    println("Balance: ${bankAccount5.balance}")

    bankAccount5.balance = 90
}


fun sendPushNotification(changedBalance: Long) {
    println("Gardaşım param bitiyor:  ${changedBalance}")
    println("Üzülme paraya ihtiyacın varsa, ihtiyac kredin yanında. Şimdi başvur")

}
