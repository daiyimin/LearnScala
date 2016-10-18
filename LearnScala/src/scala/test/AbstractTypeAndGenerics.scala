package scala.test

object AbstractTypeAndGenerics {
  class A1 { type T }
  
  class A2[T] { def foo(p:T) {println(p); } }
  
  class B { type T; def foo(p:T) {println(p)} }
  
  def main(args : Array[String]) {
    val a1 = new A1
    
    
    // 实例化时，不指定泛型类型，scala使用Nothing，而因为Nothing是所有类型的子类，所以基本没啥用
    val a2 = new A2
//    a2.foo("scala")
    (new A2).foo("hello scala")
    
    // 实例化时, 不指定抽象类, scala会推导出T是一个Any类型。Any是所有类的父类
    // 可以用asInstanceOf把具体类型转换成b.T
    val b = new B
//    b.foo("scala")
    b.foo("scala".asInstanceOf[b.T])
//    (new B).foo("scala")
    b.foo(1.asInstanceOf[b.T])
    b.foo(List(1,2).asInstanceOf[b.T])
  }
}