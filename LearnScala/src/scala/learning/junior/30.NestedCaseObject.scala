package scala.learning.junior

abstract class Item
case class Book(description: String, price: Double) extends Item
case class Bundle(description: String, price: Double, items: Item*) extends Item

object NestedCaseClass {
  def main(args : Array[String]) {
    
    def caseclass_nested(item: Item) = item match {
      // 可以用@符用一个变量引用class object中的指
      case Bundle(_, _, art @ Book(_,_), _*) => println("The first book is: " + art.description + " cost " + art.price + "yuan")
//      case Bundle(_, _, Book(descr, _), _*) => println("The first book is: " + descr)
      case _ => println("Else")
    }
    
    caseclass_nested(Bundle("Bundle", 1000, Book("West Legand", 50), 
                               Book("Pride and Prejudice", 10),
                               Book("Old man and sea", 1)))
    
     caseclass_nested(Bundle("Bundle", 1000, 
                               Book("Pride and Prejudice", 10)
                               ))
                              
  }
}