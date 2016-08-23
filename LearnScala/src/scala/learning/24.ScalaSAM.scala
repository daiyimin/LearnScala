package scala.learning

import javax.swing._
import java.awt.event._

object ScalaSAM {
  def main(args : Array[String]) {
     var data = 0
     val frame = new JFrame("SAM testing")
     val jButton = new JButton("Counter")
//     jButton.addActionListener(new ActionListener {
//         override def actionPerformed(event: ActionEvent) {
//           data += 1
//           println(data)
//         }
//     })
    
    // SAM转换把入参转成返回值
    implicit def convertedAction(action: ActionEvent => Unit) = {
       new ActionListener {
         override def actionPerformed(event: ActionEvent) {
           action(event)
         }
       }
    }
    jButton.addActionListener( (event:ActionEvent) => {data += 2; println(data) } )
     
    frame.setContentPane(jButton)
    frame.pack
    frame.setVisible(true)
  }
  
}