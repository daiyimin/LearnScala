package scala.learning.junior
import scala.collection.mutable._
import scala.collection.immutable.TreeMap


object L40SetMap {
  def main(args : Array[String]) {
    val data = Set.empty[Int]
    data ++= List(1,2,3)
    data += 4
    data --= List(2,3)
    println(data)
    data +=1
    println(data)
    data.clear
    println(data)
    
    val map = Map.empty[String, String]
    map("Java") = "Hadoop"
    map("Scala") = "Spark"
    println(map)
    println(map("Scala"))
    
    val treeSet = TreeSet(1,3,6,2)
    println(treeSet)
    val treeSetForChar = TreeSet("Spark", "Scala", "Hadoop")
    println(treeSetForChar)
    
    val treeMap = TreeMap("Scala" -> "Spark", "Java" -> "Hadoop")
    println(treeMap)
  }
}