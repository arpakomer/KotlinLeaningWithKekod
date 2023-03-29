package basic.loop

        //  When Kullanımı

/*
import java.util.*

fun main(){
    */
/**
     *         Switch case'lerin yerine gelmiştir
     *         when(karsilastiracak_ifade)
     *              value -> {}
     *              value -> {}
     *              else ->  {}
     *          formatiyla kullanilir
     *
     *        Yine {} arasina tek satir kod yazilacaksa bu durumda {}'leri kullanmayabiliriz.
     *        'tr', 'az' gibi ayni kodu çalistircak case'leri varsa arya virgul koyarak kullanabiliriz.
     *        Bu "veya" kullanimi yapmayi saglar."tr veya az" gibi.
     *//*


    val countryCode = readLine()!!

    when (countryCode.lowercase(Locale.getDefault())){
        "tr", "az" -> println("Turk Citizen")
        "ar" -> println("Arap Citizen")
        "fr" -> println("French Citizen")
        "ru" -> println("Russian Citizen")
        "uk" -> println("United Kingtom Citizen")

    }

    */
/**
     *       When'in yanina karsilastirilan ifadesi eklemeden, bunu case'lerin yanina da ekleyebilirsiniz
     *       Bunun artisi && || and or xor gibi ifadeleri de kullabilmemizi saglar
     *//*


    when{
        countryCode.toLowerCase() == "tr" || countryCode.toLowerCase() == "az" -> println("TC Citizen")
        countryCode.toLowerCase() == "ar" -> println(" Arap Citizen")
        countryCode.toLowerCase() == "fr" -> println(" French Citizen")
        countryCode.toLowerCase() == "ru" -> println(" Russian Citizen")
        countryCode.toLowerCase() == "uk" -> println(" United Kingdom Citizen")
    }


    if(countryCode.toLowerCase() == "tr" || countryCode.toLowerCase()  == "az")
        println("Turki Vatandası")
    else if (countryCode.toLowerCase() == "ar")
        println("Arap Citizen")
    else if (countryCode.toLowerCase() == "fr")
        println("French Citizen")
    else if (countryCode.toLowerCase() == "ru")
      println("Russian Vatandasi")
    else if (countryCode.toLowerCase() == "uk")
        println("United Kingdom Citizen")


    */
/**
     *         Karsilastirilacak sey "Deger"  yerine "degisken" de olabilir
     *
     *//*

    val trCode = "tr"
    val arCode = "ar"
    val frCode = "fr"
    val ruCode = "ru"
    val ukCode = "uk"

    when (countryCode.lowercase(Locale.getDefault())){
        trCode , "az" -> {println("Turki Citizen")}
        arCode -> {println("Arap Citizen")}
        frCode -> {println("French Citizen")}
        ruCode -> {println("Russian Citizen")}
        ukCode -> {println("United Kigndom Citizen")}
    }

 // Range 'leri in !in seklinde kontrolu yapilabilir


 val number = 3
 when (number){
     in  0 .. 10->{
         println("Long value")
     }
    in  11..20 ->{
        println("Long value")
    }
     !in 11 ..20 ->{
         println("Long value degil")
     }

 }


}
*/


fun main(){

    /**
     *      Degisen hic bir sey yok .Diger dillerde nasil kukullanıyorsan kotlin'de ayni sekilde
     *      Eger bir donguye ihtiyac varsa  ve bu dongu sirasinda if else ile bir sartli dur
     *      bu durumda for + if else kullanmak yerine "While" kullanabiliriz
     */

    var number = 0

    while (number < 5){
        print("${number++} , ")
    }

    while ( number < 5){
        print("${number} , ")
        number++
    }

}
