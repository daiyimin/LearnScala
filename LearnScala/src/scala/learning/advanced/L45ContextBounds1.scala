package scala.learning.advanced

object L45ContextBounds1 {
  class OrderedPair[T: Ordering](x: T, y: T)  {
    def bigger(implicit order: Ordering[T]) = {
      if(order.compare(x, y) > 0) x else y
    }
  }
  def main(args : Array[String]) {
    var pair1 = new OrderedPair(1,2)
    println(pair1.bigger)
    
    var pair2 = new OrderedPair("scala", "java")
    println(pair2.bigger)
  }
}