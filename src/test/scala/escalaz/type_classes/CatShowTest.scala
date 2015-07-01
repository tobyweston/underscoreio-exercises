package escalaz.type_classes

import org.specs2.mutable.Specification

class CatShowTest extends Specification {

  val cat = Cat("Bob", 23, "Yellow")

  "Show a cat (using the interface syntax)" >> {
    import scalaz.syntax.show._
    cat.shows must_== "Bob is a 23 year-old Yellow cat."
  }

}
