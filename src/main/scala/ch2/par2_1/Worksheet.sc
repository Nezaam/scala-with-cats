import cats.Monoid

def associativeLaw[A](x: A, y: A, z: A)(implicit monoid: Monoid[A]): Boolean = {
  monoid.combine(x, monoid.combine(y, z)) == monoid.combine(monoid.combine(x, y), z)
}

def identityLaw[A](x: A)(implicit monoid: Monoid[A]): Boolean = {
  (monoid.combine(x, monoid.empty)) == x && (monoid.combine(monoid.empty, x) == x)
}