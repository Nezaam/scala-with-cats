package ch3.par3_6

object CodecInstances {
  implicit val stringCodec: Codec[String] = new Codec[String] {
    override def encode(value: String): String = value

    override def decode(value: String): String = value
  }

  implicit val intCodec: Codec[Int] = stringCodec.imap(_.toInt, _.toString)

  implicit val booleanCodec: Codec[Boolean] = stringCodec.imap(_.toBoolean, _.toString)

  implicit val doubleCodec: Codec[Double] = stringCodec.imap(_.toDouble, v => v.toString)

  implicit def boxCodec[A](implicit c: Codec[A]): Codec[Box[A]] =  c.imap[Box[A]](Box(_), _.value)
}
