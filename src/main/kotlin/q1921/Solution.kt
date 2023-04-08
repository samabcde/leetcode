package q1921

import java.util.PriorityQueue
import kotlin.math.ceil

class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val minuteToReach: PriorityQueue<Int> = PriorityQueue()
        for (i in dist.indices) {
            minuteToReach.add(ceil(dist[i].toDouble().div(speed[i])).toInt())
        }
        var minPassed = 0;
        while (minuteToReach.peek() != null) {
            if (minuteToReach.poll() <= minPassed) {
                return minPassed
            }
            minPassed++
        }
        return minPassed;
    }
}