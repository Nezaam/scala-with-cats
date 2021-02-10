import ch1.par1_2.JsonSyntax._
import ch1.par1_2.JsonWriterInstances._
import ch1.par1_2.{Json, Person}
// Using Interface Object
Json.toJson(Person("Dave", "dave@example.com"))

// Using Interface Syntax
Person("Jhon", "jhon@example.com").toJson

// Using type constructor for Option[String] type
Json.toJson(Option("Some string"))
