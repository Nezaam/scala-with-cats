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
/*
implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
  override def empty = Set.empty[A]

  override def combine(x: Set[A], y: Set[A]): Set[A] = x union y
}
*/

implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
  override def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
}

implicit def symDiffMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
  override def empty = Set.empty[A]

  override def combine(x: Set[A], y: Set[A]) = (x diff y) union (y diff x)
}
associativeLaw(Set(1,2,3), Set(4,5,6), Set(7,8,9))
identityLaw(Set(1,2,3))