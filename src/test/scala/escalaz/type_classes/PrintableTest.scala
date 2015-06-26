package escalaz.type_classes

import org.specs2.mutable.Specification

class PrintableTest extends Specification {

  "Default printables" >> {
    PrintDefaults.stringPrintable.format("hello") must_== "hello"
    PrintDefaults.intPrintable.format(23) must_== "23"
  }

}
