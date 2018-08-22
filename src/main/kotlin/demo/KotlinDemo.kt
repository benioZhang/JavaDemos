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
}

// ----------------------区间-----------------------------
