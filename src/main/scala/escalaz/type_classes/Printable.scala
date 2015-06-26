package escalaz.type_classes

trait Printable[A] {
  def format(value: A): String
}

object PrintDefaults {
  implicit var stringPrintable = new Printable[String] {
    def format(value: String): String = value.toString
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