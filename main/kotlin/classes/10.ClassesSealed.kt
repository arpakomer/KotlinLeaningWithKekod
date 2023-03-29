package classes

/**
 *  Sınırlı kumede, gruplanabilir class'lar yazmayi saglar
 *  Kisitlanmis bir class hiyerarsisi kurabilmemizi saglar
 *  Bu class'lar arka planda static olarak tutulmazlar. Enumeration'lardan en buyuk FARK
 *  Enumlar'lar verileri gruplarken, sealed class'lar class'lari gruplar.
 *
 *
 *  Sealed class'lar abstract class'lardir ayni zamanda. Abstract olduklari icin open olamazlar
 *  Sealed class'lar Abstract class olduklarindan final olamazlar. Anlamsal olarak zaten sacmadir.
 *
 *  Sealed class'larin nesnesi olusturulamaz. Constuctor'lari protected ve private olarak bulunur
 *
 *  sEALED class'in miras alan subClass'lar final olduklari icin miras alamazlar. SDK'ler icin onemlidir
 *
 *
 *  Sealed class'in subClass'larinin neler olduklari compiletime'da bilinmektedir. Bundan dolayi when ve if yapilarinda
 *  else case'lerinin yazimina ihtiyac duymazlar
 *
 *  sealed class'lari extends alan subclass'lar eskiden ayni dosya uzerinde bulunma zorunlulugu vardi
 Bu zorunluluk esnetilerek ayni, package icerisinde olmaya kadar genisletildi.
 Ancak ayni package disina cikip , bir subClass'a sealed class'i miras olarak vermek isterseniz buna izin vermeyecektir
 ozelikle sdk yazarken bu kisitlama onemlididir
 *
 * Sealed class'lar icerisine object tanimlamalari da yapilabilir
 * sealed class'lar icerisine sadece object tanimi yapiyorsak, bu kullanimin enumaration'dan teknik olarak
 * hicbir farki kalmiyor.
 */

sealed class Response
class Success : Response() {

}
class Error : Response() {

}
// Bu iki kullanimda var ama asagıdaki daha mantikli

sealed class Response2() {
    class Success2 : Response2() {

    }
    class Error2 : Response2(){
    }
}



fun handle(response: Response) {
    when(response) {
        is Success -> {
            // response'dan gelen bilgilerle vi'ini doldur
        }
        is Error -> {
            // pop-up ile kullaniciya bilgi ver
        }

//        else ->{
//                      Sealed da ekstradan else case kullanmamiza gerek yoktur.
//        }
    }
}

// Bu yanlistir. Enum kullanmamiz yerinde olur
sealed class PaymentOption {
    object Cash             // Object demek bunlari static yaptim demek buda arka planda olusur.Sealed kullanimina ters
    object Card
    object Transfer
}

enum class PaymentOption2 {
    Cash, Card, Transfer
}

fun main(){
//    val response = Response()

    val success = Success()
    val error = Error()

    handle(success)
    handle(error)

}