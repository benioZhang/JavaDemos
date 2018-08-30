package demo

/**
 * http://www.runoob.com/kotlin/kotlin-extensions.html
 */
// 扩展函数可以在已有类中添加新的方法，不会对原类做修改，扩展函数定义形式
//fun receiverType.functionName(params){
//  body
//}
// receiverType：表示函数的接收者，也就是函数扩展的对象
// functionName：扩展函数的名称
// params：扩展函数的参数，可以为NULL

class User(var name: String)

// 构造函数不加var的话，拓展函数会找不到name。原因？
fun User.print() {
    println("用户名: $name")
}

// 扩展函数 swap,调换不同位置的值
fun <E> ArrayList<E>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}

// 扩展函数是静态解析的，并不是接收者类型的虚拟成员，
// 在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
// 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数
open class C88 {
    fun bar() {
        println("成员函数 C88#bar")
    }
}

fun C88.bar() {
    println("扩展函数 C88#bar")
}

class D88 : C88()

fun C88.foo() = "C88#foo"
fun D88.foo() = "D88#foo"
fun printFoo(c: C88) {
    println(c.foo())
}

//扩展一个空对象
//在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数
fun Any?.toString(): String {
    if (this == null) {
        return "null"
    }
    return toString()
}

// >扩展属性
// 除了函数，Kotlin 也支持属性对属性进行扩展:
// 扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。
// 初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
val <T> List<T>.lastIndex: Int
    get() = size - 1

// 伴生对象的扩展
// 如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
// 伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
class MyObject {
    companion object
}

fun MyObject.Companion.foo() {
    println("伴生对象的扩展函数")
}

val MyObject.Companion.no: Int
    get() = 10

//扩展声明为成员
//在一个类内部你可以为另一个类声明扩展。
//在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
class D77 {
    fun bar() = println("D#bar")
}

// 在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
class C77 {
    fun baz() = println("C#baz")
    fun D77.foo() {
        bar()
        baz()
    }

    fun caller(d: D77) {
        d.foo()
    }
}

// 假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先，要引用分发接收者的成员你可以使用限定的 this 语法。
class C77_2 {
    fun bar() = println("C#bar")
    fun D77.foo() {
        bar()         // 调用 D.bar()，扩展接收者优先
        this@C77_2.bar()  // 调用 C.bar()
    }

    fun caller(d: D77) {
        d.foo()
    }
}

// 以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖.
// 也就是说, 在这类扩展函数的派发过程中, 针对分发接受者是虚拟的(virtual), 但针对扩展接受者仍然是静态的
open class D66

class D661 : D66()
open class C66 {
    open fun D66.foo() {
        println("D.foo in C")
    }

    open fun D661.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D66) {
        d.foo()
    }
}

class C661 : C66() {
    override fun D66.foo() {
        println("D.foo in C1")
    }

    override fun D661.foo() {
        println("D1.foo in C1")
    }
}

fun main(args: Array<String>) {
    var user = User("Benio")
    user.print()

    val list = arrayListOf(1, 2, 3, 4, 5)
    list.swap(1, 4)
    println(list)
    println("lastIndex: ${list.lastIndex}")

    printFoo(C88())
    printFoo(D88())

    var c = C88()
    c.bar()

    var a = null
    println(a.toString())

    println("MyObject.no ${MyObject.no}")
    MyObject.foo()

    val c77 = C77()
    val d77 = D77()
    c77.caller(d77)

    val c77_2 = C77_2()
    c77_2.caller(d77)

    C66().caller(D66())
    C661().caller(D66())
    C66().caller(D661())
    C661().caller(D661())
}
