package escalaz.type_classes

object Cat {

  import PrintDefaults._
  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name  = Print.format(cat.name)
      val age   = Print.format(cat.age)
      val color = Print.format(cat.color)

      s"$name is a $age year-old $color cat."
    }
  }
}

case class Cat(name: String, age: Int, color: String)
