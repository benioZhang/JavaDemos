package demo

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * http://www.runoob.com/kotlin/kotlin-delegated.html
 **/

// ================类委托================
interface Printer {
    fun print()
}

// 实现此接口的被委托的类
class PrinterImpl(val x: Int) : Printer {
    override fun print() {
        println(x)
    }
}

// 通过关键字 by 建立委托类
// by表示: 将p保存在Proxy的对象实例内部，而且编译器将会生成继承自Printer接口的所有方法, 并将调用转发给p
class Proxy(p: Printer) : Printer by p

// =================属性委托==============
//属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理。
//属性委托语法格式：
//val/var <属性名>: <类型> by <表达式>
// by 关键字之后的表达式就是委托, 属性的 get() 方法(以及set() 方法)将被委托给这个对象的 getValue() 和 setValue() 方法。
// 属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)
// 定义包含属性委托的类
class Example1 {
    var p: String by Proxy1()
}

class Proxy1 {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了${property.name}属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, s: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $s")
    }
}

//========================延迟属性 Lazy====================
//lazy() 是一个函数, 接受一个 Lambda 表达式作为参数, 返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托：
//第一次调用 get() 会执行已传递给 lazy() 的 lambda 表达式并记录结果， 后续调用 get() 只是返回记录的结果
val lazyValue: String by lazy {
    println("computed") // 第一次调用输出，第二次调用不执行
    "Hello"
}

//=======================可观察属性 Observable============
class User2 {
    var name: String by Delegates.observable("none") { property, oldValue, newValue ->
        println("${property.name} 旧值：$oldValue -> 新值：$newValue")
    }
}

//======================把属性储存在映射中================
class Site3(val map: Map<String, Any?>) {
    val name: String by map
    val url: String by map //这里只能使用val属性
}

class Site4() {
    val map = mutableMapOf<String, Any?>()
    var name: String by map
    var url: String by map
}

class Site5(val map: MutableMap<String, Any?>) {
    var name: String by map
    val url: String by map//这里可以使用val/var属性
}

//======================Not Null=======================
// notNull 适用于那些无法在初始化阶段就确定属性值的场合。
class Example3 {
    var notNullProperty: String by Delegates.notNull<String>()
}

//=====================局部委托属性===================
fun test(compute: () -> Example) {
    val e by lazy(compute) // 只会在第一次访问时计算
}

fun main(args: Array<String>) {
    val p = PrinterImpl(10)
    Proxy(p).print()

    val e = Example1()
    println(e.p) // 访问该属性，调用 getValue() 函数
    e.p = "Runoob"   // 调用 setValue() 函数
    println(e.p)

    println(lazyValue)   // 第一次执行，执行两次输出表达式
    println(lazyValue)   // 第二次执行，只输出返回值

    val user = User2()
    user.name = "Ben"
    user.name = "Jack"

    val map = mapOf("name" to "百度",
            "url" to "www.baidu.com")
    val site3 = Site3(map)
    println("url:${site3.url}, name:${site3.name}")
    val site4 = Site4()
    site4.url = "www.google.com"
    site4.name = "Google"
    println(site4.map)
    var mutableMap = mutableMapOf<String, Any?>(
            "name" to "菜鸟教程",
            "url" to "www.runoob.com")
    val site5 = Site5(mutableMap)
    println("url:${site5.url}, name:${site5.name}")
    mutableMap.put("name", "百度")
    mutableMap.put("url", "www.baidu.com")
    println("url:${site5.url}, name:${site5.name}")

    val e3 = Example3()
    e3.notNullProperty = "aaa"
    println(e3.notNullProperty)
}
