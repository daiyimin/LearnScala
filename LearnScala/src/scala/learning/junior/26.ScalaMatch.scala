package scala.learning.junior

object ScalaMatch {
  def main(args : Array[String]) {
    var data = 30
    data match {
      case 1 => println("First")
      case 2 => println("Second")
      case _ => println("Unknown input")
    }
    
    val result = data match {
      case i if i == 1 => "The First"
      case number if number == 2 => "The second"
      case _ => "Unknown input"
    }
    println(result)
    
    "Spark in action".foreach { c => println(
      c match {
        case ' ' => "space"
        case ch => "Char " + ch
      }
     ) 
    }
  }
}