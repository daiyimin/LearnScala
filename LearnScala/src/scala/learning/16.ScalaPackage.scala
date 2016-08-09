package scala.learning

/** package object **/
package com.scala.spark

/**
 * Package cannot define its own variable and method
 * But it's possible to define variable and method in its package object
 * The package and package object shall have exact same name
 * The classes of the package can access method and variable in the package object
 */
package object people {
  val greeting = "Hej lo"
  def hello = println(greeting)
}

package people {
  class people {
    def say = println(greeting)
    def say2 = hello
  }
}

/**
 * Scala implicit import
 * 
 * import java.lang._
 * import scala._
 * import Predef._
 */

import java.awt.{ Color, Font } // import java class
import java.util.{ HashMap => JavaHasMap } // import java class, but rename it to avoid name conflict with scala class
import scala.{ StringBuilder => _ } // to disable a scala StringBuilder class? but seems doesn't work

/** scope of a package **/
// start of scala.learning.spark.navigation package
package spark.navigation {
  abstract class Navigator {
    def act
  }

  package tests {
    // add testing code
    class NavigatorSuite
  }

  package impls {
    // add implementation code
    class Action extends Navigator {
      def act = println("Acting...")
    }
  }
}
// end of scala.learning.spark.navigation package

// start of scala.learning.hadoop package
package hadoop {
  package navigation {
    class Navigator
  }

  package launch {
    class Booster {
      val nav = new navigation.Navigator
    }
  }
}
// end of scala.learning.hadoop package

object ScalaPackage {
  def main(args: Array[String]) {
    val sb = new StringBuilder
  }
}