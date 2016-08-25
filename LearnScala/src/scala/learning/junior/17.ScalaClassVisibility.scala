package scala.learning

/**
 * 通过 []扩展变量和方法的可见度
 */
package junior {
  package navigation {
    /** 
     *  extend visiblity of Navigator to <b>spark</b> package
     *  all class, object of spark and its child package can access it    
    * */ 
    private[junior] class Navigator {
      protected[navigation] def useStarChart() {}
      class LegOfJourney {
        private[Navigator] val distance = 100
      }
      private[this] var speed = 200
/*      
 	    val journey = new LegOfJourney
      journey.distance
*/    
      }
  }
}

/**
 * 伴生类和伴生对象间能够相互访问
 */
class PackageOps {
  import PackageOps.power
  private def canMakeItTrue = power > 10001
}

object PackageOps {
  private def power = 10000
  
  def makeItTrue(p: PackageOps): Boolean = {
    val result = p.canMakeItTrue
    result
  }
}

object ScalaClass {
  def main(args : Array[String]) {
     
  }
}