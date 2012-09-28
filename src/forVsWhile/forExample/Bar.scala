package forVsWhile.forExample

class Bar {
  def foo(list: List[Int]) {
    for (n <- list; if (n > 0)) {
      println(n)
    }
  }
}
