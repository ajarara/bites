package io.ajarara.permutations

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PermutationsTest {
    @Test
    fun ex1() {
        assertEquals(
            setOf(
                setOf(1,2,3),
                setOf(1,3,2),
                setOf(2,1,3),
                setOf(2,3,1),
                setOf(3,1,2),
                setOf(3,2,1)
            ),
            permutations(listOf(1, 2, 3))
        )
            
    }
}
