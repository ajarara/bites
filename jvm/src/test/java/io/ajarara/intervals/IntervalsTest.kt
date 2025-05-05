package io.ajarara.intervals

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*


class IntervalsTest {
    @Test
    fun `no meetings`() {
        assertTrue(canAttendMeetings(listOf()))
    }

    @Test
    fun `non overlapping meetings`() {
        assertTrue(
            canAttendMeetings(
                listOf(
                    Interval(5, 8),
                    Interval(9, 15)
                )
            )
        )
    }

    @Test
    fun `overlapping meetings`() {
        assertFalse(
            canAttendMeetings(
                listOf(
                    Interval(0, 30),
                    Interval(5, 10),
                    Interval(15, 20)
                )
            )
        )
    }
}
