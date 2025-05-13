package io.ajarara.binarysearch

fun simple(ls: List<Int>, target: Int): Int {
    if (ls.isEmpty()) {
        return -1
    }
    var l = 0
    var r = ls.size - 1
    while (l <= r) {
        val mid = (l + r) / 2
        val guess = ls[mid]

        if (guess == target) {
            return mid
        } else if (guess < target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }
    return -1
}

// returns the minimum in the rotated sorted array
fun rotated(ls: List<Int>): Int {
    check(ls.isNotEmpty()) {
        "impossible to return an answer"
    }
    var l = 0
    var r = ls.size - 1
    while (l < r) {
        val mid: Int = (l + r) / 2
        println("$l, $mid, $r")
        
        if (ls[l] < ls[r]) {
            return ls[l]
        } else if (ls[l] < ls[mid] || ls[mid] > ls[r]) {
            // then the pivot must be between mid and r
            if (mid == l) {
                l++
            } else {
                l = mid + 1
            }
        } else {
            r = mid
        }
    }
    return ls[l]
}


class TimeMap {
    fun set(key: String, value: String, timestamp: Int) {
            
    }

    fun get(key: String, timestamp: Int): String {
            return ""
        }
}
