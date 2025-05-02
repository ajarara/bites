package io.ajarara.palindrome

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PalindromeTest {
    @Test
    fun `empty case`() {
        assertTrue(isPalindrome(""))
    }

    @Test
    fun `odd`() {
        assertTrue(isPalindrome("racecar"))
        assertFalse(isPalindrome("raclcer"))
    }

    @Test
    fun `even`() {
        assertTrue(isPalindrome("dood"))
        assertFalse(isPalindrome("wood"))
    }

    @Test
    fun `casing`() {
        assertTrue(isPalindrome("Racecar"))
        assertFalse(isPalindrome("Wood"))
    }
    
}
