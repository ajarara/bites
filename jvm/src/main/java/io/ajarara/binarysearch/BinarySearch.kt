package io.ajarara.binarysearch

fun rotated(ls: List<Int>): Int {
    var l = 0
    var r = ls.size - 1
    while (l < r) {
        val pivot: Int = (r - l) / 2
        if (ls[l] < ls[r]) {
            // we found the minimum, it's l
            r = l
        } else if (ls[pivot] < ls[l]) {
            // min is between pivot and left
            r = pivot
        } else if (ls[pivot] < ls[r]) {
            // ditto
            r = pivot
        } else {
            l = pivot
        }
        println("$l, $r, $pivot")
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
