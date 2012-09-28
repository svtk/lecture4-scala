object ForExample extends App {
  def foo(numbers: List[Int], strings: List[String]) {
    for (
      number <- numbers
      if (conditionOnNumber(number));
      str <- strings
      if (conditionOnString(str))
    )  yield (s"$number $str")
  }

  def conditionOnNumber(number: Int) = {
    println(s"invoke on $number")
    true
  }

  def conditionOnString(str: String) = {
    println(s"invoke on $str")
    true
  }

  foo(List(1, 2), List("a", "b"))
}
