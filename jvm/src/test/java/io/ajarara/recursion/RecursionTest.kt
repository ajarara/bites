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
}
