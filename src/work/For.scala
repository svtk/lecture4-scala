package work

object For extends App {
  def foo(numbers: List[Int], strings: List[String]) =
    numbers.filter {num => num % 2 == 1}.flatMap {
      num => strings.filter { s => s.contains(s"$num") }.map { s => s"$num : $s" }
    }

  def fooWithFor(numbers: List[Int], strings: List[String]) =
    for {n <- ((numbers).withFilter {
      case (n) => (n % 2 == 1)
    }); s <- strings
             if (s.contains(s"$n"))
    } yield s"$n : $s"


  println(foo(List(1, 2, 3, 4), List("42", "13", "34")))
  println(fooWithFor(List(1, 2, 3, 4), List("42", "13", "34")))
}
