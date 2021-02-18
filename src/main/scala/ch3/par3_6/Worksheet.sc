import ch3.par3_6.Codec.{encode, decode}
import ch3.par3_6.CodecInstances._
import ch3.par3_6.Box
import ch3.par3_6.Printable._
import ch3.par3_6.PrintableInstances._

format("hello")
format(true)

format(Box("hello"))
format(Box(true))

//format(123)  - could not find implicit value for Box[Int]

// Using codecs
encode(123.4)
decode[Double]("123.4")

encode(Box(123.4))
decode[Box[Double]]("123.4")