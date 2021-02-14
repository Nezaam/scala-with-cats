import cats.instances.function._   // for Functor
import cats.syntax.functor._       // for mar

val func1: Int => Double = (x: Int) => x.toDouble

val func2: Double => Double = (y: Double) => y * 2

(func1 map func2)(1)     // composition using map
(func1 andThen func2)(1) // composition using andThen
func2(func1(1))               // composition written out by hand