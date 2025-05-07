package io.ajarara.recursion

fun ipAddress(
    s: String
): Set<String> {
    if (s.isEmpty() || s.any { it.digitToIntOrNull() == null }) {
        // no valid addresses
        return setOf()
    }
    val out = mutableSetOf<String>()

    fun recur(i: Int, octets: List<String>) {
        if (octets.size == 4) {
            if (i == s.length) {
                out.add(octets.joinToString("."))
            }
            return 
        }

        // 1, 2, 3 digits
        // we wanna make sure no leading zeros
        // the new octet is under 256
        for (j in (i + 1)..Math.min(s.length, i + 3)) {
            val sub = s.substring(i, j)
            if (sub.startsWith("0") && j != i + 1) {
                break
            }
            val maybeOctet = sub.toInt()
            if (maybeOctet < 256) {
                val newOctets = mutableListOf<String>()
                newOctets.addAll(octets)
                newOctets.add(sub)
                recur(j, newOctets)
            }
        }
    }
    recur(0, listOf())
    
    return out
}
