package io.ajarara.fleet

import java.util.Deque
import java.util.ArrayDeque

fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
    val cars = position.zip(speed).sortedByDescending { (position, speed) -> position }
    val fleets: Deque<Double> = ArrayDeque<Double>()
    for ((position, speed) in cars) {
        val time = (target - position) / speed.toDouble()
        when (val priorTime = fleets.peek()) {
            null -> fleets.push(time)
            else -> {
                if (priorTime < time) {
                    fleets.push(time)
                }
            }
        }
    }

    return fleets.size
}
