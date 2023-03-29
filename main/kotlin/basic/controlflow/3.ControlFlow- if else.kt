package basic.controlflow

import java.io.IOException

fun main(){
    /**
     *
     *     if - else case'lerin State ve Expression olmak üzere 2 kullanımı vardır.
     *     State ---> Sadece if - else sartli durumlar için
     *     Expression --> bir value'ye deger olarak esitligin karsi tarafina if else kodlanir
     *     Expression --> olarak yapılan kodlama da if else case'leri icin yazilmis parantezler son satirda bulunur
     *
     */

    val answer : String = "Evet"

    // State kullanimi
    if (answer.contains("Evet",ignoreCase = true)){
        println("Ogrenci")
    } else{
        println("Ogrenci Degil")
    }

    // Expression kullanimi . {} içerisindeki son satir, deger olarak degiskene atanir
     val result : String = if (answer == "Evet"){
         "Ogrenci"
     } else {
         "Ogrenci Degil"
     }

    println(result)

    print("Notunuzu Giriniz : ")
    val grade = readLine()!!.toDouble()

    if(grade <= 100 && grade >=85){
        println("AA")
    }else if (grade < 85 && grade >= 70){
        println("BB")
    }else if (grade < 70 && grade >= 55){
        println("CC")
    }else if (grade < 55 && grade >= 40){
        println("DD")
    }else{
        print("Sen okulu birakmalisin bence :)")
    }

    /**
     *      Iki farkli tipteki değişkenler karsilastirilirken equals fonksiyonu
     *      once tiplerini karsilastirdigi icin  egertipler uyusmuyorsa , ide hata verecektir.
     *
    */

    /*if (10 == 10L){
        // BU KODUMUZ CALISMAZZZ
    } */

    if (10 == 10L.toInt()){
        println("true")
    }
    /**
     *
     *    Bazi durumlarda if else yazmaktansa , if case'in yazio return ya da throw gibi kodun devam etmesini bozacak
     *    ifadelerin koddu sonlandirabiliriz. Kod çalişirken bu if case'ine girmezse devam eden kod blogu calısir ki
     *    bu da pratikte else case'i demek olur. Bu sekilde yazip kodu biraz daha temiz gosterecektir.
     *
     */

    val isStudent : Boolean = false
    if(isStudent) {
        println("Student")
    }else{
        otherMethod()
    }

    if (isStudent) {
        println("Student")
        throw IOException()
//        return
    }
    otherMethod()




}
private fun otherMethod(){

}




