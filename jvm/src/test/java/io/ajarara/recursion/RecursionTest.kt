package io.ajarara.recursion

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RecursionTest {
    @Test
    fun `single soln`() {
        assertEquals(
            setOf("0.0.0.0"),
            ipAddress("0000")
        )
    }

    @Test
    fun `multi soln`() {
        assertEquals(
            setOf(
                "12.1.2.1",
                "1.21.2.1",
                "1.2.12.1",
                "1.2.1.21",
            ),
            ipAddress("12121"),
        )
    }

    @Test
    fun `empty soln`() {
        assertEquals(
            setOf<String>(),
            ipAddress(""),
        )
    }

    @Test
    fun `invalid answer`() {
        assertEquals(
            setOf<String>(),
            ipAddress("1234a54"),
        )
    }

    @Test
    fun `cme on diff keys`() {
        val c = mutableMapOf<Int, Unit>()
        fun recur(key: Int) { 
            c.compute(key) { k, v ->
                when(key) {
                    0 -> recur(key + 1)
                    else -> null
                }
                Unit
            }
        }
        recur(0)
        assertEquals(c, mapOf(0 to Unit, 1 to Unit))
    }
}
