package scala.learning.advanced

class Outer {
  private val x = 10
  class Inner {
    private val y = x + 10
  }
}

object L52PathDependancy {
  def main(args : Array[String]) {
    // Inner的类型依赖于外部类的实例，这就是路径依赖
     val outer = new Outer
     val inner = new outer.Inner
     val inner2: outer.Inner = new outer.Inner
     
     val o1 = new Outer
     val o2 = new Outer
//     val i: o2.Inner = new o1.Inner
     // Outer#Inner是所有outer.Inner的父类，这是所谓的类型投影
     val i: Outer#Inner = new o1.Inner
     val i2: Outer#Inner = new o2.Inner
  }
}