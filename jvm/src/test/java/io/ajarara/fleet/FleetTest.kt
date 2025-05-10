package io.ajarara.fleet

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FleetTest {
    @Test
    fun ex1 () {
        assertEquals(
            1,
            carFleet(10, intArrayOf(1, 4), intArrayOf(3, 2)))
    }

    @Test
    fun ex2 () {
        assertEquals(
            3,
            carFleet(10, intArrayOf(4, 1, 0, 7), intArrayOf(2, 2, 1, 1)))
    }

    @Test
    fun ex3 () {
        assertEquals(
            6,
            carFleet(10, intArrayOf(8, 3, 7, 4, 6, 5), intArrayOf(4, 4, 4, 4, 4, 4)))
    }
}
