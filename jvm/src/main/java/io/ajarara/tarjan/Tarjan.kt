package io.ajarara.tarjan

import java.util.LinkedHashSet;

fun <T: Any> tarjan(adj: Map<T, List<T>>): List<Set<T>> {
    val out = mutableListOf<Set<T>>()
    val indices = mutableMapOf<T, Int>()
    val lowlinks = mutableMapOf<T, Int>()
    val stack = LinkedHashSet<T>()
    var idx = 0

    fun strongConnect(node: T) {
        if (node in indices) {
            return
        }
        indices[node] = idx
        lowlinks[node] = idx
        stack.add(node)
        idx++

        for (neighbor in adj[node] ?: listOf()) {
            strongConnect(neighbor)

            if (stack.contains(neighbor)) {
                lowlinks[node] = Math.min(
                    lowlinks.getValue(node),
                    lowlinks.getValue(neighbor)
                )
            }
        }

        if (indices[node] == lowlinks[node]) {
            val scc = mutableSetOf<T>()
            lateinit var v: T
            do {
                v = stack.removeLast()
                scc.add(v)
            } while (v != node && stack.isNotEmpty())
            out.add(scc)
        }
    }

    adj.keys.forEach(::strongConnect)

    return out
}
