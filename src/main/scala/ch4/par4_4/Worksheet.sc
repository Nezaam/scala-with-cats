
// Scala 2.11
val either1: Either[String, Int] = Right(10)
val either2: Either[String, Int] = Right(32)

for {
  a <- either1.right
  b <- either2.right
} yield a + b

// Scala 2.12
for {
  a <- either1
  b <- either2
} yield a + b

import cats.syntax.either._ // for asRight
val a = 3.asRight[String]
val b = 4.asRight[String]

for {
  x <- a
  y <- b
} yield x*x + y*y

/*
// error: type mismatch
 found Left required Right
def countPositive(nums: List[Int]) =
  nums.foldLeft(Right(0)){ (accum, num) =>
    if (num > 0) {
      accum.map(_ + 1)
    } else {
      Left("Negative. Stopping")
    }
  }
*/

def countPositive(nums: List[Int]) =
  nums.foldLeft(0.asRight[String]){ (accum, num) =>
    if (num > 0) {
      accum.map(_ + 1)
    } else {
      Left("Negative. Stopping")
    }
  }
countPositive(List(1,2,3))
countPositive(List(1,-2,3))

// capturing exceptions as instances of Either
Either.catchOnly[NumberFormatException]("1".toInt)
Either.catchOnly[NumberFormatException]("foo".toInt)

Either.catchNonFatal(sys.error("Badness"))

Either.fromTry(scala.util.Try("2".toInt))
Either.fromTry(scala.util.Try("foo".toInt))

Either.fromOption[String, Int](Some(42), "Badness")
Either.fromOption[String, Int](None, "Badness")

// Transform Either
"Error".asLeft[Int].getOrElse(0)
"Error".asLeft[Int].orElse(2.asRight[String])

-1.asRight[String].ensure("Must be non-negative!")(_ > 0)
1.asRight[String].ensure("Must be non-negative!")(_ > 0)

"error".asLeft[Int].recover {
  case _: String => -1
}
"error".asLeft[Int].recoverWith {
  case _: String => Right(-1)
}

"foo".asLeft[Int].leftMap(_.reverse)
6.asRight[String].bimap(_.reverse, _ * 7)
"bar".asLeft[Int].bimap(_.reverse, _ * 7)

123.asRight[String]
123.asRight[String].swap