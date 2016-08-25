package scala.test

object ScalaUpperBounds {

//  class Queue[-T](val list: List[T]) {  // In contravariant case, T cannot be used as member variable type
  class Bean[-T](x: T) {    // if not use var and val, x is not a member variable. So it's allowed in contravariant
    println(x)
    
    def replace[U <: T](x:U) = {
      new Bean(x)
    }

//    def head: T = list.head // same problem as list in constructor
  }
  
  class Grandpa
  trait GrandmaTrait
  class Grandma extends GrandmaTrait
  class Father extends Grandpa with GrandmaTrait
  trait MotherTrait
  class Mother extends MotherTrait
  class Son extends Father with MotherTrait
  class Daughter extends Father with MotherTrait
  
  def main(args : Array[String]) {
    /**
     * 注意b1,b2,b3...的类型变化
     * 
     * 上界的意义
     * 字面上上界定义了replace的类型参数U是T或者T的子类
     * 
     * 下面我们创建了一个Bean[Grandpa]类型的Bean
     * 1）如果向Bean[Grandpa]的replace传入其它Grandpa的派生类对象（如Father）
     * replace的U类型应该是Grandpa或者Grandpa的子类，而Father的确是从Grandpa派生的，所以Scala类型推导得出U类型就是Father
     * 因此得到的新Bean仍然是Bean[Father]，参见b1,b2
     * 2）如果向Bean[Father]的replace传入一个Son对象
     * replace的U类型应该是Father或者Father的子类，而Son的确是从Father派生的，所以Scala类型推导得出U类型就是Son
     * 因此得到的新Bean是Bean[Son]，参见b2
     * 3）如果向Bean[Grandpa]的replace传入一个Mother对象
     * replace的U类型应该是Grandpa或者Grandpa的子类，而Mother不是从Grandpa派生的，所以Scala报错。参见b4
     * 
     * 结论，上界的意义
     * 例如replace(U >: Grandpa)里，传给replace的参数必须是Grandpa或者Grandpa子类的实例
     * U的具体类型是根据传入参数的类型决定的。这个类型最宽可以是Grandpa，最窄则没有限制，取决于Grandpa的子类数目
     * 所以这个例子里,Grandpa就是U的类型上界，U的类型没有下界
     * 
     * 引申,思考一下为什么上界和逆变可以一起用
     */    
    var bean = new Bean(new Grandpa)
    var b1 = bean.replace(new Father)
    var b2 = bean.replace(new Daughter)
    var b3 = b1.replace(new Son)
//    var b4 = bean.replace(new Mother)
  }
}