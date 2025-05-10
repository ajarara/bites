package io.ajarara.permutations

private inline fun swap(arr: Array<Int>, a: Int, b: Int) {
    val tmp = arr[a]
    arr[a] = arr[b]
    arr[b] = tmp
}

fun permutations(original: List<Int>): List<List<Int>> {
    val out = mutableListOf<List<Int>>()
    val arr = original.toTypedArray()
    fun heaps(size: Int) {
        if (size == 1) {
            out.add(arr.toList())
        } else {
            heaps(size - 1)
            for (i in 0 until size - 1) {
                if (i and 1 == 0) {
                    swap(arr, i, size - 1)
                } else {
                    swap(arr, 0, size - 1)
                }
                heaps(size - 1)
            }
        }
    }
    heaps(arr.size)
    return out
}
