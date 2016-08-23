package scala.learning

object L33ListAPI {
  def main(args : Array[String]) {
    //列表连接
     println(List(1,2) ::: List(3,4) ::: List(5,6))
     println(List(1,2) ::: (List(3,4) ::: List(5,6)))
     
     val bigData = List("Hadoop", "Spark", "Kaffka")
     println(bigData.length) // length速度比较慢，不建议使用
     println(bigData.last)
     println(bigData.init)
     println(bigData.reverse)
     println(bigData)
     println(bigData take 2)
     println(bigData drop 2)
     println(bigData splitAt 2)
     println(bigData apply 2)
     println(bigData(2))
     
     val data = List('a', 'b', 'c', 'd', 'e', 'f')
     println(data.indices)
     println(data.indices zip data)
     println(data.zipWithIndex)
     println(data toString)
     println(data.mkString("[", ",", "]"))
     println(data.mkString("    "))
     println(data.mkString)     
     
     val buffer = new StringBuilder
     data addString (buffer, "(", ";;", ")")
     println(buffer)
     
     val array = data.toArray
     println(array.toList)
     
     val new_Array = new Array[Char](10)
     data.copyToArray(new_Array, 3)
     new_Array.foreach(print)
     println
     
     val iterator = data.toIterator
     println(iterator.next())
     println(iterator.next())
  }
}