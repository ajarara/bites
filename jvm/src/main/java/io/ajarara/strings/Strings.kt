package io.ajarara.strings

fun encode(ls: List<String>): String {
    return ls.map { it -> "${it.length}#$it" }.joinToString("")
}

fun decode(s: String): List<String> {
    val out = mutableListOf<String>()
    var idx = 0
    while (idx < s.length) {
        val rb = s.indexOf("#", idx)
        val encodedLength = s.substring(idx, rb)
        val nextTokenLength =  encodedLength.toInt()
        idx = rb + 1
        val decoded = s.substring(idx, idx + nextTokenLength)
        
        println("ahmad, idx: $idx, nextTokenLength: $nextTokenLength, decoded: $decoded")
        out.add(decoded)
        idx += nextTokenLength
    }
    return out
}
