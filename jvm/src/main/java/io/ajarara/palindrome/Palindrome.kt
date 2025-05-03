package io.ajarara.palindrome

fun isPalindrome(str: String): Boolean {
    for (i in 0 until str.length / 2) {
        if (str[i].lowercase() != str[str.length - i - 1].lowercase()) {
            return false
        }
    }
    return true
}


fun findLargestPalindrome(str: String): String {
    if (str.isEmpty()) {
        return ""
    }
    var largestLeftBound = 0
    var largestRightBound = 0
    
    for (i in 0 until str.length) { // "a"
        var window = 0
        while (i - window >= 0 && i + window < str.length) {
            if (str[i - window] == str[i + window]) {
                val largestLength = largestRightBound - largestLeftBound
                if (window * 2 + 1 > largestLength) {
                    largestLeftBound = i - window
                    largestRightBound = i + window
                }
                window++
            } else {
                break
            }
        }
    }
    return str.substring(largestLeftBound, largestRightBound + 1)
}
