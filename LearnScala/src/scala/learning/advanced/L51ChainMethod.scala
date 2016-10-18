package scala.learning.advanced


class Animal { def breathe: this.type = this }
class Cat extends Animal {
  def eat: this.type = this
}

object L51ChainMethod {
  def main(args : Array[String]) {
     var ani = new Cat
     ani.breathe.eat
  }
}