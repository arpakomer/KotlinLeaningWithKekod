package classes

// Open bir func. varken class'in final olmasi bir kullanim olacaktir. open func. bir espiri kalmaz

open class  Shape(val name: String) {
    var nColor: String = ""
    var nEdgeCount: Int = 0

    constructor(name: String, color: String): this(name) {
        nColor = color
    }
    constructor(name: String, color: String, edgeCount: Int ): this(name){
        nColor = color
        nEdgeCount = edgeCount
    }

    open fun drawShape() {
        println("Name: $name")
        println("Color: $nColor")
        println("EdgeCount: $nEdgeCount")
    }

    fun calculateArea(): Int = if (nEdgeCount != 0) {
        nEdgeCount * nEdgeCount
    } else {
        0
    }
}
class  Rectangle(name: String) : Shape(name){
// Miras alinmis classın  en azindan bir const. degerleri verilecek sekilde ( bu hangisi oldugu fark etmez ) veririz

//fun main(){
//    nColor
//    nEdgeCount
//    drawShape()
//    calculateArea()
//}


    override fun drawShape() {
//         drawShape()
//        this.drawshape()
        super.drawShape()

        calculateArea()

        val rectangle = """"
        

        """".trimIndent()

        println(rectangle)
    }
}
class  Circle(name: String, color: String) : Shape(name, color){
    override fun drawShape() {
        super.drawShape()

        val circle = """"
            
         
        """.trimIndent()
        println(circle)
    }
}
open  class Square(name: String, color: String, edgeCount: Int) : Shape(name, color, edgeCount){
    final override fun drawShape() {
        super.drawShape()

        val square = """"
            
            
        
        """.trimIndent()
        println(square)
    }
}

class  OneMeterSquare : Square("OneMeterSquare","blue",4){
//    override fun  drawShape() {
//        super.drawShape()
//        super.super.drawShape()
//    }

    // Ust class'taki drawShape final olursa, alt class'da bu func. override edilemez. 0'dan yazilmasi gerekir
      fun  drawshape(){

    }
}


fun main() {
    val shape = Shape("Shape")
    val rectangle = Rectangle("Rectangle")
    val circle = Circle("Circle","Maganta")
    val square = Square("Square","Cyan",4)

    shape.drawShape()

    rectangle.drawShape()
    circle.drawShape()
    square.drawShape()
}
