package escalaz.type_classes

import org.specs2.mutable.Specification

class PrintableTest extends Specification {

  "Default printables" >> {
    PrintDefaults.stringPrintable.format("hello") must_== "hello"
    PrintDefaults.intPrintable.format(23) must_== "23"
  }

  import PrintDefaults._
  "Using Print interface methods directly" >> {
    Print.format("Hello") must_== "Hello"
    Print.format(23) must_== "23"
    // Print.format(23L) must_== 23 // could not find implicit value for Printable[Long] ✓
  }

}
