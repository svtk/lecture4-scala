object Placeholder extends App {

  def baz(f: (String, String) => Boolean) {
    println(f("abc", "ab"))
  }
  baz((s1, s2) => s1.contains(s2))

  val x: Int => Int = t => t + 1
  val y: Int => Int = _ => 1      //constant function
  val z: Int => Int = _ + 1
  val t: (Int, Int) => Int = _ + _

  def sum(a: Int, b: Int): Int = a + b

  val u : (Int, Int) => Int = sum _

  val v = sum(1, _: Int)

//  List(1, 2, 3).foldLeft(0)(sum)
  println(sum) // compile type error


  def foo(x: Int)(y: Int) = x + y

  def expectFunction(f: Int => Int) {}
  expectFunction(foo(1))
}
