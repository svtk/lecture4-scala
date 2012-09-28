object Expressions extends App {

  trait Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String,
                   left: Expr, right: Expr) extends Expr

  def simplify(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplify(e)
    case BinOp("+", e, Number(0)) => simplify(e)
    case BinOp("*", e, Number(1)) => simplify(e)

    case op UnOp e => e
    case UnOp(op, e) => UnOp(op, simplify(e))
    case BinOp(op, l, r) => BinOp(op, simplify(l), simplify(r))
  }

  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ => e
  }

  def describe(e: Expr): String = (e: @unchecked) match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }

  val exp = BinOp("+", Var("x"), Var("y"))
  val BinOp(op, left, right) = exp

//  val any : Int = 1
//  val BinOp(op_, left_, right_) = any
}
