package ch1.par1_4

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._

object ShowInstance {
  implicit val catShow: Show[Cat] = new Show[Cat] {
    override def show(value: Cat): String = {
      val name = value.name.show
      val age = value.age.show
      val color = value.color.show
      s"$name is a $age year-old $color cat"
    }
  }
}
