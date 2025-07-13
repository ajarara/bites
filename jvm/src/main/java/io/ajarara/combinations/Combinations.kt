package io.ajarara.combinations

fun <T> allCombinationsBits(ls: List<T>): List<List<T>> = sequence {
    for (bitmask in 0 until (1 shl ls.size)) {
        val yielded = mutableListOf<T>()
        for (i in ls.indices) {
            if ((1 shl i) and bitmask == (1 shl i)) {
                yielded.add(ls[i])
            }
        }
        yield(yielded)
    }
}.toList()

