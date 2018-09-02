package demo

/**
 * http://www.runoob.com/kotlin/kotlin-data-sealed-classes.html
 */
/*
编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
equals() / hashCode()
toString() 格式如 "User(name=John, age=42)"
componentN() functions 对应于属性，按声明顺序排列
copy() 函数
如果这些函数在类中已经被明确定义了，或者从超类中继承而来，就不再会生成。

为了保证生成代码的一致性以及有意义，数据类需要满足以下条件：
主构造函数至少包含一个参数。
所有的主构造函数的参数必须标识为val 或者 var ;
数据类不可以声明为 abstract, open, sealed 或者 inner;
数据类不能继承其他类 (但是可以实现接口)
 */
data class User1(val name: String, val age: Int)

// ================密封类====================
/*
密封类用来表示受限的类继承结构：当一个值为有限几种的类型, 而不能有任何其他类型时。
在某种意义上，他们是枚举类的扩展：枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，
而密封类的一个子类可以有可包含状态的多个实例。
声明一个密封类，使用 sealed 修饰类，密封类可以有子类，但是所有的子类都必须要内嵌在密封类中。
sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
 */
sealed class Expr {
    data class Const(val number: Double) : Expr()
    data class Sum(val ex1: Expr, val ex2: Expr) : Expr()
    object NotANumber : Expr()
}

fun eval(expr: Expr): Double = when (expr) {
    is Expr.Const -> expr.number
    is Expr.Sum -> eval(expr.ex1) + eval(expr.ex2)
    Expr.NotANumber -> Double.NaN
// 不再需要 `else` 子句，因为我们已经覆盖了所有的情况
}

fun main(args: Array<String>) {
    val jack = User1(name = "Jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(jack)
    println(olderJack)

    val jane = User1("Jane", 3)
    // 解构声明
    val (name, age) = jane
    println("$name, $age years of age")

    val exprValue = eval(Expr.Sum(Expr.Const(1.0), Expr.Const(2.0)))
    println(exprValue)
}