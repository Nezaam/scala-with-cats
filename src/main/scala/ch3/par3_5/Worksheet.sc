import cats.Functor
import cats.instances.list._     // for Functor
import cats.instances.option._   // for Functor
import cats.instances.function._ // for Functor
import cats.syntax.functor._     // for map

val list1 = List(1, 2, 3)
val list2 = Functor[List].map(list1)(_ * 2)

val option1 = Option(123)
val option2 = Functor[Option].map(option1)(_.toString)


val func = (x: Int) => x + 1
val liftedFunc = Functor[Option].lift(func)

func(1)
liftedFunc(Option(1))

Functor[List].as(list1, "As")

// Functor Syntax
val func1 = (a: Int) => a + 1
val func2 = (a: Int) => a * 2
val func3 = (a: Int) => s"${a}!"
val func4 = func1 map func2 map func3

func4(123)


def doMath[F[_]](start: F[Int])(implicit functor: Functor[F]): F[Int] =
  start.map(n => n + 1 * 2)
doMath(Option(20))
doMath(List(1, 2, 3))