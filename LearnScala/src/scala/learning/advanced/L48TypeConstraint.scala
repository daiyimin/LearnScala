package scala.learning.advanced

object L48TypeConstraint {
  def main(args : Array[String]) {
    // A =:=B      //表示A类型等同于B类型
    // A <:< B     //表示A类型是B类型的子类
    
/*
	 下面定义的tao方法，在方法的第二个参数使用了一个隐式参数ev，它的类型是：T <:< java.io.Serializable，表示只有参数类型T是java.io.Serializable的子类型，才符合类型要求。
	或许你会奇怪上面test方法调用”hi”时，隐式参数ev是从哪儿传入的？当前并没有定义这个隐式参数。这个隐式参数也是由Predef里的隐式方法产生的

  private[this] final val singleton_<:< = new <:<[Any,Any] { def apply(x: Any): Any = x }
  implicit def conforms[A]: A <:< A = singleton_<:<.asInstanceOf[A <:< A]

	当调用test("hi")，编译器推断出T是String，在寻找 String <:< java.io.Serializable类型的隐式参数时，上下文中找不到，于是通过conforms隐式方法来产生一个，
	conforms方法只有一个类型参数，它产生的结果是<:<[String,String]类型的对象，但因为<:<[-From,+To]第一个类型参数是逆变的，第二个类型参数是协变的，
	所以<:<[String,String]符合<:<[String,java.io.Serializable]的子类，满足要求。
 */
  def tao[T](words:T)(implicit ev: T <:< java.io.Serializable) {
    println(words)
  }
  tao("巧者劳而智者忧，无能者无所求，饱食而遨游，泛若不系之舟，虚而遨游者也")
//  tao(1)
    
  // 用上界也能限定类型吧？和<:<有啥区别
  def confucius[T <: java.io.Serializable](words: T) {
    println(words)
  }
//    confucius(1)
  
  // 回答上面的问题，对于上界和下界，scala会有一个类型推导的过程
  // 而类型限定则不会做推导，是根据confirm产生类型判断类的继承关系
  def foo[A, B <: A](a: A, b: B) = (a,b)
  val t1 = foo(1, List(1,2,3))
  def bar[A,B](a: A, b: B)(implicit ev: B <:< A) = (a,b)
//  var t2 = bar(1,List(1,2,3))
  
  
  def buddhism[T](words: T)(implicit ev: T =:= String) {
    println(words)
  }
  buddhism("拈花中")
//    buddhism(1)
  }
}