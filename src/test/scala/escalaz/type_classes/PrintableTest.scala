package escalaz.type_classes

import org.specs2.mutable.Specification

class PrintableTest extends Specification {

  val cat = Cat("Bobby Brown", 15, "Brown")

  "Default printables" >> {
    PrintDefaults.stringPrintable.format("hello") must_== "hello"
    PrintDefaults.intPrintable.format(23) must_== "23"
  }

  "Using Print interface methods directly" >> {
    import PrintDefaults._

    Print.format("Hello") must_== "Hello"
    Print.format(23) must_== "23"
    // Print.format(23L) must_== 23 // could not find implicit value for Printable[Long] ✓
  }

  "Printing a Cat (meow!)" >> {
    Print.format(cat) must_== "Bobby Brown is a 15 year-old Brown cat."
  }

  "Printing using the `syntax` class" >> {
    import PrintSyntax._
    cat.format must_== "Bobby Brown is a 15 year-old Brown cat."
  }

  "Printing using the `syntax` class (but this time using the context bounds syntax)" >> {
    import PrintSyntax._
    cat.formatAlt must_== "Bobby Brown is a 15 year-old Brown cat."
  }
}
