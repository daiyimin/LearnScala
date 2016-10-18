package scala.learning.advanced

trait Compound_Type1
trait Compound_Type2
class Compound_Type extends Compound_Type1 with Compound_Type2  //实际上是多重继承??

object L54CompoundType {
  def compound_Type(x: Compound_Type1 with Compound_Type2) = {println("Compound Type in global method")}
  
  def main(args : Array[String]) {
    compound_Type(new Compound_Type1 with Compound_Type2)
    
    object compound_Type_object extends Compound_Type1 with Compound_Type2
    compound_Type(compound_Type_object)
    
   type compound_Type_alias = Compound_Type1 with Compound_Type2
   def compound_Type_Local(x: compound_Type_alias) =  {println("Compound Type in local method")}
   val compound_Type_ins = new Compound_Type
   compound_Type_Local(compound_Type_ins)
   
   type  Scala = Compound_Type1 with Compound_Type2 { def init(): Unit}
  }
}