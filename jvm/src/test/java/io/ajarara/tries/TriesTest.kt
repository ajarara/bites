package io.ajarara.tries

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class TriesTest {
    @Test
    fun ex1() {
        assertTrue(wordBreak("neetcode", listOf("neet", "code")))
    }

    @Test
    fun ex2() {
        assertTrue(wordBreak("applepenapple", listOf("apple", "pen", "ape")))
    }

    @Test
    fun ex3() {
        // assertFalse(wordBreak("catsincars", listOf("cats", "cat", "sin", "in", "car")))
    }
}
