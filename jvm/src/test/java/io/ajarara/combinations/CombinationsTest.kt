package io.ajarara.combinations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CombinationsTest {
    @Test
    fun ex1() {
        assertEquals(
            listOf(
                listOf(),
                listOf(1),
                listOf(2),
                listOf(1, 2),
                listOf(3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2, 3)
            ),
            allCombinationsBits(listOf(1, 2, 3))
        )
    }
}
