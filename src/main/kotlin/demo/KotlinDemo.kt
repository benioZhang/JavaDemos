package demo

/**
 * http://www.runoob.com/kotlin/kotlin-tutorial.html
 */
fun main(args: Array<String>) {
    println("Hello world! ")
    printVars(1, 2, 3)
    testLambda()
    testString()
    testParseInt()
    testRange()
    compareNumber()
    bitOperator()
    println(decimalDigitValue('9'))
    testArray()
    testString2()
    testStringTemplate()
    testIF()
    testRange2()
    testWhen()
    testFor()
    testLabel()
}

// ------------------函数定义-----------------
// 函数定义使用关键字 fun，参数格式为：参数 : 类型
fun sum(a: Int, b: Int): Int {// Int 参数，返回值 Int
    return a + b
}

// 表达式作为函数体，返回类型自动推断
fun sum2(a: Int, b: Int) = a + b

public fun sum3(a: Int, b: Int): Int = a + b // public 方法则必须明确写出返回类型
public fun sum4(a: Int, b: Int) = a + b // 不写也没错？

// 无返回值的函数(类似Java中的void)
fun printSum(a: Int, b: Int): Unit {
    print(a + b)
}

public fun printSum2(a: Int, b: Int) {
    print(a + b)
}

//函数的变长参数可以用 vararg 关键字进行标识
fun printVars(vararg v: Int) {
    for (i in v) {
        print(i)
    }
}

// lambda(匿名函数)
fun testLambda() {
    val sumLambda: (Int, Int) -> Int = { a, b -> a + b }
    println(sumLambda(1, 2))
}
// ------------------函数定义-----------------


// ------------------定义常量与变量------------
//可变变量定义：var 关键字
//var <标识符> : <类型> = <初始化值>
//不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
//val <标识符> : <类型> = <初始化值>
fun defineVar(): Unit {
    val a: Int = 1
    val b = 1 // 系统自动推断变量类型为Int
    val c: Int // 如果不在声明时初始化则必须提供变量类型
    c = 1 // 明确赋值

    var x = 5 // 系统自动推断变量类型为Int
    x += 1 // 变量可修改
}
// ------------------定义常量与变量------------


// ------------------注释------------
// 这是一个单行注释

/* 这是一个多行的
   块注释。 */
// ------------------注释------------


// ------------------字符串模板------------
/*
 * $ 表示一个变量名或者变量值
 * $varName 表示变量值
 * ${varName.fun()} 表示变量的方法返回值:
 */
fun testString(): Unit {
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s1)
    println(s2)
}
// ------------------字符串模板------------


// ------------------NULL检查机制--------------
fun testNULL(): Unit {
    //类型后面加?表示可为空
    var age: String? = "23"
    var age2: String?
    //抛出空指针异常
    val age3 = age!!.toInt()
    //不做处理返回 null
    val age4 = age?.toInt()
    // age为空返回-1
    var age5 = age?.toInt() ?: -1
}

//当一个引用可能为 null 值时, 对应的类型声明必须明确地标记为可为 null。
//当 str 中的字符串内容不是一个整数时, 返回 null:
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun testParseInt() {
    val a = parseInt("1")
    val b = parseInt("2")
    val c = parseInt("abc")
    // 直接使用 `a * b` 会导致错误, 因为它们可能为 null.
    // 而且IDE也会提示type mismatch
    if (a != null && b != null) {
        // 在进行过 null 值检查之后, x 和 y 的类型会被自动转换为非 null 变量
        println("a * b = " + (a * b))
    }
    println("c = " + c)
}
// ------------------NULL检查机制--------------


// ------------------类型检测及自动类型转换--------------
//使用 is 运算符检测一个表达式是否某类型的一个实例(类似于Java中的instanceof关键字)。
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }
    return null
}

fun getStringLength2(obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}

fun getStringLength3(obj: Any): Int? {
    // 在 `&&` 运算符的右侧, `obj` 的类型会被自动转换为 `String`
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}
// ------------------类型检测及自动类型转换--------------


// ----------------------区间-----------------------------
// 区间表达式由具有操作符形式 .. 的 rangeTo 函数辅以 in 和 !in 形成。
fun testRange() {
    for (i in 1..4) {
        print(i) // 输出“1234”
    }
    println("\n-----")
    for (i in 4..1) {
        print(i) // 什么都不输出
    }
    println("\n-----")
    for (i in 1..4 step 2) {
        print(i) // 输出“13”
    }
    println("\n-----")
    for (i in 4 downTo 1 step 2) {
        print(i) // 输出“42”
    }
    println("\n-----")
    for (i in 1 until 10) { // i in [1, 10) 排除了 10
        print(i)
    }
    println("\n")
}
// ----------------------区间-----------------------------

// ----------------------字面常量-----------------------------
fun testConstant() {
    // 十进制：123
    val a = 123
    // 长整型以大写的 L 结尾：123L
    val b = 123L
    // 16 进制以 0x 开头：0x0F
    val c = 0x0F
    // 2 进制以 0b 开头：0b00001011
    val d = 0b001001
    // 注意：8进制不支持
    // Kotlin 同时也支持传统符号表示的浮点数值：
    val e = 12345e10
    val f = 123.45f
    val oneMillion = 1_000_000
    val creditNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_FF_DC
    val bytes = 0b10101010_10101111
}
// ----------------------字面常量-----------------------------


// ----------------------比较两个数字-----------------------------
// Kotlin 中没有基础数据类型，只有封装的数字类型
// 三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小
private fun compareNumber() {
    val a = 10000
    println(a === a) // true，值相等，对象地址相等
    //经过了装箱，创建了两个不同的对象
    val b: Int? = a // 显式声明才算封箱，val b = a只是将a的地址赋值给b
    val c: Int? = a
    //虽然经过了装箱，但是值是相等的，都是10000
    println(b === c) //  false，值相等，对象地址不一样
    println(b == c) // true，值相等

    var d: Int? = 127
    var e: Int? = 127
    var f: Int = 128
    var g: Int = 128
    var h: Int? = 128
    var i: Int? = 128
    println(d === e) // true Integer会缓存[-128,127]的实例
    println(f === g) // true 为什么？----查看class文件发现，f和g并没有装箱！！
    println(h === i) // false
}
// ----------------------比较两个数字-----------------------------


// --------------------------类型转换------------------------------
fun typeTransform() {
    val b: Byte = 1 // OK, 字面值是静态检测的
    //val i: Int = b // 错误
    val i: Int = b.toInt() // OK
    val j = 1L + 3 // Long + Int => Long
}
// --------------------------类型转换------------------------------

// --------------------------位操作符------------------------------
// 对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
fun bitOperator() {
    val a = 9
    println(a shl 1) //左移位 (Java’s <<)
    println(a shr 1) //右移位 (Java’s >>)
    println(-10 ushr 1) //无符号右移位 (Java’s >>>)
    println(a and 3)
    println(a or 3)
    println(a xor 3)
    println(1.inv())// 反向
}
// --------------------------位操作符------------------------------


// --------------------------字符------------------------------
fun check(c: Char): Unit {
    /*if (c == 1) {// 错误：类型不兼容

    }*/
    if (c == '1') {
    }
}

fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9') {
        throw IllegalArgumentException("Out of range")
    }
    return c.toInt() - '0'.toInt()
}
// --------------------------字符------------------------------


// --------------------------布尔------------------------------
/*
 * 布尔用 Boolean 类型表示，它有两个值：true 和 false。
 * 若需要可空引用布尔会被装箱。内置的布尔运算有：
 * || – 短路逻辑或
 * && – 短路逻辑与
 * ! - 逻辑非
 */
// --------------------------布尔------------------------------


// --------------------------数组------------------------------
fun testArray() {
    //[1,2,3,4]
    val a = arrayOf(1, 2, 3, 4)
    //[0,2,4]
    val b = Array(3, { i -> i * 2 })
    println(a[0])
    println(b[0])

    // [] 运算符代表调用成员函数 get() 和 set()。
    // 注意: 与 Java 不同的是，Kotlin 中数组是不型变的（invariant）。
    // 除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高
    val c: IntArray = intArrayOf(1, 2, 3)
    c[0] = c[1] + c[2]
    println(c[0])
}
// --------------------------数组------------------------------


// --------------------------字符串------------------------------
fun testString2() {
    val str = "abcdef"
    for (s in str) {
        print(s)
    }
    println()
    for (i in 0..str.length - 1) {
        print(str[i])
    }
    println()

    var multiLineStr = """
        多行字符串
        多行字符串
        """
    println(multiLineStr)
    multiLineStr = """
    |多行字符串
    |菜鸟教程
    |多行字符串
    |Runoob
    """
    // 默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    println(multiLineStr.trimMargin()) // 前置空格删除了
}
// --------------------------字符串------------------------------


// --------------------------字符串模板------------------------------
fun testStringTemplate() {
    var i = 10
    val s = "i is $i"
    println(s)

    val m = "abcdef"
    val n = "$m.length is ${m.length}"
    println(n)

    //字符串中显示 $ 字符（它不支持反斜杠转义）
    val price = "${'$'}9.9"
    println(price)
}
// --------------------------字符串模板------------------------------

// --------------------------IF 表达式-------------------------------
fun testIF(): Unit {
    val a = 1
    val b = 2
    // 作为表达式
    val max = if (a > b) a else b
    val max2 = if (a > b) {
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }
}
// --------------------------IF 表达式-------------------------------


// --------------------------使用区间-------------------------------
fun testRange2() {
    val x = 5
    val y = 9
    if (x in 0..y) {
        println("x:$x is in 0..$y")
    }
}
// --------------------------使用区间-------------------------------

// --------------------------When 表达式-------------------------------
fun testWhen(): Unit {
    //when 类似其他语言的 switch 操作符
    val x = 1
    when (x) {
        1 -> println("x == 1")
        1, 3 -> println("x == 1 || x == 3")
        2 -> {
            println("x == 2")
        }
        else -> { // 注意这个块
            println("x != 1 && x != 2 ")
        }
    }

    // 多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔
    when (x) {
        0, 1 -> println("x == 0 || x == 1")
        else -> println("x != 0 && x != 1 ")
    }

    // 检测一个值在（in）或者不在（!in）一个区间或者集合中
    val validNumbers = arrayOf(1, -1, -2, -3)
    when (x) {
        in validNumbers -> println("x is valid")
        in 0..10 -> println("x is in 0..10")
        !in 10..20 -> println("x is not in 10..20")
        else -> println("none of the above")
    }

    /// 检测一个值是（is）或者不是（!is）一个特定类型的值
    val a = "prefiaaaaa"
    println("$a starts with prefix: ${hasPrefix(a)}")

    val b = "abababab"
    val pre = "aba"
    println("$b starts with prefix $pre : ${hasPrefix(b, pre)}")

    // when 也可以用来取代 if-else if链。
    // 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支
    when {
        x % 2 != 0 -> println("x is odd")
        x % 2 == 0 -> println("x is even")
        else -> println("x is funny")
    }

    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

fun hasPrefix(x: Any) = when (x) {
    is String -> x.startsWith("prefix")
    else -> false
}

fun hasPrefix(x: Any, p: String) = x is String && x.startsWith(p)
// --------------------------When 表达式-------------------------------


// --------------------------For 循环-------------------------------
// for 循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下:
// for (item in collection) print(item)
// 循环体可以是一个代码块:
// for (item: Int in ints) {
//      ……
// }
// 如果你想要通过索引遍历一个数组或者一个 list
// for (i in array.indices) {
//      print(array[i])
// }
// 注意这种"在区间上遍历"会编译成优化的实现而不会创建额外对象。 或者你可以用库函数 withIndex
// for ((index, value) in array.withIndex()) {
//      println("the element at $index is $value")
// }
//
fun testFor(): Unit {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}
// --------------------------For 循环-------------------------------


// --------------------------while 与 do...while 循环-------------------------------
fun TestWhile(): Unit {
    val b = true
    while (b) {

    }
    do {

    } while (b)
}
// --------------------------while 与 do...while 循环-------------------------------

// --------------------------返回和跳转---------------------------------------
/*
 * return。默认从最直接包围它的函数或者匿名函数返回。
 * break。终止最直接包围它的循环。
 * continue。继续下一次最直接包围它的循环。
 */
fun testBreakAndContinue(): Unit {
    for (i in 1..10) {
        if (i == 3) continue
        println(i)
        if (i > 5) break
    }
}
// --------------------------返回和跳转---------------------------------------


// --------------------------Break 和 Continue 标签--------------------------
// 在 Kotlin 中任何表达式都可以用标签（label）来标记。
// 标签的格式为标识符后跟 @ 符号，例如：abc@、fooBar@都是有效的标签。
// 要为一个表达式加标签，我们只要在其前加标签即可
fun testLabel(): Unit {
    loop@ for (i in 1..10) {
        print("i:$i ")
        for (j in 1..10) {
            if (i > 3) break@loop
            print(" j:$j ")
        }
        println()
    }
}

fun foo() {
    val ints = intArrayOf(-1, -2, 0, 1)
    //  如果我们需要从 lambda 表达式中返回，我们必须给它加标签并用以限制 return
    ints.forEach lit@ {
        if (it == 0) {
            return@lit
        }
        print(it)
    }

    // 现在，它只会从 lambda 表达式中返回。通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名。
    ints.forEach {
        if (it == 0) {
            return@forEach
        }
        print(it)
    }

    // 或者，我们用一个匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回
    ints.forEach(fun(v: Int) {
        if (v == 0) {
            return
        }
        print(v)
    })

    // 当要返一个回值的时候，解析器优先选用标签限制的 return，即 return@a 1
    // 意为"从标签 @a 返回 1"，而不是"返回一个标签标注的表达式 (@a 1)"。
}

// --------------------------Break 和 Continue 标签--------------------------
