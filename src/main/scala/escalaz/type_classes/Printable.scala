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
  implicit var catPrintable = new Printable[Cat] {
    def format(cat: Cat): String = s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
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

case class Cat(name: String, age: Int, color: String)