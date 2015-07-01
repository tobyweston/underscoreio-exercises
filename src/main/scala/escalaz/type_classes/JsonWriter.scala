package escalaz.type_classes

import java.util.Date

trait JsonWriter[A] {
  def write(value: A): Json
}

object DefaultJsonWriters {
  implicit val stringJsonWriter = new JsonWriter[String] {
    def write(value: String): Json = s""""$value""""
  }
  implicit val dateJsonWriter = new JsonWriter[Date] {
    def write(value: Date): Json = ???
  }
}

object Json {
  def toJson[A](value: A)(implicit writer: JsonWriter[A]): Json = {
    writer.write(value)
  }
}

object JsonSyntax {

  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit writer: JsonWriter[A]): Json = {
      writer.write(value)
    }
  }

}

object Examples extends App {

  def example1(): Unit = {
    import DefaultJsonWriters._
    val json: Json = Json.toJson("Dave")
    println(json)
  }

  def example2(): Unit = {
    import DefaultJsonWriters._
    import JsonSyntax._
    val json: Json = "Dave".toJson
    println(json)
  }

  example1()
  example2()
}
