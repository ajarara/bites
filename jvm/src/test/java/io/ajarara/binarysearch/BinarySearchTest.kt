package io.ajarara.binarysearch

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BinarySearchTest {

    // @Test
    fun ex1 () {
        assertEquals(
            1,
            rotated(listOf(3, 4, 5, 6, 1, 2))
        )
    }

    // @Test
    fun ex2 () {
        assertEquals(
            0,
            rotated(listOf(4, 5, 0, 1, 2, 3))
        )
    }

    // @Test
    fun ex3 () {
        assertEquals(
            4,
            rotated(listOf(4, 5, 6, 7))
        )
    }

    @Test
    fun timemapEx1 () {
        val map = TimeMap()
        map.set("alice", "happy", 1)
        assertEquals(
            "happy"
            map.get("alice", 1)
        )
        assertEquals(
            "happy"
            map.get("alice", 2)
        )
        map.set("alice", "sad", 3)
        assertEquals(
            "sad",
            map.get("alice", 3)
        )
    }
}
