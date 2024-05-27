package q1377

import org.junit.jupiter.api.Test
import kotlin.math.absoluteValue
import kotlin.test.assertTrue

class SolutionTest {
    val solution = Solution();

    @Test
    fun `given 1 node with no edge and target is 1 and time = 1 should return 1`() {
        assertCloseTo(1.0, solution.frogPosition(1, arrayOf(), 1, 1));
    }

    @Test
    fun `given 2 node with 1 edge and target is 1 and time = 1 should return 0`() {
        assertCloseTo(0.0, solution.frogPosition(2, arrayOf(intArrayOf(1, 2)), 1, 1));
    }

    @Test
    fun `given 2 node and target is 2 and time = 1 should return 1`() {
        assertCloseTo(0.0, solution.frogPosition(2, arrayOf(intArrayOf(1, 2)), 1, 1));
    }

    @Test
    fun `given 4 node and target is 2 and time = 1 should return 1_3`() {
        assertCloseTo(
            0.33333,
            solution.frogPosition(4, arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 4)), 1, 2)
        );
    }

    @Test
    fun `given 7 node and target is 2 and time = 1 should return 1_6`() {
        assertCloseTo(
            0.16666,
            solution.frogPosition(
                7, arrayOf(
                    intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(1, 7),
                    intArrayOf(2, 4), intArrayOf(2, 6), intArrayOf(3, 5)
                ), 2, 4
            )
        );
    }

    @Test
    fun `given 100 node and target is 2 and time = 90 should return 0`() {
        assertCloseTo(
            0.0,
            solution.frogPosition(
                100, (1..99).map { intArrayOf(it, it + 1) }.toTypedArray(), 90, 2
            )
        );
    }

    fun assertCloseTo(
        expected: Double,
        actual: Double
    ) {
        assertTrue(actual.minus(expected).absoluteValue < 0.00001)
    }
}
