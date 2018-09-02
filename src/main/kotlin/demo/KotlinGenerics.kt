package demo

import java.util.*

/**
 * http://www.runoob.com/kotlin/kotlin-generics.html
 */
class Box<T>(t: T) {
    val value = t
}

fun <T> boxIn(t: T) = Box(t)

fun <T> doPrintln(t: T) {
    when (t) {
        is Int -> println("整型数字为 $t")
        is String -> println("字符串转换为大写：${t.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

// 对泛型的的类型上限进行约束
fun <T : Comparable<T>> sort(list: List<T>) {
    Collections.sort(list)
}

// 对于多个上界约束条件，可以用 where 子句
fun <T> copyWhenGreater(list: List<T>, threadsHold: T): List<String>
        where T : CharSequence, T : Comparable<T> {
    return list.filter { it > threadsHold }.map { it.toString() }
}

// Kotlin 中没有通配符类型，它有两个其他的东西：声明处型变与类型投影
// 声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
// 使用 out 使得一个类型参数协变，协变类型参数只能用作输出，可以作为返回值类型但是无法作为入参的类型
class Runoob1<out A>(val a: A) { // Java 中的? extends A
    fun foo(): A {
        return a
    }
}

// in 使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型但是无法作为返回值的类型：
class Runoob5<in A>(a: A) { // Java 中的? super A, 另这里不能加val或者var修饰a ，原因？
    fun foo(a: A) {
        println(a)
    }
}

/*
有些时候, 你可能想表示你并不知道类型参数的任何信息, 但是仍然希望能够安全地使用它. 这里所谓"安全地使用"是指, 对泛型类型定义一个类型投射, 要求这个泛型类型的所有的实体实例, 都是这个投射的子类型。
对于这个问题, Kotlin 提供了一种语法, 称为 星号投射(star-projection):

假如类型定义为 Foo<out T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper ,Foo<> 等价于 Foo<out TUpper> . 它表示, 当 T 未知时, 你可以安全地从 Foo<> 中 读取TUpper 类型的值.
假如类型定义为 Foo<in T> , 其中 T 是一个反向协变的类型参数, Foo<> 等价于 Foo<inNothing> . 它表示, 当 T 未知时, 你不能安全地向 Foo<> 写入 任何东西.
假如类型定义为 Foo<T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper , 对于读取值的场合, Foo<*> 等价于 Foo<out TUpper> , 对于写入值的场合, 等价于 Foo<in Nothing> .
如果一个泛型类型中存在多个类型参数, 那么每个类型参数都可以单独的投射. 比如, 如果类型定义为interface Function<in T, out U> , 那么可以出现以下几种星号投射:

Function<*, String> , 代表 Function<in Nothing, String> ;
Function<Int, *> , 代表 Function<Int, out Any?> ;
Function<, > , 代表 Function<in Nothing, out Any?> .
 */

fun main(args: Array<String>) {
    var boxInt = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。
    var boxString = Box<String>("benio")
    println(boxInt.value)
    println(boxString.value)

    val age = 9
    val name = "Hello"
    val bool = true
    doPrintln(age)
    doPrintln(name)
    doPrintln(bool)

    val list = listOf(4, 3, 2, 1)
    sort(list)
    println(list)

    var list2 = listOf("a", "b", "c", "d", "e", "f")
    list2 = copyWhenGreater(list2, "c")
    println(list2)

    var strCo: Runoob1<String> = Runoob1("a")
    var anyCo: Runoob1<Any> = Runoob1("b")
    anyCo = strCo
    println(anyCo.foo())

    var strDCo = Runoob5<String>("a")
    var anyDCo = Runoob5<Any>("b")
    strDCo = anyDCo
    strDCo.foo("bb")
}


