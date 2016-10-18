package scala.learning.advanced

import scala.io._

trait Reader {
  type In
  type Content
  def read(in: In): Content
}

/*
 * 如果类型是在创建实例的时候给出的，那么用类型参数（泛型）比较合适
 * 如果类型是在子类中给出的，那么用抽象类型比较合适
 */
class FileReader extends Reader{
  type In = String
  type Content = BufferedSource
  def read(name: In) = Source.fromFile(name)

}

object L58AbstractType {

  def main(args: Array[String]) {
    val fileReader = new FileReader
    val content = fileReader.read("resource\\scala\\learning\\FileOps.txt")
    for (line <- content.getLines) {
      println(line)
    }
  }
}