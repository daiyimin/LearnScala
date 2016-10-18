package scala.test

trait EntityElement {
  self: { def behave(msgType: Int, msg: String) } => 
}

trait NetworkElement {
  def connect = println("Connecting...")
}

class MyElement extends NetworkElement {
}

object TraitTest {
  def main(args: Array[String]) {
/*    var MyEntity = new MyElement with EntityElement {
      def behave(msgType: Int, msg: String) = msgType match {
        case 1 => println("Type 1")
        case 2 => println("Type 2")
        case _ =>
      }
    }
*/    
  }
}