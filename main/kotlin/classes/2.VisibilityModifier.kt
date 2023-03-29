package classes



//protected fun getCustgokhanName(): String {
//     return "Customgokhan name"
// }

open  class  Foo{

    private val name = "Gokhan"

    public  var Surname = "OZTURK"

    protected val email = "gokhanozturk@inonu.edu.tr" // child class'larda public - harici tum class'larda private

    internal  val age = 25 // Module icerisinde public - harici modullerde private

    fun  printName(){
        println("Merhaba $name")
        println("SurName $Surname")
        println("Email $email")
    }

    // Private bir degiskene dısarda  erismek istemek

    fun getName():String{
        return  name
    }
}




fun main() {
    val foo = Foo()

//    foo.name = "abcd"
      foo.Surname = "dfsdfsfds"
}