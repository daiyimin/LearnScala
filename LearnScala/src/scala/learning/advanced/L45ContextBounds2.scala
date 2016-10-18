package scala.learning.advanced
import java.util.Comparator

object L45ContextBounds2 {
  def main(args : Array[String]) {
    // 定义一个隐式值
    implicit val c = new Comparator[Int] {
      override def compare(a: Int, b: Int) = a - b
    }

    // 后面三个函数分别用不同的方式调用隐式值
    def max[T](a: T, b: T)(implicit cp: Comparator[T]) = {
      if (cp.compare(a, b) > 0) a else b
    }

    // Context Bounds方式
    def max2[T: Comparator](a: T, b: T) = {
      def inner(implicit c: Comparator[T]) = c.compare(a, b);
      if (inner > 0) a else b
    }

    def max3[T: Comparator](a: T, b: T) = {
      val cp = implicitly[Comparator[T]]
      if (cp.compare(a, b) > 0) a else b
    }
    
    println (max(1, 2))
    println (max2(1, 2))
    println (max3(1, 2))
//    println (max2(1.2, 2))  // Double doesn't work unless we provide another implicit value
  }
}