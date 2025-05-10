package io.ajarara.permutations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PermutationsTest {
    @Test
    fun ex1() {
        assertEquals(
            listOf(
                listOf(1,2,3),
                listOf(2,1,3),
                listOf(3,1,2),
                listOf(1,3,2),
                listOf(2,3,1),
                listOf(3,2,1)
            ),
            permutations(listOf(1, 2, 3))
        )
            
    }
}
