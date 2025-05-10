package io.ajarara.tries

private class Trie : MutableMap<Char?, Trie> by mutableMapOf() {
    fun addWord(s: String) {
        addWord(s, 0)
    }

    private fun addWord(s: String, i: Int) {
        if (i == s.length) {
            set(null, Trie())
        } else {
            val child = Trie()
            child.addWord(s, i + 1)
            set(s[i], child)
        }
    }

    fun hasWord(s: String, base: Int, offset: Int): Boolean {
        val i = base + offset
        if (i == s.length) {
            return null in this
        } else {
            val child = get(s[i])
            return child?.hasWord(s, base, i + 1) ?: false
        }
    }
}


fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val t = Trie()
    for (word in wordDict) {
        t.addWord(word)
    }

    
    
    return true
}


