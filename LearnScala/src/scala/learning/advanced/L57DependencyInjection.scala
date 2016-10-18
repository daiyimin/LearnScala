package scala.learning.advanced

trait Logger { def log (msg: String) }
trait Auth {
  auth: Logger =>
  def act(msg: String) {
    log(msg)
  }
}

object DI extends Auth with Logger {
  override def log(msg: String) = println(msg)
}

object L57DependencyInjection {
  def main(args : Array[String]) {
     DI.act("hello spark")
  }
}