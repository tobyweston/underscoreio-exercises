package escalaz.type_classes

trait Printable[A] {
  def format(value: A): String
}

object PrintDefaults {
  implicit var stringPrintable = new Printable[String] {
    def format(value: String): String = value
  }
  implicit var intPrintable = new Printable[Int] {
    def format(value: Int): String = value.toString
  }
}

object Print {
  def format[A](value: A)(implicit printer: Printable[A]): String = {
    printer.format(value)
  }
  def print[A](value: A)(implicit printer: Printable[A]) {
    println(printer.format(value))
  }
}

object PrintSyntax {

  implicit class PrintOps[A](value: A) {
    def format(implicit printer: Printable[A]): String = {
      printer.format(value)
    }

    def print(implicit printer: Printable[A]) {
      println(printer.format(value))
    }

    /** alternative using context bounds. Equivalent to [[format]] above.
      *
      * For example,
      *
      * {{{def foo[A: M]}}}
      * is equivalent to:
      * {{{def foo[A](implicit ma: M[A])}}}
      *
      */
    def formatAlt[A : Printable]: String = {
      val printer: Printable[A] = implicitly[Printable[A]]
      printer.format(value)
    }
  }

}


