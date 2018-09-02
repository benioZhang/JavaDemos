package demo

/**
 * http://www.runoob.com/kotlin/kotlin-enum-classes.html
 */
// 枚举常量用逗号分隔,每个枚举常量都是一个对象
enum class Color {
    RED, BLACK, BLUE, GREEN, WHITE;
}

enum class Color2(val rgb: Int) {
    RED(0xff0000),
    GREEN(0x00ff00),
    BLUE(0x0000ff)
}

// 枚举还支持以声明自己的匿名类及相应的方法、以及覆盖基类的方法
enum class ProtocolState {
    WAITING {
        override fun signal(): ProtocolState = TALKING

    },
    TALKING {
        override fun signal(): ProtocolState = WAITING
    };

    abstract fun signal(): ProtocolState
}

enum class RGB {
    RED, GREEN, BLUE;
}

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

fun main(args: Array<String>) {
    var color = Color.BLUE
    println(Color.values())
    println(Color.valueOf("RED"))
    //ordinal: 枚举值在所有枚举数组中定义的顺序
    println(color.name + "," + color.ordinal)

    printAllValues<Color>()
    println()
    printAllValues<RGB>()
}