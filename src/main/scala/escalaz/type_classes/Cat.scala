package escalaz.type_classes

object Cat {

  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      s"${cat.name} is a ${cat.age} year-old ${cat.color} cat."
    }
  }
}

case class Cat(name: String, age: Int, color: String)
