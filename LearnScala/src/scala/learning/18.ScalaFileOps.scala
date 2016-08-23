package scala.learning

import scala.io._
import java.io.PrintWriter
import java.io.File

object ScalaFileOps {
  def main(args : Array[String]) {
//     val file = Source.fromFile("resource/scala/learning/FileOps.txt");
//     for (line <- file.getLines()) println(line)
//     file.close()
     
//     val webFile = Source.fromURL("http://spark.apache.org")
     /** 以下语句都是等效的  */
//     webFile.foreach { x => print(x) }   // 匿名函数作为变量，匿名函数内调用print函数
//     webFile.foreach(print(_))         //匿名函数缩写方式作为变量，省略匿名函数的入参，在匿名函数体内用_代替入参 
//     webFile.foreach(print)            // 直接将print函数作为变量
//     webFile.foreach(print _)          //偏函数作为变量
//     webFile.close()
     
//     val writer = new PrintWriter(new File("resource/scala/learning/WriteFile.txt"))
//     for (i <- 1 to 10) writer.print(i)
//     writer.close()
     
     print("Please enter your input: ")
     val line = Console.readLine()
     print("You typed: " + line)
     
  }
}