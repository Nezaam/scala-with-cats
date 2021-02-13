import cats.Monoid
import cats.instances.int._ // for Monoid
import cats.instances.string._ // for Monoid
import cats.instances.option._ // for Monoid
import cats.Semigroup
import cats.syntax.semigroup._  // for |+|
// Monoid instance for string
Monoid[String].combine("Hi ", "there")
Monoid[String].empty

// Is equivalent to:
Monoid.apply[String].combine("Hi ", "there")
Monoid.apply[String].empty

Semigroup[String].combine("Hello ", "World")


Monoid[Int].combine(21, 21)

val a = Option(20)
val b = Option(22)
Monoid[Option[Int]].combine(a, b)

// Using syntax
val stringResult = "Hi " |+| "there" |+| Monoid[String].empty

val intResult = 2 |+| 3 |+| Monoid[Int].empty