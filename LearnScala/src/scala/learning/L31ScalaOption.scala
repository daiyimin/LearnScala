package scala.learning

object L31ScalaOption {
  def main(args : Array[String]) {
     var scores = Map("Alice" -> 99, "Bob" -> 82)
     scores.get("Alice") match {
       case Some(score) => println(score)
       case None => println("Not found")
     }
  }
}