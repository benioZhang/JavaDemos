import demo.Runoob
import org.junit.Before
import org.junit.Test

class MyTest {
    lateinit var subject: Runoob

    @Before
    fun setup() {
        subject = Runoob()
    }

    @Test
    fun test() {
        subject.foo()  // dereference directly
    }
}