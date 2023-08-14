package q2768

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SolutionTest {
    val solution = Solution()

    @ParameterizedTest
    @MethodSource("testCases")
    fun countBlackBlocksCorrect(testCase: TestCase) {
        val actual = solution.countBlackBlocks(testCase.width, testCase.height, testCase.blackBoxes)
        assertArrayEquals(testCase.expected, actual)
    }

    data class TestCase(
        val width: Int,
        val height: Int,
        val blackBoxes: Array<IntArray>,
        val expected: LongArray
    )

    companion object {
        @JvmStatic
        fun testCases() = Stream.of(
            TestCase(
                2, 2,
                arrayOf(),
                longArrayOf(1L, 0L, 0L, 0L, 0L)
            ),
            TestCase(
                2, 2,
                arrayOf(intArrayOf(0, 0)),
                longArrayOf(0L, 1L, 0L, 0L, 0L)
            ),
            TestCase(
                2, 2,
                arrayOf(intArrayOf(0, 0), intArrayOf(0, 1)),
                longArrayOf(0L, 0L, 1L, 0L, 0L)
            ),
            TestCase(
                2, 2,
                arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0)),
                longArrayOf(0L, 0L, 0L, 1L, 0L)
            ),
            TestCase(
                2, 2,
                arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(1, 1)),
                longArrayOf(0L, 0L, 0L, 0L, 1L)
            ),
            TestCase(
                3, 3,
                arrayOf(intArrayOf(1, 1)),
                longArrayOf(0L, 4L, 0L, 0L, 0L)
            ),
            TestCase(
                10, 10,
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(1, 1),
                    intArrayOf(2, 2),
                    intArrayOf(3, 3),
                    intArrayOf(4, 4),
                    intArrayOf(5, 5),
                    intArrayOf(6, 6),
                    intArrayOf(7, 7),
                    intArrayOf(8, 8),
                    intArrayOf(9, 9),
                ),
                longArrayOf(56L, 16L, 9L, 0L, 0L)
            ),
            TestCase(
                10000, 10000,
                Array(1000) { it ->
                    intArrayOf(it + 1, it + 1)
                },
                longArrayOf(99977000L, 2002L, 999L, 0L, 0L)
            ),
            TestCase(
                100000, 100000,
                Array(10000) { it ->
                    intArrayOf(it + 1, it + 1)
                },
                longArrayOf(9999770000L, 20002L, 9999L, 0L, 0L)
            )
        )
    }
}