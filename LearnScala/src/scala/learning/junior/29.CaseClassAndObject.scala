package scala.learning.junior

/** scala语言对case class和case object实现了语言级别的支持
    1. case classe的每个成员都是val
  	2. 每个case class都有伴生对象，有apply方法和unapply方法
 */
abstract class Person

case class Student(age: Int) extends Person

case class Worker1(age: Int, salary: Double) extends Person

case object Shared extends Person

object CaseClassAndObject {
  def main(args : Array[String]) {
    def caseOps(person: Person) = person match {
      // 这里默认调用case class的unapply方法
      case Student(age) => println("I am " + age + " year old student")
      case Worker1(_, salary) => print("I am a worker, paid " + salary)
      case Shared => println("No property")
    }
  
    // 这里默认调用了case class的apply方法
    caseOps(Student(19))
    caseOps(Shared)
    
    val worker = Worker1(29, 10000)
    val worker2 = worker.copy(salary = 5000)
    val worker3 = worker.copy(age = 30)
    caseOps(worker2)
  }
}