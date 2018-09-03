package demo

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * http://www.runoob.com/kotlin/kotlin-object-declarations.html
 */

// 通过对象表达式实现一个匿名内部类的对象用于方法的参数中
// Kotlin 用对象表达式和对象声明来实现创建一个对某个类做了轻微改动的类的对象，且不需要去声明一个新的子类。
fun test(window: JComponent) {
    // 在对象表达中可以方便的访问到作用域中的其他变量:
    var clickCount = 0
    var enterCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            super.mouseClicked(e)
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent?) {
            super.mouseEntered(e)
            enterCount++
        }
    })
}

open class A11(x: Int) {
    public open val y: Int = x
}

interface B11 {
}

fun test2(): Unit {
    val ab = object : A11(1), B11 {
        override val y = 15
    }
}

/*
请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。
如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，那么该函数或属性的实际类型会是匿名对象声明的超类型，
如果你没有声明任何超类型，就会是 Any。在匿名对象 中添加的成员将无法访问。
 */
class C11 {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x = "x"
    }

    fun bar() {
        val x1 = foo().x
        //val x2 = publicFoo().x // 错误：未能解析的引用“x”
    }
}

// 对象声明 Kotlin 使用 object 关键字来声明一个对象。通过对象声明可以获得一个单例
object Site {
    var url: String = ""
    var name: String = "菜鸟"
}

class Site2 {
    var name = "菜鸟"

    object DeskTop {
        val url = "www.runoob.com"
        fun showName() {
            //println("desk legs $name") // 错误，不能访问到外部类的方法和变量
        }
    }
}

// 伴生对象
// 类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素
// 可以省略掉该对象的对象名，然后使用 Companion 替代需要声明的对象名
// 注意：一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次
// 伴生对象的成员看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员
class MyClass {
    val x = 10

    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

class MyClass2 {
    val x = 10

    companion object {
    }
}

interface Factory<T> {
    fun create(): T
}

class MyClass3 {
    companion object : Factory<MyClass3> {
        override fun create(): MyClass3 = MyClass3()
    }
}

fun main(args: Array<String>) {
    val site = object {
        var name: String = "菜鸟教程"
        var url: String = "www.runoob.com"
    }
    println("${site.name}, ${site.url}")

    val s1 = Site
    val s2 = Site
    s1.url = "www.baidu.com"
    println(s1.url)
    println(s2.url)

    var site2 = Site2()
    //println(site2.DeskTop.url)// 错误，不能通过外部类的实例访问到该对象
    println(Site2.DeskTop.url)// 正确

    val instance = MyClass.create() // 访问到对象的内部元素
    val instance2 = MyClass2.Companion
    val instance3 = MyClass3.create()
}