package io.ajarara.tasks

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class TasksTest {
    // @Test
    fun `case 1`() {
        // ["X","X","Y","Y"], 2 out 5
        assertEquals(
            5,
            execute(listOf("x", "x", "y", "y"), 2))
    }

    // @Test
    fun `case 2`() {
        // tasks = ["A","A","A","B","C"], n = 3 out 9
        assertEquals(
            9,
            execute(listOf("a", "a", "a", "b", "c"), 3))
    }
}
