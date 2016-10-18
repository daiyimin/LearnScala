package scala.learning.advanced

class Pair_Implicitly_Ordered[T:Ordering](val first: T, val second: T) {
  
  /*
   * class Pair_Implicitly_Ordered 有个Ordering[T]类型的隐式参数
   * Scala编译器在编译时，能够从Ordering的伴生对象里找到Ordering[T]类型的对象，
   * 并且注入到Pair_Implicitly_Ordered的实例里 
   */
  def bigger = {
    import Ordered._    
    /*
     * first和second都是T类型的变量，T类型没有定义>操作符
     * 编译于是在隐式定义的范围内查找，包括Predef，包对象和T的伴生对象（T是泛型类型，没有伴生对象）,最后是在导入的包里
     * 结果是编译器找到导入的Ordered的伴生对象定义了orderingToOrdered方法，
     * orderingToOrdered接受一个T类型参数，和一个Ordering[T]类型的隐式参数,返回Order[T]类型的变量
     * 而Order[T]定义了>操作符
     * 于是编译器通过隐式转换把first变成一个Ordered[T]类型对象，调用>操作符
     * 
     * 调用过程如下
     * orderingToOrdered(first)(implicit Ordering[T]).>(second)
     */    
    if (first > second) first else second
  }
}

object L62ContextBoundWithImplictParam {
  def main(args : Array[String]) {
     
  }
}