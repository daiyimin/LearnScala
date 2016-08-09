
package scala.learning

trait Logger {
  def log (msg : String)
}

//class ConcreteLogger extends Logger {
class ConcreteLogger extends Cloneable with Logger {
  // override is optional when override an abstract method
  override def log (msg : String) = println ("Log: " + msg)
  
  def logging {
    log("It is me")
  }
}

trait LoggerA extends Logger {
  override def log(msg : String) = println("LogA: " + msg)
}

trait LoggerB extends Logger {
  override def log(msg : String) = println("LogB: " + msg)
}


object ScalaTrait {
  def main(args : Array[String]) {
     var logger = new ConcreteLogger
     logger.logging
     
     logger = new ConcreteLogger with LoggerA
     logger.log("hello trait")

     logger = new ConcreteLogger with LoggerB
     logger.logging  
  }
}