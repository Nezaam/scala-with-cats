import ch1.par1_3.{Cat, Printable}
import ch1.par1_3.PrintableInstances._
import ch1.par1_3.PrintableSyntax._

val cat = Cat("Garfield", 42, "brown")

Printable.print(cat)

val cat2 = Cat("Boris", 4, "black")

cat2.print