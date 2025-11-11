package io.ajarara.bites.bootstrap

import androidx.core.util.lruCache
import org.jetbrains.lincheck.datastructures.IntGen
import org.jetbrains.lincheck.datastructures.Operation
import org.jetbrains.lincheck.datastructures.Param
import org.jetbrains.lincheck.datastructures.StressOptions
import org.junit.Test
import kotlin.random.Random

class Counter {
    @Volatile
    private var value = 0

    fun inc(): Int = ++value
    fun get() = value
}

class LincheckUnitTest {

    private val c = Counter()

    @Operation
    fun inc() = c.inc()

    @Operation
    fun get() = c.get()

    @Test
    fun stressTest() = StressOptions().check(this::class)
}

class Publisher(publish: (Publisher) -> Unit) {
    var observed: String = "unobserved"

    init {
        publish(this)
    }

    fun init(): String {
        observed = "observed"
        return observed
    }
}
class LincheckPublicationTest {

    var publisher: Publisher? = null

    @Operation
    fun create() {
        Publisher { publisher = it }
    }

    @Operation
    fun init() = publisher?.init()

    @Operation
    fun observe() = publisher?.observed

    // I don't trust this, it failed once and then never again.
    @Test
    fun stressTest() = StressOptions().check(this::class)
}

class LRUSequentialCache<K, V>(
    private val maxSize: Int,
    private val fetch: (K) -> V
) {
    private val cache = mutableMapOf<K, Pair<Long, V>>()

    fun get(k: K): V = synchronized(cache) {
        val highest = cache.values.maxOfOrNull { it.first } ?: -1L
        val obtained = cache.computeIfAbsent(k) {
            val value = fetch(k)
            highest + 1 to value
        }

        for ((key, value) in cache) {
            val generation = value.first
            if (generation < highest - maxSize) {
                cache.remove(key)
            }
        }
        return obtained.second
    }
}

@Param(name = "key", gen = IntGen::class, conf = "1:15")
class LincheckLRUSequentialCacheTest {
    private val lruCache = LRUSequentialCache<Int, Int>(10) {
        var hs = it.hashCode()
        repeat(it) {
            hs = hs.hashCode()
        }
        hs
    }

    @Operation
    fun store(@Param(name = "key") key: Int) = lruCache.get(key)

    @Test
    fun stressTest() = StressOptions().iterations(1000).check(this::class)
}
