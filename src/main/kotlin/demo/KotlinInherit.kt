package demo

/**
 * http://www.runoob.com/kotlin/kotlin-extend.html
 **/
class Example  // 从 Any 隐式继承
// Any 提供的函数
// equals()
// hashCode()
// toString()

// 注意：Any 不是 java.lang.Object。
// 如果一个类要被继承，可以使用 open 关键字进行修饰。
open class Base1(p: Int)

class Derived1(p: Int) : Base1(p)

// 子类有主构造函数
open class Person8(name: String, age: Int) {
    val name: String = name
    var age: Int = age
}

class Student1(name: String, age: Int, no: String, score: Int) : Person8(name, age) {
    val no = no
    var score = score
}

// 子类没有主构造函数
open class Person9(name: String) {
    constructor(name: String, age: Int) : this(name) {
        println("-------基类次级构造函数---------")
    }
}

class Student2 : Person9 {

    constructor(name: String, age: Int, no: String, score: Int) : super(name, age) {
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

// 在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
// 如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词
open class A {
    open fun print() {
        println("print from A")
    }
}

class B : A() {
    override fun print() {
        println("print from B")
    }
}

interface C {
    fun print() {
        println("print from C")
    }
}

class D : A(), C {
    override fun print() {
        super<A>.print() //调用 A.print()
        super<C>.print() //调用 C.print()
    }
}

// 属性重写
// 一个var属性可以重写一个val属性，但是反过来不行
open class Foox {
    open val x: Int = 1
}

class Bar1 : Foox() {
    override var x: Int = 2
}

fun main(args: Array<String>) {
    var stu = Student1("Ben", 18, "S12345", 80)
    println("stu name = ${stu.name}, age = ${stu.age}, no = ${stu.no}, score = ${stu.score}")

    var s = Student2("Ben", 18, "S12345", 89)

    val b = B()
    b.print()

    val d = D()
    d.print()
}
