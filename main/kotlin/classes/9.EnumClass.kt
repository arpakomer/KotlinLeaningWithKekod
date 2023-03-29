package classes


/**
 *  Tip guvenligi (type-safety) saglar
 *  Kullanim amaci  ayni veri kumelerinin gruplanabilir olmasini saglar
 *  Opsiyonlarin tamaminin neler oldgunu rahatca gorebilmemizi saglar
 *
 *  abstract, open , inner, sealed olamazlar.
 *  yapisi geregi zaten final'dirlar. Final keyword'u kullanmak redundant uyarisi verir.
 *
 *  Ozunde class olduklari icin, constructor kullanabilirler ve bu constructor icerisinde veri tutabilirler
 *  java karsiliginda bu enum sabitleri static final class'lar seklinde tutulurlar
 *  Bu sayede kullanilirken bu sabitlerin nesnesini olusturmak zorunda kalmayız.
 *
 *
 *  Enum class'larinin nesnesi olusturulamaz.
 *
 *  Her enum sabiti final name: String ve final ordinal: Int degiskenlere default olarak sahiptir
 *  name ifadesi, enum'in kendisinin string halini verir.
 *  ordinal ifade, enum'daki sabitin index'ini verir ve 0'dan baslar.
 *  bu degiskenler final olduklari icin, enum sabitleri icerisinde override edilemezler.
 *
 *
 *  enum class'lar herhangi bir baska class'i miras olamazlar.
 *  enum class'lar herhangi bir interface'i implement edebilirler
 *
 *  enum class'lar abstract property'ler ya da abstract func.'lar olabilirler
 *  Bunlari aldiklarinda tum sabitler bu abstract yapilari override etmek zorunda
 *
 *  Bir open function da yazilabilrler. Open  olmasindan dolayi override etmek zorunlulugu yoktur
 *  Ancak open olarak belirtilen func.'nun body'si olmak zorundadir.
 *
 */

interface  TeamFunctionality{
    fun pratice()
}
    // En basit haliyle boyle kullanilir
enum class ColorType {
    RED, BLUE, WHITE  //(3 Parametre verebilirim)Opsiyonlarin tamaminin neler oldgunu rahatca gorebilmemizi saglar
}

/*
                Icerisinde bir value tasiyacaksak
enum class Teams(val starCount: Int) {
    FENERBAHCE (starCount 4),
    GALATASARAY (starCount 4),                   // ilk enum basit hali
    BESİKTAS (starCount 3),
    VANSPOR (starCount 65);
}
*/

enum class Teams(val starCount: Int) : TeamFunctionality {
    FENERBAHCE(4){       // Enum sabitlerinin isimleri Hepsi BUYUK harfle yazilir
        override fun pratice() {
            TODO("Not yet implemented")
        }

    },
    GALATASARAY(4){
        override fun pratice() {
            TODO("Not yet implemented")
        }
    },
    BESIKTAS(3){
        override fun pratice() {
            TODO("Not yet implemented")
        }
    },
    VANSPOR(65) {
        override fun pratice() {
            TODO("Not yet implemented")
        }
    };
//     override fun pratice() {
//       TODO("Not yet implemented")    // Teams icinde override etme demek FENERBHCE, GALATASARAY,BESIKTAS,VANSPOR
//                                            icinde override etmek zorunlulugu kalkar cunku Teams bunların ust class'i.
//                                        Disinda override etmezsek ilgili enum sabitlerinde override etmek zorundayiz
//     }

            // Asagidaki  iki degiskeni yazmasak da olur default olarak varlar
//    override  val name: String
//        get() = TODO("Van cennet gibidir")
//
//    override  val ordinal: Int
//    get() = TODO("Baskale de cennettin diger adidir")
}

enum class DaysOfWeek (val dayNumber: Int) {
    Pazartesi(1){
        override fun toString(): String {
            return "PAZARTESİ"
        }
    },
    Sali(2){
        override fun toString(): String {
            return "SALI"
        }
    },
    Carsamba(3){
        override fun toString(): String {
            return "CARSAMBA"
        }
    },
    Persembe(4){
        override fun toString(): String {
            return "PERSEMBE"
        }
    },
    Cuma(5){
        override fun toString(): String {
            return "CUMA"
        }
    },
    Cumartesi(6){
        override fun toString(): String {
            return "CUMARTESİ"
        }
    },
    Pazar(7){
        override fun toString(): String {
            return "PAZAR"
        }
    }
}

enum class Sex {
        Male {
           override  val typeCount: Int
                 get() = TODO("Not yet implemented")

           override fun isOptional() {
                TODO("Not yet implemented")
            }
            override fun log() {
                super.log()
                println("MALE")

            }
        },
        Famale {
            override val typeCount: Int
                get() = TODO("Not yet implemented")

            override fun isOptional() {
                TODO("Not yet implemented")
            }

        },
        Other {
            override  val typeCount: Int
                get() = TODO("Not yet implemented")

            override  fun isOptional () {
                TODO("Not yet implemented")

            }
        };

    abstract  val typeCount: Int
    abstract fun isOptional ()

    open fun log()  {}
}

fun main() {
    val fb =   "FENERBAHCE"
    val gs =   "GALATASARAY"
    val bjk =  "BESIKTAS"
    val vs =   "VANSPOR"

    val pzt = "Pazartesi"
    val sal = "Sali"
    val car = "Carsamba"
    val per = "Persembe"
    val cum = "Cuma"
    val cmrt = "Cumartesi"
    val pzr = "Pazar"

    val male = "MALE"
    val famale = "FAMALE"

    println(" 4 Büyük takımdan birini yaziniz : ")
    val team: String = readLine()!!


    val starCount = when {
        team == fb -> {
            4
        }
        team == gs -> {
            4
        }
        team == bjk -> {
            3
        }
        team == vs -> {
            3
        }
        else -> {
            -1
        }
    }

// Yukardaki kullanim yerine asagıdaki daha temizdir. Enum class kullanarak yapabilirim.

    val starCount1 = when (team) {
//       Alternatif olarak daha temiz yazalim
//        Teams.FENERBAHCE.name.uppercase(Locale.getDefault()) -> {
//  }

        Teams.FENERBAHCE.toString() -> {
            Teams.FENERBAHCE.starCount
        }
        Teams.GALATASARAY.toString() -> {
            Teams.GALATASARAY.starCount
        }
        Teams.BESIKTAS.toString() -> {
            Teams.BESIKTAS.starCount
        }
        Teams.VANSPOR.toString() -> {
            Teams.VANSPOR.starCount
        }
        else -> {
            -1
        }
 }


    val other = "OTHER"

    println(DaysOfWeek.Carsamba.name)
    println(DaysOfWeek.Carsamba.toString())

    println(Teams.FENERBAHCE.name)
    println(Teams.FENERBAHCE.toString())

    println(DaysOfWeek.Carsamba.ordinal)
    println(DaysOfWeek.Carsamba.dayNumber)

    // FENERBAHCE degeri enum olarak yoksa, error firlatir
    Teams.valueOf("FENERBAHCE")
    //Teams icerisindeki tum enum constant'larini bir liste halinde doner.
    Teams.values()
}