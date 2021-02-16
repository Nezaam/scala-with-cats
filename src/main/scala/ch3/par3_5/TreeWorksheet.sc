import ch3.par3_5.{ Tree, Branch, Leaf }
import ch3.par3_5.Tree._
import cats.Functor
import cats.syntax.functor._

// Branch(Leaf(10), Leaf(20)).map(_ * 2) error: value map is not a member of Branch
Tree.leaf(100).map(_ * 2)

Tree.branch(Tree.leaf(10), Tree.leaf(20)).map(_ * 2)