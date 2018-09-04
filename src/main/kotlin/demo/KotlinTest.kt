package demo

/**
 * https://hltj.gitbooks.io/kotlin-reference-chinese/content/
 */

// 在实例初始化期间，初始化块按照它们出现在类体中的顺序执行，与属性初始化器交织在一起
class InitOrderDemo(name: String) {
    init {
        println("First initializer block that prints $name")
    }

    val firstProperty = "First property: $name".also(::println)
    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

// 声明属性以及从主构造函数初始化属性
class Person1(val firstName: String, val lastName: String, var age: Int)

// 初始化块中的代码会成为主构造函数的第一条语句
class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

// 构造函数默认可见性是public
class DontCreate private constructor() {
}


private open class BaseClass {
    open val a = 1
    open val b = 2
    open fun foo() {
        println("Base foo")
    }
}

private open class BaseClassImpl : BaseClass() {
    // 禁止再次覆盖
    final override val a = 2
    override val b = super.b

    final override fun foo() {
        super.foo()
    }
}

// ================派生类初始化顺序==============
// 基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
// 如果在基类初始化逻辑中（直接或通过另一个覆盖的 open 成员的实现间接）使用了任何一个这种属性，
// 那么都可能导致不正确的行为或运行时故障。
// 设计一个基类时，应该避免在构造函数、属性初始化器以及 init 块中使用 open 成员
private open class BaseClass1(val name: String) {
    init {
        println("Initializing Base")
    }

    open val size = name.length.also { println("Initializing size in Base : $it") }
}

private class DerivedClass1(name: String, val lastName: String)
    : BaseClass1(name.capitalize().also { println("Argument for Base $it") }) {
    init {
        println("Initializing Derived")
    }

    override val size: Int
            = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

// 调用超类实现
private class BaseClassImpl2 : BaseClass() {
    override val a = 10

    override fun foo() {
        super.foo()
        println("Impl foo")
    }

    inner class Inner {
        fun f() {
            super@BaseClassImpl2.foo() //调用BaseClass的foo方法
            println("a: $a ,super.a: ${super@BaseClassImpl2.a}")
        }
    }
}

fun main(args: Array<String>) {
    val a1 = Array(5, { i: Int -> i * i })
    a1.forEach { println(it) }

    InitOrderDemo("hello")

    Constructors(1)

    DerivedClass1("hello", "world")

    BaseClassImpl2().Inner().f()
}