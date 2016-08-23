package scala.learning

import scala.io._

object ScalaFunc {
  
  def processData(filename: String, width: Int) {
    // 内函数， 强内聚， 松耦合
    def processLine(line: String) {
      if (line.length() > width) {
        println(filename + ": " + line)
      }
    }
    
    val source = Source.fromFile(filename)
    for (line <- source.getLines() ) {
      processLine(line)
    }
  }
  
  def main(args : Array[String]) {
    // 函数作为变量
     val someNum = List(-11, -10, -5, 0, 5, 10)
     someNum.foreach { x:Int => println(x) }
     someNum.filter((x:Int) => x > 0).foreach { println }
     someNum.filter (x => x>0)
     someNum.filter(_>0)
     
    // 函数作为变量
     var f = (x: Int, y: Int) => x + y
     println( f(5,6))
     f = (_:Int) + (_:Int)  //匿名函数缩写
     println( f(5,10) )
     
     // 内函数
     processData("resource/scala/learning/FileOps.txt", 5)
  }
}