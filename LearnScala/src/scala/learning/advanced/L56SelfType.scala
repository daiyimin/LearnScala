package scala.learning.advanced

object L56SelfType {

  // 用self type给Self类的this指针起别名  
  class Self {
    self =>
    val tmp = "scala"
    def foo = self.tmp + this.tmp
  }

  trait S1
  class S2 { this: S1 => }
  class S3 extends S2 with S1

  trait T { this: S1 => }
  object S4 extends T with S1

  def main(args: Array[String]) {
    // self type定义self的alias，可以区分内部类和外部类的self
    class Outer {
      outer =>
      val v1 = "Spark"
      class Inner {
        println(outer.v1)
      }
      val o = new S2 with S1
    }

    // self type强制B trait的实现类也要实现User trait
    trait User { def name: String }
    trait B {
      user: User => // 这里self-type没用this而是user，可以是任何名字
      def foo() {
        println(name)
      } // 同样后边的name也不需要手动增加前缀 user.name，会被识别为user.name。 
    }
    object Boss extends B with User { override def name = "Bruce"; }
    Boss.foo
    
    // self type和structure type一起，约束C trait的实现类也要实现talk方法
    trait C {
      user: { def talk } =>
      def foo {
        user.talk
      }
    }
    object Colleague extends C { 
      def talk = println("Work with me")
    }
    Colleague.foo
    
  }
}