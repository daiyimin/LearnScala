package scala.learning.advanced

/*
 * Scala的泛型支持形变，包括协变(+)和逆变(-)两种
 * 形变是指泛型类型具有和类型参数相同(+)或者相反(-)的继承关系
 * 如果泛型的类型参数前有协变标识符+，那么类型参数只能出现在协变位置。例如成员变量，成员方法的返回值，成员方法的类型参数都是协变位置
 * 反之，如果泛型的类型参数前有逆变标识符+，那么类型参数只能出现在逆变位置。例如成员方法的参数是逆变位置
 */
class Person
class Student extends Person

class Group[+T](arg: T) {  //成员变量是协变位置
  def dismiss[T]() {}
}
trait Friend[-T] {
  def makeFriend(somebody: T)  //成员方法的参数是逆变位置
}

object L49Variance {
  def main(args : Array[String]) {
     def makeFriendWithYou(s: Student, f: Friend[Student]) {f.makeFriend(s)}
     // Friend[Person] is child of Friend[Student]
     var personFriend = new Friend[Person] { def makeFriend(somebody: Person) { println("I make friend with a person: " + somebody) } }
     var studentFriend = new Friend[Student] { def makeFriend(somebody: Student) { println("I make friend with a student: " + somebody) } }
     var student = new Student
     makeFriendWithYou(student, personFriend)
     makeFriendWithYou(student, studentFriend)
     
     // Group[Student] is child of Group[Person]
     var group: Group[Person] = new Group[Student](new Student)
  }
}