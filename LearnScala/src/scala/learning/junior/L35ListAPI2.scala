package scala.learning.junior

object L35ListAPI2 {
  def main(args : Array[String]) {
    val list = List(1,2,3,4,5,6)
    println(list map (_ + 1) )
    
    val data = List("Scala", "Hadoop", "Spark")
    println(data map (_.length) )
    println(data map (_.toList.reverse.mkString))
    
    println(data map (_.toList))
    // 把所有结果集合放入一个大集合
    println(data.flatMap { _.toList } )
//    println(List.range(1,3))
    println(List.range(1,10) flatMap (i=> List.range(1,i) map (j => (i,j))))
    
    var sum = 0
    List(1,2,3,4,5).foreach(sum += _)
    println("Sum: " + sum)
    
    println(list.filter { _ % 2 == 0 } )
    println(data filter ( _.length > 5 ))
  }
}