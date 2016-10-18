package scala.test

import scala.reflect.runtime.universe.typeOf

object TypeKeyword {
  type T = Serializable {
    type X
    def foo(): Unit
  }
  object A extends Serializable { type X = Int; def foo() {println("I am A")} }
  
  def main(args: Array[String]) {
    println(typeOf[A.type] <:< typeOf[T])
    val a: T = A
    a.foo

//    trait A[T] { def foo(i: T) = println(i) }
    trait A { type T; def foo(i: T) = println(i) }
    class B extends A { type T = Int }
    val b = new B
    b.foo(1)
    
    class C extends A { type T = String }
    val c = new C
    c.foo("hi")
  }
}