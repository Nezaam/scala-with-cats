import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import ch1.par1_4.Cat
import ch1.par1_4.ShowInstance._

import java.util.Date

val showInt: Show[Int] = Show.apply[Int]
val showString: Show[String] = Show.apply[String]

val intAsString: String = showInt.show(123)
val stringAsString: String = showString.show("hello")

val showInt = 123.show
val showString = "abc".show

// Custom instance by trait implementing
/*
implicit val dateShow: Show[Date] = new Show[Date] {
  override def show(date: Date): String = s"${date.getTime}ms since the epoch."
}
*/

// Custom instance by use Show constructor
implicit val dateShow: Show[Date] = Show.show(date => s"${date.getTime}ms since the epoch.")

new Date().show

val cat = Cat("Garfield", 41, "ginger and black")

Show.apply[Cat].show(cat)
cat.show


