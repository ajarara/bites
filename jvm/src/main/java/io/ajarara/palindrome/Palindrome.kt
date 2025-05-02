package io.ajarara.palindrome

fun isPalindrome(str: String): Boolean {
    for (i in 0 until str.length / 2) {
        if (str[i].lowercase() != str[str.length - i - 1].lowercase()) {
            return false
        }
    }
    return true
}

