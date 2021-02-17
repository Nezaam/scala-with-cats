import cats.Monad
import cats.instances.option._   // for Monad
import cats.instances.list._     // for Monad
import cats.syntax.applicative._ // for pure
import cats.syntax.functor._     // for map
import cats.syntax.flatMap._     // for flatMap

val opt1 = Monad[Option].pure(3)
val opt2 = Monad[Option].flatMap(opt1)(a => Some(a + 2))
val opt3 = Monad[Option].map(opt2)(a => a * 100)

val list1 = Monad[List].pure(3)
val list2 = Monad[List].flatMap(List(1,2,3))(a => List(a, a * 10))
val list3 = Monad[List].map(list2)(a => a + 123)

1.pure[Option]
1.pure[List]

def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
  a.flatMap(x => b.map(y => x*x + y*y))

def sumSquare2[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
  for {
    x <- a
    y <- b
  } yield x*x + y*y


sumSquare(Option(3), Option(4))
sumSquare(List(1, 2, 3), List(4, 5))

sumSquare2(Option(3), Option(4))
sumSquare2(List(1, 2, 3), List(4, 5))

// sumSquare(1, 2) // no implicit found for parameter Monad[ScalaNumberProxy]

import cats.Id
sumSquare(3: Id[Int], 4: Id[Int])