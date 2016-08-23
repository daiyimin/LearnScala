package scala.learning

object L34ListSorting {
  def main(args : Array[String]) {
    
    /**
     * 归并排序
     * @param less, function to compare list items
     * @param input, the list to be sorted
     * @return  sorted list
     */
    def mergesort[T](less: (T,T) => Boolean)(input: List[T]) : List[T] = {
     /**
      * method to merge two sorted list
      */
     def merge(xList: List[T], yList: List[T]) : List[T] =
       (xList, yList) match {
       case (Nil, _) => yList
       case (_, Nil) => xList
       case (x::xtail, y::ytail) => {
         if (less(x,y)) x :: merge(xtail, yList)
         else y :: merge(xList, ytail)
       }
       }
      val n = input.length /2
      if (n == 0) input
      else {
        val (x,y) = input splitAt n
        merge (mergesort(less)(x), mergesort(less)(y))   
      }
    }
    
    val messList = List(8,3,5,7,2,1,0,6,3)
    
    var result = mergesort( (x:Int, y:Int) => x < y)(messList)
    println(result)
    
    var reverseSort = mergesort( (x:Int, y:Int)  => x > y) _
    println(reverseSort(messList))
        
  }
}