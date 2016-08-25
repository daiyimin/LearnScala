package scala.test

object ScalaLowerBounds {
  class Queue[+T](val list: List[T]) {
//    def test(x: T) = print("hi")
    
    def append[U >: T](x: U) = {
      new Queue[U](x :: list)
    }
/*    
    def map[U >: T](f:T => U) = {
      var l = list.map(f)
      new Queue(l)
    }
*/
    def head = list.head
  }

  class Grandpa
  trait GrandmaTrait
  class Grandma extends GrandmaTrait
  class Father extends Grandpa with GrandmaTrait
  trait MotherTrait
  class Mother extends MotherTrait
  class Son extends Father with MotherTrait
  class Daughter extends Father with MotherTrait

  def main(args: Array[String]) {
    /**
     * 注意q1,q2,q3...的类型变化
     * 
     * 下界的意义
     * 字面上下界定义了append的类型参数U是T或者T的父类
     * 
     * 下面我们创建了一个Queue[Grandpa]类型的Queue
     * 实际上我们在构造函数里传入了有两个成员的List，但是Scala自动推导出父类Grandpa，并以它作为T的类型
     * 1）如果向Queue[Grandpa]里append其它Grandpa的派生类对象（如Son,Daughter）
     * append的U类型应该是Grandpa或者Grandpa的父类，而Son,Daughter的祖先都是Grandpa，所以Scala类型推导得出的最早共同祖先是Grandpa
     * 因此得到的新Queue仍然是Queue[Grandpa]，参见q1,q2
     * 2）如果向Queue[Grandpa]里append一个Mother对象
     * append的U类型应该是Grandpa或者Grandpa的父类，而Mother不是从Grandpa派生的，所以Scala类型推导得出的最早共同祖先是Object
     * 因此得到的新Queue是Queue[Object]，参见q3
     * 3）如果向Queue[Object]里append一个Int对象
      * append的U类型应该是Object或者Object的父类，而Int不是从Object派生的，所以Scala类型推导得出的最早共同祖先是Any
     * 因此得到的新Queue是Queue[Any]，参见q4
     * 
     * 结论，下界的意义
     * 例如append(U >: Grandpa)里，并不是说传给append的参数必须是Grandpa或者Grandpa子类的实例
     * 而是，U的具体类型是根据传入参数和Grandpa的类型关系推导出的一个最早的公共祖先。这个祖先最窄的范围就是Grandpa，最宽的范围可以是Any
     * 所以这个例子里,Grandpa就是U的类型下界，U的类型上界是Any
     * 
     * 引申,思考一下为什么下界和协变可以一起用
     */
    
    val queue = new Queue(List(new Grandpa, new Father))
    var q1 = queue.append(new Son)
    q1.list.foreach { println }
    var q2 = q1.append(new Daughter)
    q2.list.foreach { println }
    
    var q3 = q2.append(new Mother)
    q3.list.foreach(println)
    var q4 = q3.append(1)
    q4.list.foreach(println)
  }
}