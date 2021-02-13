trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]): Monoid[A] = monoid
}


def associativeLaw[A](x: A, y: A, z: A)(implicit monoid: Monoid[A]): Boolean = {
  monoid.combine(x, monoid.combine(y, z)) == monoid.combine(monoid.combine(x, y), z)
}

def identityLaw[A](x: A)(implicit monoid: Monoid[A]): Boolean = {
  (monoid.combine(x, monoid.empty)) == x && (monoid.combine(monoid.empty, x) == x)
}

/* And monoid with identity true
implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
  override def combine(x: Boolean, y: Boolean): Boolean = x && y

  override def empty: Boolean = true
}
 */

/* Or with identity false
implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
  override def combine(x: Boolean, y: Boolean): Boolean = x || y

  override def empty: Boolean = false
}
*/

/* Exclusive or with identity false

implicit val booleanEitherMonoid: Monoid[Boolean] = new Monoid[Boolean] {
  override def empty = false

  override def combine(x: Boolean, y: Boolean): Boolean = {
    (x && !y) || (!x && y)
  }
}

 */

/* Exclusive nor (the negation of exclusive or) with identity true

 */
implicit val booleanXnorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
  override def empty = true

  override def combine(x: Boolean, y: Boolean): Boolean = {
    (!x || y) && (x || !y)
  }
}
associativeLaw(true, true, false)
identityLaw(false)