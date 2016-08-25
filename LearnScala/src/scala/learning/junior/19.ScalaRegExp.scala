package scala.learning.junior

object ScalaRegExp {
  def main(args : Array[String]) {
     val regex = """([0-9]+) ([a-z]+)""".r
     val numPattern = "[0-9]+".r
     val numberPattern = """\s+[0-9]+\s+""".r
     
     for (matchString <- numPattern.findAllIn("888 spark, 123 hello123")) println(matchString)
     
     println(numberPattern.findFirstIn("99ss java, 222 hadoop"))
     
     val regex(num, item) = "99 hadoop"
     println(num + " " + item)
     
     
     println ("=== breaker ===")
     val line1 = "93456 spark"
     val line2 = "93456 spark 93456 notwork"
     for (line <- Array(line1, line2) ){
       line match {
         case regex(num, blog) => println(num + "\t" + blog)
         case _ => println("opps...")
       }
     }
  }
}