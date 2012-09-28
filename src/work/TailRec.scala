package work

import annotation.tailrec


object TailRec {
//  @tailrec
  def sum(from: Int, to: Int): Int =
    if (from > to) 0 else from + sum(from + 1, to)
}
