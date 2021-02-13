package ch2.par2_5
import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import cats.syntax.semigroup._

trait SuperAdder {
  def add[A: Monoid](items: List[A]): A = items.foldLeft(Monoid.empty[A])(_ |+| _)
}

object Boot extends App with SuperAdder {
   val intResult = add(List(1, 2, 3))

  val optResult = add(List(Some(1), Some(2), Some(3), None))
  val optResult2 = add[Option[Int]](List(Some(1), Some(2), Some(3)))

  println(intResult)
  println(optResult)
  println(optResult2)

  case class Order(totalCost: Double, quantity: Double)

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)

    override def empty: Order = Order(0, 0)
  }

  val orderResult = add(List(Order(2.3, 1.2), Order(3.5, 6.8)))
  println(orderResult)
}
