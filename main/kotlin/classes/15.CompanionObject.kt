package classes



interface  HomeFragmentPresenter {
    fun navigate()

    //Hava olsun diye --> Yapmasam daha iyi olur.İnterface icerisine de companion object tanimlayabilirim
    companion object {
        val name = "Gokhan"
    }
}

abstract class BaseFragment() {


}

class HomeFragment: E(),HomeFragmentPresenter {
//      const val TAg : String = "HomeFragment"

    var color = "Red"

    companion object Named : BaseFragment(){
        const val TAG : String = "HomeFragment"

        private var homeFragment: HomeFragment? = null
        fun newInstance(): HomeFragment{
            homeFragment = HomeFragment()
            return  homeFragment as HomeFragment
        }
//        override fun navigate() {
//
//        }


    }

    override fun navigate() {

    }
    fun stateAlImplemented () {
        println(HomeFragmentPresenter.name)
    }

}

fun main() {

    val homeFragment = HomeFragment.newInstance()
    homeFragment.color = "Blue"

    val homeFragment2 = HomeFragment.newInstance()
    homeFragment2.color = "Yellow"

    val homeFragment3 = HomeFragment.newInstance()
    homeFragment3.color = "Cyan"

    val homeFragment4 = HomeFragment.newInstance()
    homeFragment4.color = "Maganta"

    println("homeFragment color: ${homeFragment.color}")
    println("homeFragment2 color: ${homeFragment2.color}")
    println("homeFragment3 color: ${homeFragment3.color}")
    println("homeFragment4 color: ${homeFragment4.color}")
}