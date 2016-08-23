package scala.learning

object ScalaExtractor {
  def main(args : Array[String]) {
     val pattern = "([0-9]+) ([a-z]+)".r
     "20150628 hadoop" match {
       // at the backend, scala calls Regex.unappliedSeq
       case pattern(num, str) => println(num + " " + str)
       case _ => println("else")
     }
  }
}