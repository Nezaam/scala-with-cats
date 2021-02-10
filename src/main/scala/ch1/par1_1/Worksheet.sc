import ch1.par1_1.{Json, Person}
import ch1.par1_1.JsonWriterInstances._
import ch1.par1_1.JsonSyntax._
// Using Interface Object
Json.toJson(Person("Dave", "dave@example.com"))

// Using Interface Syntax
Person("Jhon", "jhon@example.com").toJson
