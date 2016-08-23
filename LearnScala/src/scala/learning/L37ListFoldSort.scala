package scala.learning

object L37ListFoldSort {
  def main(args : Array[String]) {
     
/*     val list = List(1,2,3,4,5)
     var reverse: List[Int] = Nil
//     list foreach ( (x:Int) => reverse = x :: reverse)
     list foreach (reverse ::= _)
     println(reverse)*/
     
     println((1 to 100).foldLeft(0)(_+_))
     println((5051/:(1 to 100))(_-_))
     
     
     println((1 to 5).foldRight(100)(_-_))
     println(((1 to 5):\100)((i,result) => result -i))
     
     println(List(1,-3,4,2,6) sortWith( _<_))
     println(List(1,-3,4,2,6) sortWith( _>_))
  }
}