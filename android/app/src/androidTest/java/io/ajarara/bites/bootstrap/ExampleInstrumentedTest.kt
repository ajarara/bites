package io.ajarara.bites.bootstrap

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.ajarara.bites.bootstrap.activity.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext
import kotlinx.coroutines.test.runTest

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun helloWorldIsDisplayedOnAppStart() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withText("Choose a demo below!"))
            .check(matches(isDisplayed()))
    }

    private class Thing(var field: Int)
    @Test
    fun concurrentMapTest () {
        val heldReference = Thing(0)
        val throughMap = Thing(0)
        val c = ConcurrentHashMap<String, Thing>()

        c["throughMap"] = throughMap
        c["heldReference"] = heldReference

        thread {
            listOf("heldReference", "throughMap").forEach {
                c.getValue(it).field = 1
            }
        }.join()
        
        assertEquals(heldReference.field, 1)
        assertEquals(c.getValue("throughMap").field, 1)
    }

    @Test
    fun anrDetection() = runTest {
        val flipped = AtomicInteger(0)
        listOf(
            async(Dispatchers.Main) {
                Thread.sleep(10000)
                while (!flipped.compareAndSet(0, 1)) {

                }
                println("Set 1")
            },
            async(Dispatchers.IO) {
                while (!flipped.compareAndSet(1, 2)) {

                }
                println("Set 2")
            },
        ).awaitAll()
    }
}