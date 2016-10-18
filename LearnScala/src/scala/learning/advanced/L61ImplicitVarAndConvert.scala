package scala.learning.advanced

object L61ImplicitVarAndConvert {
  def main(args : Array[String]) {
  
/**
 *  @param ordered implicit variable ordered provide a implicit conversion method
 *  
 */
    def bigger[T](a: T, b: T)(implicit ordered: T => Ordered[T]) = {
      /*
       * when a > b is compiled, compiler cannot find > method
       * compiler find a convert mehtod from T to Ordered[T], and Ordered[T] has > method 
       */
      
      /*
       * 在运行时，类型参数被判定为Int，scala会找到下面的转换函数
       * The implicit convert from Int to RichInt is in Predef.scala. RichInt is an Ordered[Int] object
  @inline implicit def intWrapper(x: Int)         = new runtime.RichInt(x)
  
  		 * 不过如果直接调用 println(2>3)，scala不会去找隐式转换函数
       */
      if( a > b ) a else b
    }
    
    /*
     *  如果没有隐式值ord会怎么样
     *  编译器在编译a>b时，首先找到Ordered伴生对象里的implicit def orderingToOrdered[T](x: T)(implicit ord: Ordering[T]): Ordered[T]的转换函数，
     *  然后又发现这个函数需要一个Ordering[T]类型的隐式值，编译器无法递归寻找隐式值吧？
     */
    def bigger2[T](a: T, b: T)(implicit ord: Ordering[T]) = {
      import Ordered._
      if (a > b) a else b
    }
    
    def bigger3[T: Ordering](a: T, b: T) = {
      import Ordered._
      if (a > b) a else b
    }

//    println(bigger(2,3))
    println(bigger2("spark", "scala"))
//    println(bigger3(12.1, 5.2))
    
    println(2>3)
  
  }
}