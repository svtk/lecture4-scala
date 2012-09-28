package forVsWhile.whileExample

class Bar {
  def foo(list: List[Int]) {
    val iterator = list.iterator
    while (iterator.hasNext) {
      val n = iterator.next()
      if (n > 0) println(n)
    }
  }
}
