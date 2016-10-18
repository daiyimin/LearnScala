package scala.learning.advanced

object L55InfixType {
  def main(args: Array[String]) {
    // Scala类型
    // http://www.cnblogs.com/aezero/p/4563125.html
    
    // Scala操作符，以：结尾的操作符是右结合的
    object Log { def >>:(data: String): Log.type = { println(data); Log } }
    "Hadoop" >>: "Spark" >>: Log

    val list = List()
    val newList = "A" :: "B" :: list
    println(newList)
    
    class Infix_Type[A, B]
    // infix & infix1 has same type, but the writing of infix is more natural
    val infix: Int Infix_Type String = null
    val infix1: Infix_Type[Int, String] = null
    
    case class Cons(first: String, second: String)
    val case_class = Cons("one", "two")
    case_class match { case x Cons y => println(x + " and " + y) }
  }
}