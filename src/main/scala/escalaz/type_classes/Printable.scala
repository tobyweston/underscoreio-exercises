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