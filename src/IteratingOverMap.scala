import collection.immutable.HashMap

object IteratingOverMap extends App {

  val map = HashMap(1 -> "a", 2 -> "b")

  (map).foreach {
    case (key, value) => {
      println(s"$key -> $value")
    }
  }
  for (entry <- map) {
    println(s"$entry")
  }
}
