package io.ajarara.quirks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MethodReferencesTest {

    // @Test
    fun `simple case`() {
        val map = mutableMapOf<Int, MutableSet<Int>>()

        val set1 = map.computeIfAbsent(1, ::mutableSetOf)
        val set2 = map.computeIfAbsent(2, ::mutableSetOf)

        check(set1 === set2)
    }
}
