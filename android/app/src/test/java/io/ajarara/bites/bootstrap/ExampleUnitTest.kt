package io.ajarara.bites.bootstrap

import org.junit.Test

import org.junit.Assert.*
import kotlin.concurrent.thread

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun publication() {
        class B(var set: Boolean)
        class C(publish: (C) -> Unit) {

            val data = mutableMapOf(
                "key" to B(false)
            )
            init {
                publish(this)
            }

            fun init() {
                data.getValue("key").set = true
            }

            fun query() = data.getValue("key")

        }
        var myC: C? = null
        thread {
            C { myC = it }.init()
        }.join()
        assertTrue(myC!!.query().set)
    }

    @Test
    fun readHoisting() {
        class C {
            // @Volatile  // Add this to fix properly
            var proceed = false

            fun init() {
                proceed = true
            }

            fun observe(): String {
                while(!proceed) {
                    // Add some work to encourage JIT optimization
                    println("Here's some work!")
                }
                return "Done!"
            }
        }

        repeat(1000) {  // Run many times
            val c = C()
            var obtained: String? = null
            val t1 = thread { obtained = c.observe() }
            Thread.sleep(10)  // Ensure t1 is in the loop
            val t2 = thread { c.init() }
            t2.join()
            t1.join(100)  // Shorter timeout
            if (obtained != "Done!") {
                println("FAILED on iteration $it")  // You might see this eventually
                return
            }
        }
    }
}