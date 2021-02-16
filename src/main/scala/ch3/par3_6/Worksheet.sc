import ch3.par3_6.{Box, Printable}
import ch3.par3_6.Printable._
import ch3.par3_6.PrintableInstances._

format("hello")
format(true)

format(Box("hello"))
format(Box(true))

//format(123)  - could not find implicit value for Box[Int]