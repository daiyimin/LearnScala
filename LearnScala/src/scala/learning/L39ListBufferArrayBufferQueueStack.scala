package scala.learning

import scala.collection.immutable.Queue

object L39ListBufferArrayBufferQueueStack {
  def main(args : Array[String]) {
    import scala.collection.mutable.ListBuffer
    var listbuffer = new ListBuffer[Int]
    listbuffer += 1
    listbuffer += 2
    println(listbuffer)
    
    import scala.collection.mutable.ArrayBuffer
    var arraybuffer = new ArrayBuffer[Int]
    arraybuffer += 1
    arraybuffer += 2
    println(arraybuffer)
    
    var empty = Queue[Int]()
    val queue1 = empty.enqueue(1)
    val queue2 = queue1.enqueue(List(2,3,4,5))
    println(queue2)
    val (element, left) = queue2.dequeue
    println(element + " : " + left)
    
    import scala.collection.mutable.Queue
    var queue = Queue[String]()
    queue += "a"
    queue ++= List("b", "c")
    println(queue)
    println(queue.dequeue)
    println(queue)
    
    import scala.collection.mutable.Stack
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.top)
    println(stack)
    println(stack.pop)
    println(stack)
 }
}