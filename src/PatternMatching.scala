object PatternMatching extends App {

  def foo(a: Any) =
    a match {
      //constant pattern
      case 0 => "zero"
      case "s" => "s"
      case Nil => "empty list"

      // wildcard pattern
      case _ => "something else"
    }

  println(foo(3))

  def bar(a: Any) =
    a match {
      case List(0, _, _) => "found 0!"
      case List(0, _*) => ""
    }
}
