package io.ajarara.permutations

private fun swap(arr: MutableList<Int>, a: Int, b: Int) {
    val tmp = arr[a]
    arr[a] = arr[b]
    arr[b] = tmp
}

fun permutations(input: List<Int>): Set<Set<Int>> {
    val out = mutableListOf<Set<Int>>()
    val scratch = input.toMutableList()
    fun helper(k: Int) {
        if (k == 1) {
            out.add(scratch.toSet())
        } else {
            // permutations where last element is held constant
            helper(k - 1)
            for (i in 0 until k - 1) {
                if (k % 2 == 0) {
                    swap(scratch, i, k - 1)
                } else {
                    swap(scratch, 0, k - 1)
                }
                helper(k - 1)
            }
        }
    }
    helper(scratch.size - 1)
    return out.toSet()
}
