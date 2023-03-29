package classes



interface  Print2 {
    fun onPrint()

}

open class User(val age: Int) {
    open fun getUserFullName() {

    }
}
//2 superType var ,hangisini cast edeceksen belirtmelisin
val fullName : User = object: Print2, User(25) {

        val firstName = "Gokhan"
        val surName  = "ÖZTÜRK"

        override fun  onPrint() {
            println("Full name = $firstName $surName")
        }

        override fun getUserFullName() {
            super.getUserFullName()

            /*Open bir class'dan miras aldık bunu override ettigimizde baska islem
            yapmazsak sadece yukardan bir super ile cagrılması redundant uyarısı vermekte
            Ama biz bir islem yaparsak redundant gececektir
            bu kod blogu icinde

            ----İslemler ---
            */

        }


    //User class'ini kullandık bundan dolayı oda bir -gorunmez sekilde - Any sınıfı icinde toString() var. Bundan dolayı
        override fun toString(): String {
            return "$firstName $surName"
        }

}


fun main() {
    fullName.getUserFullName()
    println("Full name = $fullName")

    // Android'de kullandigimiz object - expresision'in iki ornegi

//    textView.addTextWatcher(object : TextWatcher(){
//        before
//        after
//        on
//    })
//
//    object : CountDownTimer(10000, 1000){
//        override fun onTick(){
//
//        }
//        override fun onFinish(){
//
//        }
//    }.start()


    "Gokhan".print("ÖZTÜRK")
    "Gokhan" print "ÖZTÜRK"
}


infix fun String.print(secondText: String){
    println(this + secondText)
}
