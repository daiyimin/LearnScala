package scala.learning.advanced

class M_A[T]
class M_B[T]

object L47MultipleBounds {
  def main(args : Array[String]) {
       implicit val a = new M_A[Int]
       implicit val b = new M_B[Int]
       def foo[T: M_A : M_B](i: T) = println(i)
       
       foo(2)
  }
}