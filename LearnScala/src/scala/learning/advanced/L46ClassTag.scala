package scala.learning.advanced

import scala.reflect.ClassTag

object L46ClassTag {
  def makeArray[T: ClassTag](x: T, y: T) = {
    var arr = Array[T](x, y)
    arr
  }
  
  def main(args: Array[String]) {
    var a1 = makeArray(1,2)
    a1.foreach { println }
    var a2 = makeArray("spark", "scala")
    a2.foreach { println }
  }
}