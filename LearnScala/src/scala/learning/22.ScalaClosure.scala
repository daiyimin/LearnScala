package scala.learning

object ScalaClosure {
  def main(args : Array[String]) {
  
    val data = List(1,2,3,4,5)
    var sum = 0
    data.foreach(sum += _)
    println(sum)  // closure changes sum value
    
    def add(more: Int) = (x: Int) => x + more
    val a = add(1)
    val b = add(1000)
    
    println(a(10))
    println(b(10))
  }
}