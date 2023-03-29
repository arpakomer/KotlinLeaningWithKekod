package basic.loop

fun main(){

    /**
     *
     *      3 farkli sekilde for kullanımı mevcut
     *    1)  value in list               seklinde value degerleri alabiliriz
     *    2)  index in list.indices       seklinde index degerleri alabliriz
     *    3) (index, value) in list.withIndex() index,value degerleri alabiliriz
     *
     */


    for (value : Int in 1..10){ // 1..10 ifademiz bir liste olmali
        print("$value ")
    }

    val countryCodeArray = arrayOf("tr", "ar", "fr", "ru", "uk")

    for (value in countryCodeArray){
        print("$value ")

    }
    for (index in countryCodeArray.indices){ // indices bize IntRange bilgisi doner . 0..3 bu ornek icin

        print("\n$index  degeri : ${countryCodeArray[index]} ")

    }                                       // index ,ile value yazdıklarımız onlar bizim için değişken tanımlıyoruz
                                            // İstedigimiz seyi yazabiliriz fakat anlamlı seyler yazmak her daim iyidir

    for ((index,value) in countryCodeArray.withIndex()){
        print("\n$index. degeri $value ")
    }


    /**
     *          repeat(size) seklinde herhangi bir listeye ihtiya duymadan tekrarlayan isler yapmamızı saglar
     */

    repeat(10){
        print("\n Daha cok  calısmam lazım !")
    }

    /**
     *      Return kullanilarak ilgili sar saglanirsa ,donguden cikabiliriz
     *      continue kullanarak ilgili sart saglanirsa, donguye 0 degeri atlayarak devam edebiliriz
     */

    for (value in 1..50){
        if (value % 2 == 1){
            continue
        }
        print("\n$value")
    }

    for (value in 1..50){
        if (value %2 == 1){
            break
        }
        print("\n$value")
    }


    /**
     *
     *      Ic ice for donguleri kullanirsam bir ustteki for'a degil de iki ustteki ve ustteki for'a donmek istiyorsaniz
     *      label kullanilabilirim. Bunun icin labelname@ ifadesini ilgili for'un onune yazip, return ya da continue yapacagimiz
     *      yere ,se @labelname seklinde yazmamiz yeterli olur
     *
     */
    for (value in 1..50){
        for (value2 in 0..20){
            if (value2 == 5){
                continue
            }
            print("continue1 : $value2 | ")
        }
    }

    println("")

    returnLabel@ for (value in 1..50){
        for (value2 in 0..10){
            if (value2 == 5){
                continue@returnLabel
            }
            print("continue2 : $value2 | ")
        }
    }

    println("")


    returnLabel@ for (value in 1..50){
        for (value2 in 0..10){
            if (value2 == 5){
                break@returnLabel
            }
            print("break2 : $value2 | ")
        }
    }
}