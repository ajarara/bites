package io.ajarara.strings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class StringsTest {
    @Test
    fun `empty`() {
        harness(listOf())
    }

    @Test
    fun `empty string`() {
        harness(listOf(""))
    }

    @Test
    fun `multiple strings`() {
        harness(listOf("asdf", "fdsa"))
    }

    @Test
    fun `empty string wrapped`() {
        harness(listOf("asdf", ""))
    }

    @Test
    fun `sigil + empty string`() {
        harness(listOf("#", "", "#"))
    }

    @Test
    fun `sigil`() {
        harness(listOf("#"))
    }

    @Test
    fun `sigil with empty string`() {
        harness(listOf("#", "", "#"))
    }

    fun harness(ls: List<String>) {
        assertEquals(
            ls,
            decode(encode(ls))
        )
    }
}
