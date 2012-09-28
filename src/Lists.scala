object Lists extends App {

  trait List[+T] {
    def head: T

    def tail: List[T]

    def ::[B >: T](x: B): List[B] =
      new ::(x, this)
  }

  case class ::[T](head: T, tail: List[T]) extends List[T] {}


  object Nil extends List[Nothing] {
    def head = throw new Exception("head of empty list")

    def tail = throw new Exception("tail of empty list")

    override def toString = "Nil"
  }


  val list = 1 :: Nil

  list match {
    case ::(2, Nil) => "two"
    case 1 :: Nil => "one"
  }


  def map[T, R](list: List[T], f: T => R): List[R] =
    list match {
      case head :: tail => f(head) :: map(tail, f)
      case Nil => Nil
    }


  def forAll[T](list: List[T], f: T => Boolean): Boolean =
    list match {
      case head :: tail => f(head) && forAll(tail, f)
      case Nil => true
    }


  val list123 = 1 :: 2 :: 3 :: Nil
  println(map(list123, (x: Int) => x * x))
  println(forAll(list123, (x: Int) => x % 2 == 0))

  //todo reverse
  def foldLeft[T, R](list: List[T], z: R, op: (R, T) => R): R =
    list match {
      case Nil => z
      case head :: tail => foldLeft(tail, op(z, head), op)
    }
}
