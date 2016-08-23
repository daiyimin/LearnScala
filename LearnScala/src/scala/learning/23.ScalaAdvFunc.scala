package scala.learning

import scala.math._

object ScalaAdvFunc {
  //把函数当作参数就叫做高阶函数

  def main(args : Array[String]) {
    // 函数作为变量
    val f = ceil _
    
   // 函数作为参数
    (1 to 9).map("*" * _).foreach { println }
    println((1 to 4).reduceLeft(_*_))
    "Spark is wonderful language".split(" ")
      .sortWith(_.length < _.length).foreach { println }
    
    def high_order_func(f: Double => Double) = f(0.25)
    println(high_order_func(ceil _))
    println(high_order_func(sqrt _))
    
    //匿名函数作为参数
    Array(3.14, 1.42, 2.0).map( _ * 2).foreach { println }
    
    //闭包
    def mulBy(factor: Double) = (x: Double) => x* factor
    println(mulBy(5)(20))
    
    //匿名函数的几种写法
    // 第一种， f3没有定义类型，表达式的参数有类型，可以推导出f3的类型
    val f3 = (x: Double, y: Double) => 3 * x * y
    // 第二种，f4的类型是(Double, Double) => Double的函数，所以表达式里的参数占位符没有类型
    val f4: (Double,Double) => Double = 3 * _ * _
    // 第三种，f5没有类型，但是表达式的参数占位符有类型，可以推导出f5的类型
    val f5 = 3 * (_: Double) * (_: Double)
    val f6 = (x: Double, y: Double) => {
      var result = 3 * x * y
      result
    }
 }
}