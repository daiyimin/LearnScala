package scala.test

object NewtonWayFindSqrt {
  def main(args : Array[String]) {
    
    var cnt = 0
    
    def sqrt(num : Int) = {
      def compute( A: Double, B: Double): Double = {
        var delta = B - A * A
        if (delta.abs < 0.0001) A
        else compute( (A+B/A)/2, B)
      }
      compute(1,num)
    }
    
    println(sqrt(4))
  }
}