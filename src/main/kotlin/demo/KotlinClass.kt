package demo

/**
 * http://www.runoob.com/kotlin/kotlin-class-object.html
 */

class Runoob {
    fun foo(): Unit {
        print("Foo")
    }
}

// 空类
class Empty

class Runoob2 {
    var name = "name"
    var url = "url"
    val city = "city"
}

// Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
class Person constructor(firstName: String) {
}

// 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略
class Person2(firstName: String) {
    //var allByDefault: Int? // 错误: 需要一个初始化语句, 默认实现了 getter 和 setter 方法
    var initicalized = 1 // 类型为 Int, 默认实现了 getter 和 setter
    val simple: Int?       // 类型为 Int ，默认实现 getter ，但必须在构造函数中初始化
    val inferredType = 1   // 类型为 Int 类型,默认实现 getter
    var firstName: String = firstName

    // 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀
    // 主构造器的参数可以在初始化代码段中使用，也可以在类主体定义的属性初始化代码中使用。
    // 一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）
    init {
        simple = 2
    }
}

// https://stackoverflow.com/questions/43220140/whats-kotlin-backing-field-for/43220314
// 在 Kotlin 中，任何时候当你写出“一个变量后边加等于号”这种形式的时候，比如我们定义 var no: Int 变量，
// 当你写出 no = ... 这种形式的时候，这个等于号都会被编译器翻译成调用 setter 方法；
// 而同样，在任何位置引用变量时，只要出现 no 变量的地方都会被编译器翻译成 getter 方法。
// 那么问题就来了，当你在 setter 方法内部写出 no = ... 时，
// 相当于在 setter 方法中调用 setter 方法，形成递归，进而形成死循环
class Person3() {
    // Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制,
    // 备用字段使用field关键字声明,field 关键词只能用于属性的访问器
    var lastName: String = "zhang"
        get() = field.toUpperCase() // 后端变量
        set

    var no: Int = 100
        get
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }
    var height: Float = 145.4f
        private set
}

class Runoob3 constructor(name: String) {
    var url = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化的网站名:$siteName")
    }

    fun printTest() {
        println("我是类函数")
    }
}

// 私有构造函数
class Runoob4 private constructor(name: String) {
    var url = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化的网站名:$siteName")
    }

    // 次构造函数
    constructor(name: String, alexa: Int) : this(name) {
        println("Alexa 排名:$alexa")
    }
}

// ===============抽象类=================
//抽象是面向对象编程的特征之一，类本身，或类中的部分成员，都可以声明为abstract的。抽象成员在类中不存在具体的实现。
//注意：无需对抽象类或抽象成员标注open注解
open class Base {
    open fun f() {
    }
}

abstract class Derived : Base() {
    override abstract fun f()
}

// ===============嵌套类=================
class Outer {
    private val bar = 1

    class Nested {  // 嵌套类
        fun foo() = 2
    }

    //嵌套内部类
    inner class Inner {
        fun foo() = bar // 访问外部类成员
        fun innerTest() {
            var o = this@Outer//获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：${o.bar}")
        }
    }
}

// ======================匿名内部类=================
class AnonymousClass {
    fun setTestInterface(i: TestInterface) {
        i.test()
    }
}

// 定义接口
interface TestInterface {
    fun test()
}

// =======================类的修饰符=======================
// classModifier: 类属性修饰符，标示类本身特性。
// * abstract    // 抽象类
// * final       // 类不可继承，默认属性
// * enum        // 枚举类
// * open        // 类可继承，类默认是final的
// * annotation  // 注解类

// accessModifier: 访问权限修饰符
// private    // 仅在同一个文件中可见
// protected  // 同一个文件中或子类可见
// public     // 所有调用的地方都可见
// internal   // 同一个模块中可见

// 类中没有定义任何属性
class Constructor1(name: String) {
}

// 类中定义了 val name属性
class Constructor2(val name: String) {
}

// 类中定义了 var name属性
class Constructor3(var name: String) {
}

fun main(args: Array<String>) {
    // Kotlin 中没有 new 关键字
    val a = Runoob2()
    // 使用 . 号来引用
    println(a.name + "," + a.url + "," + a.city)

    var p = Person3()
    p.lastName = "wang"
    println("lastName:${p.lastName}")
    p.no = 9
    println("no:${p.no}")
    p.no = 10
    println("no:${p.no}")

    val runoob = Runoob3("菜鸟")
    println(runoob.siteName + "," + runoob.url + "," + runoob.country)
    runoob.printTest()

    val nestedFoo = Outer.Nested().foo()
    println(nestedFoo)

    var inner = Outer().Inner()
    println(inner.foo())
    println(inner.innerTest())

    var anonymous = AnonymousClass()
    anonymous.setTestInterface(object : TestInterface {
        override fun test() {
            println("对象表达式创建匿名内部类的实例")
        }
    })
}