package scala.learning.advanced

class Structural { def open() = print("A class instance opened") }

object L53StructureType {
  // struct type use case 1
  def init(res: { def open(): Unit } ) {
    res.open
  }  
  
  def main(args: Array[String]) {
    init(new { def open() = println("Opened") })
    
    // struct type use case 2
    type X = { def open() : Unit }
    def init( res: X) { res.open }
    
    // call struct type in different style
    // struct type doesn't require the input has certain class, instead only a open() method is required
    init(new { def open() = println("Opened 2nd time") } )
    
    object A { def open() = println("Opened in object")}
    init(A)
    
    val struct = new Structural
    init(struct)
  }
}

