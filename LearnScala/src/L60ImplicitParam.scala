object Context_Implicits {
  implicit val default: String = "Java"
}

object Param {
  def print(content: String)(implicit lang: String) {
    println(lang + ":" + content)
  }
}

object L60ImplicitParam {
  def main(args : Array[String]) {
     Param.print("Scala")("Spark")
     
     import Context_Implicits._
     Param.print("Hadoop")
  }
}