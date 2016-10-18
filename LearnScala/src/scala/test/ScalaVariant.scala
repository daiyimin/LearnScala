package scala.test

object ScalaVariant {
  
  class Covariant[+A](val ele: A) {    //协变
    def getElement(x: Int) : A = {          //协变和返回值
      ele
    }
    
    def getInput[B >: A](x: B) : B = {      //协变和下界
      x
    }
  }
  
  class Contravariant[-A]() {          //逆变
    var ele = 1
    def getElement(x: A): Int = {            //逆变和函数参数
      ele
    }
    
    def getInput[B <: A](x: B): B = {        //逆变和上界
      x
    }
  }
  
  class Super
  trait Super1
  class traitSub extends Super1
  class Sub extends Super with Super1
  class Sub2 extends Super

  def main(args: Array[String]) {
    val sup = new Super  // Super is parent of Sub
    val tr1 = new traitSub // traitSub is parent of Sub
    val sub = new Sub    // Sub is child
    val sub2 = new Sub2
    
/**** Start to test Covariant ****/
    val coSup = new Covariant[Super](sup)
    coSup.getElement(1)
    coSup.getInput(sup)
    coSup.getInput(sub)      //getInput接受Super的父类对象作为参数，根据Liskov原则，因此所有Super父类的子类对象都能作为getInput参数。这是为什么sub也能传给getInput
    coSup.getInput(tr1)      // tr1 is not Super's parent
    coSup.getInput(sub2)
    
    /**
     * Covariant[Sub] is child of Covariant[Super]
     * Covariant[Sub] can accept all operation of Covariant[Super]
     * Covariant[Super] cannot accept all operation of Covariant[Sub]
     */
    val coSub = new Covariant(sub)
    coSub.getElement(1)
    coSub.getInput(sup)
    coSub.getInput(sub)
    coSub.getInput(tr1)
    coSub.getInput(sub2)
    
/**** Start to test Contravariant ****/
    /**
     * Contravariant[Sub] is parent of Contravariant[Super]
     * Contravariant[Super] can accept all operation of Contravariant[Sub]
     * Contravariant[Sub] cannot accept all operation of Contravariant[Super]
     */
    val contraSup = new Contravariant[Super]
    contraSup.getElement(sup)
    contraSup.getElement(sub)
    contraSup.getInput(sup)
    contraSup.getInput(sub)
//     contraSup.getInput(tr1)
   
    val contraSub = new Contravariant[Sub]
    contraSub.getElement(sub)
//    contraSub.getElement(sup)
//    contraSub.getInput(sup)
    contraSub.getInput(sub)
//    contraSub.getInput(tr1)  }
  }
  
}