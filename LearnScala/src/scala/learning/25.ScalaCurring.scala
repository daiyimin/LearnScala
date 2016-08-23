package scala.learning

/**
 * 前面我们说过，Scala允许程序员自己新创建一些控制结构，并且可以使得这些控制结构在语法看起来和Scala内置的控制结构一样，在Scala中需要借助于 柯里化(Currying).
 * 柯里化是把接受多个参数的函数变换成接受一个单一参数（最初函数的第一个参数）的函数，并且返回接受余下的参数而且返回结果的新函数的技术。 
 */
object ScalaCurring {
  def main(args : Array[String]) {
    // 函数
    def multiple(x: Int, y : Int) = x*y
    // 闭包
    def multipleOne(x: Int) = (y: Int) => x * y
    // curring函数
    def curring(x: Int)(y: Int) = x * y
    
    // corresponds是一个curring函数
    var a = Array("hello", "spark")
    var b = Array("HellO", "SPARK")
    println(a.corresponds(b)(_.equalsIgnoreCase(_)))
    
    //等价的调用
    var c = a.corresponds(b)_
    println(c(_.equalsIgnoreCase(_)))

  }
}