package scala.learning

object L36ListAPI3 {
  def main(args : Array[String]) {
    var list = List(1,2,3,4,5)
    println(list partition (_ % 2 == 0))
    println(list find (_ % 2 == 0))
    println(list find (_ <= 0))
    println(list takeWhile (_ < 4))
    println(list dropWhile (_ < 4))
    // c span p is equivalent to (but possibly more efficient than) (c takeWhile p, c dropWhile p)
    // 感觉partition更强大，不知道效率哪个高
    println(list span (_ < 4))
    
    def hasTotalZeroRow(m: List[List[Int]]) =
      m exists (row => row forall (_ == 0) )
    val m = List(List(1,2), List(0), List(3,4,5))
    println(hasTotalZeroRow(m))
  }
}