package demo

/**
 * http://www.runoob.com/kotlin/kotlin-interface.html
 */

// Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现
interface MyInterface {
    // 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值
    var name: String

    fun bar() // 未实现
    fun foo() { //已实现
        println("fun foo")
    }
}

class MyInterfaceImpl : MyInterface {
    // 实现接口时，必须重写属性
    override var name: String = "impl"

    override fun bar() {
        println("fun bar")
    }

    override fun foo() {
        super.foo()
        println("fun foo from implement")
    }
}

interface A99 {
    fun foo() = println("A#foo")
    fun bar()
}

interface B99 {
    fun foo() = println("B#foo")
    fun bar() = println("B#bar")
}

class C99 : A99 {
    override fun bar() {
        println("C#bar")
    }
}

class D99 : A99, B99 {
    override fun foo() {
        super<A99>.foo()
        super<B99>.foo()
    }

    override fun bar() {
        super<B99>.bar()
    }
}

fun main(args: Array<String>) {
    var interf = MyInterfaceImpl()
    interf.bar()
    interf.foo()
    println("interface.name : ${interf.name}")

    var d = D99()
    d.bar()
    d.foo()
}