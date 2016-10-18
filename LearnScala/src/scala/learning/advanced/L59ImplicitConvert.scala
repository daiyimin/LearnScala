package scala.learning.advanced

import java.io.File
import scala.io.Source

class RichFile(path: String) extends File(path: String) {
    def read = Source.fromFile(path).mkString
}

object ImplicitConvert {
  implicit def file2RichFile(file: File) = new RichFile(file.getPath)
}

object L59ImplicitConvert {
  def main(args : Array[String]) {
    import ImplicitConvert.file2RichFile
    
    // use case 1, call a method that don't belong to file
    val file = new File("resource/scala/learning/FileOps.txt")
    println(file.read)
    
    // use case 2, invoke function that requires RichFile, but input a File object 
    def readRichFile(f: RichFile) {
      println(f.read)
    }
    readRichFile(file)
  }
}