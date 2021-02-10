import cats.Eq
import cats.instances.int._    // for Eq
import cats.instances.string._ // for Eq
import cats.instances.option._ // for Eq
import cats.instances.long._   // for Eq
import cats.syntax.eq._        // for Eq
import cats.syntax.option._    // for Eq
import ch1.par1_5.Cat

import java.util.Date    // for some and none

val eqInt = Eq[Int]

eqInt.eqv(123, 123)
eqInt.eqv(123, 321)

// eqInt.eqv(123, "123")
// error: type mismatch

123 === 123
123 =!= 321

// Some(1) === None
// value === is not a member of Some[Int]
// Some(1) === None

// Re-type the arguments as Option[Int]
(Some(1) : Option[Int]) === (None : Option[Int])

// Or by using Option.apply and Option.empty methods
Option(1) === Option.empty[Int]

// Using option syntax
1.some === none[Int]
1.some =!= none[Int]

// Comparing custom types
implicit val eqDate: Eq[Date] = Eq.instance[Date] { (date1, date2) =>
  date1.getTime === date2.getTime
}

val x = new Date()
val y = new Date()

x === x
x === y

// Custom eq for Cat
implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (cat1, cat2) =>
  cat1.name === cat2.name && cat1.age === cat2.age && cat1.color === cat2.color
}

val cat1 = Cat("Garfield", 38, "orange and black")
val cat2 = Cat("Heathcliff", 33, "orange and black")

cat1 === cat1
cat1 === cat2

val optionCat1 = Option(cat1)
val optionCat2 = Option.empty[Cat]

optionCat1 === optionCat1
optionCat1 === optionCat2

