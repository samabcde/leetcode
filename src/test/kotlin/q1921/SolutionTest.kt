package q1921

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {
    var solution = Solution()

    @Test
    fun should_eliminate_1monster_when_only_1monster() {
        var dists = intArrayOf(1)
        var speeds = intArrayOf(10)
        assertEquals(1, solution.eliminateMaximum(dists, speeds))
    }

    @Test
    fun should_eliminate_1monster_when_2monsters_d2s2() {
        var dists = intArrayOf(2, 2)
        var speeds = intArrayOf(2, 2)
        assertEquals(1, solution.eliminateMaximum(dists, speeds))
    }

    @Test
    fun should_eliminate_2monster_when_2monsters_d2s1_and_d2s2() {
        var dists = intArrayOf(2, 2)
        var speeds = intArrayOf(2, 1)
        assertEquals(2, solution.eliminateMaximum(dists, speeds))
    }

    @Test
    fun should_eliminate_10monster_when_10monsters_are_d90s1() {
        var dists = intArrayOf(90, 90, 90, 90, 90, 90, 90, 90, 90, 90)
        var speeds = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        assertEquals(10, solution.eliminateMaximum(dists, speeds))
    }

    @Test
    fun should_eliminate_10000monster_when_10000monsters_are_d10000s1() {
        var dists = IntArray(10000) { it ->
            10000
        }
        var speeds = IntArray(10000) { it ->
            1
        }
        assertEquals(10000, solution.eliminateMaximum(dists, speeds))
    }
    @Test
    fun should_eliminate_10monster_when_10000monsters_are_d10000s10() {
        var dists = IntArray(10000) { it ->
            10000
        }
        var speeds = IntArray(10000) { it ->
            1000
        }
        assertEquals(10, solution.eliminateMaximum(dists, speeds))
    }
}