package io.ajarara.intervals

data class Interval(
    val start: Int,
    val end: Int
)

fun canAttendMeetings(meetings: List<Interval>): Boolean {
    if (meetings.isEmpty()) {
        return true
    }
    val sorted = meetings.sortedBy { it.start }
    
    for (i in 1 until sorted.size) {
        val prev = sorted[i - 1]
        val curr = sorted[i]
        if (prev.end > curr.start) {
            return false
        }
    }

    return true
}
