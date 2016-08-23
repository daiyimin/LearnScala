package scala.learning

object ScalaMatchWithSet {
  def main(args : Array[String]) {
    // 根据类型匹配
    def match_type(t : Any) = t match {
      case p : Int => println("Integer found")
      case p : String => println("String found")
      // scala在模式匹配时，会擦除类型
      case m : Map[_,_] => m.foreach(println) 
      case _ => println("Unknown type")
    }
    
    match_type(2)
    match_type(Map("Scala" -> "Spark"))
    
    def match_array(arr : Any) = arr match {
      case Array(0) => println("Array with a '0' element")
      case Array(x,y) => println("Array with two elements: " + x + "," + y)
      case Array(0, _*) => println("Array with a head '0' element")
      case _ => println("else")
    }
    match_array(Array(0))
    match_array(Array(0,1))
    match_array(Array(0,1,2,3,4))
    match_array(Array(1,0,2,3,4))
    
    def match_list(lst : Any) = lst match {
      case 0 :: Nil => println("List with a '0' element")
      case x :: y :: Nil => println("List with two elements: " + x + "," + y)
      case 0 :: tail => println("List with a head '0' element")
      case _ => println("else") 
    }
    match_list(List(0))
    match_list(List(0,1))
    match_list(List(0,1,2,3,4))
    
    def match_tuple(tuple : Any) = tuple match {
      case (0,_) => println("Tuple with a '0' element")
      case (x,0) => println("Tuple with two elements, include a tail '0'")
      case _ => println("else")
    }
    match_tuple((0,"scala"))
    match_tuple((2,0))
    match_tuple((0,1,2,3,4))
  }
}