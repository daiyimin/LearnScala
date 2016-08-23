package scala.learning

object L32ListInAction {
  def main(args : Array[String]) {
    //List内部元素的数据类型都是一致的
     val bigData = List("Hadoop", "Spark")
     val data = List(1,2,3)
     
     val bigData_Core = "Hadoop" :: ("Spark" :: Nil)
     val data_Int = 1 :: 2 :: 3 :: Nil
     
     // List分成head和tail，head是第一个元素，tail表示所有其它元素
     println(data.isEmpty)
     println(data.head)
     println(data.tail.head)
     
     //List的提取器，List有unapplySeq方法
     val List(a,b) = bigData
     println("a: " + a + " b:" + b)
     val x :: y :: rest = data
     println("x " + x + " y " + y + " rest " + rest)
     
     val shuffledData = List(6,3,5,6,2,9,1)
     println(sortList(shuffledData))
     
     /**
      * sortList是一个冒泡排序算法
      * 每次递归冒泡，从列表尾部向头部移动，把尾部的n个元素变成有序列表
      */
     def sortList(list: List[Int]): List[Int] = list match {
       case List() => List()
       case head :: tail => compute(head, sortList(tail))
     }
     
     /**
      *   compute的功能是把data插入一个有序列表，返回一个新的有序列表
      */
     def compute(data : Int, dataSet : List[Int]): List[Int] = dataSet match {
       case List() => List(data)
       case head :: tail => if (data <= head) data :: dataSet
       else head :: compute(data, tail)
     }
  }
}