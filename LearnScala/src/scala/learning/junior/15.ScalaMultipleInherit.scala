package scala.learning.junior

/** sample 1 **/
class Human {
  println("Human")
}

trait TTeacher extends Human {
  println("TTeacher")
  def teach
}

trait PianoPlayer extends Human {
  println("PianoPlayer")
  def playPiano = println("I'm playing piano")
}

class PianoTeacher extends Human with TTeacher with PianoPlayer {
 override def teach = println("I am traning students") 
}

/** sample 2 **/
trait Action {
  def doAction
}

trait BeforeAndAfter extends Action {
  abstract override def doAction {
    println("Initializing")
    super.doAction
    println("Destroying")
  }
}

class Worker extends Action {
  override def doAction = println("Working...")
}

object ScalaMultipleInherit {
  def main(args : Array[String]) {
     var teacher = new PianoTeacher
     teacher.teach
     teacher.playPiano
     
     println
     var human = new Human with TTeacher with PianoPlayer {
       override def teach = println("Teaching")
     }
     human.teach
     
     
     println
     var worker = new Worker with BeforeAndAfter
     worker.doAction
  }
}