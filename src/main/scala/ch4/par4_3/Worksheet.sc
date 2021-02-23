import cats.Monad
import cats.syntax.functor._ // for map
import cats.syntax.flatMap._ // for flatMap
import cats.instances.option._
import cats.instances.list._

def sumSquare[F[_]: Monad](a: F[Int], b: F[Int]): F[Int] =
  for {
    x <- a
    y <- b
  } yield x*x + y*y


sumSquare(Option(3), Option(4))
sumSquare(List(1, 2, 3), List(4, 5))

// sumSquare(1, 2) // no implicit found for parameter Monad[ScalaNumberProxy]

import cats.Id
sumSquare(3: Id[Int], 4: Id[Int])
"Dave": Id[String]
123: Id[Int]
List(1,2,3): Id[List[Int]]

val a = Monad[Id].pure(3)
val b = Monad[Id].flatMap(a)(_ + 1)

for {
  x <- a
  y <- b
} yield x + y


// Implement pure, map and flatMap fo Id
def pure[A](value: A): Id[A] = value

def map[A, B](initial: Id[A])(func: A => B): Id[B] = func(initial)

def flatMap[A, B](initial: Id[A])(func: A => Id[B]): Id[B] = func(initial)

pure(123)
map(123)(_ + 1)
flatMap(123)(_ * 2)