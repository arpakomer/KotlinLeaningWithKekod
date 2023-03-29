package classes


/**
 *  Nested ya da local typeAlias kullanimi desteklenmiyor
 *
 *  typeAlias'lar arka planda yeni bir class olusturmazlar. Sadece etiketleme yaparlar
 *
 *
 */



typealias  AccountReferenceVM = ProjectContractChargingPeriadProjectAccountReferenceVM

fun main() {

//    typealias AccountReferenceVM = ProjectContractChargingPeriadProjectAccountReferenceVM

    val projectcontractChargingPeriadProjectAccountReferenceVM = ProjectContractChargingPeriadProjectAccountReferenceVM()

    val AccountReferenceVM = AccountReferenceVM() // Boyle bir class'imiz yok  sadece map'leme yaptik.
}


class  ProjectContractChargingPeriadProjectAccountReferenceVM {

}