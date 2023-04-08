package q1659

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import q1659.Solution.LivingState.*


internal class SolutionTest {

    var solution = Solution()

    @Nested
    inner class CalculateHappiness {

        @Test
        fun given_singleRoomIsEmpty_when_calculateHappiness_should_return0() {
            assertEquals(0, solution.calculateHappiness(arrayOf(arrayOf(EMPTY))))
        }

        @Test
        fun given_singleRoomIsExtrovert_when_calculateHappiness_should_return40() {
            assertEquals(40, solution.calculateHappiness(arrayOf(arrayOf(EXTRAVERT))))
        }

        @Test
        fun given_singleRoomIsIntrovert_when_calculateHappiness_should_return120() {
            assertEquals(120, solution.calculateHappiness(arrayOf(arrayOf(INTROVERT))))
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class NeighbourNumsAfterHalf {
        @ParameterizedTest
        @MethodSource("testCases")
        fun given_input_should_return_expected(m: Int, n: Int, neighbourNums: List<Int>) {
            assertEquals(neighbourNums, solution.neighbourNumsAfterHalf(m, n));
        }

        fun testCases(): List<Arguments> {
            return listOf(
                Arguments.of(1, 1, emptyList<Int>()),
                Arguments.of(3, 3, listOf(6, 6, 6, 6)),
                Arguments.of(4, 4, listOf(4, 4, 6, 6, 6, 6, 8, 8)),
                Arguments.of(5, 5, listOf(6, 6, 6, 6, 6, 6, 6, 6, 8, 8, 8, 8)),
                Arguments.of(5, 1, listOf(4, 4)),
                Arguments.of(1, 5, listOf(4, 4)),
                Arguments.of(4, 1, listOf(2, 4)),
                Arguments.of(4, 2, listOf(4, 4, 6, 6)),
                Arguments.of(4, 3, listOf(4, 4, 6, 6, 6, 8)),
            )
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class NeighbourOfSquare {
        @ParameterizedTest
        @MethodSource("testCases")
        fun given_input_should_return_expected(i: Int, expected: Int) {
            assertEquals(expected, solution.neighbourOfSquare(i));
        }

        fun testCases(): List<Arguments> {
            return listOf(
                Arguments.of(1, 0),
                Arguments.of(2, 8),
                Arguments.of(3, 24),
                Arguments.of(4, 48),
                Arguments.of(5, 80),
            )
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class MaxNeighbour {
        @ParameterizedTest
        @MethodSource("testCases")
        fun given_input_should_return_expected(m: Int, n: Int, num: Int, expected: Int) {
            assertEquals(expected, solution.maxNeighbour(m, n, num));
        }

        fun testCases(): List<Arguments> {
            return listOf(
                Arguments.of(1, 1, 0, 0),
                Arguments.of(1, 1, 1, 0),
                Arguments.of(2, 2, 4, 8),
                Arguments.of(3, 3, 1, 0),
                Arguments.of(3, 3, 2, 2),
                Arguments.of(3, 3, 3, 4),
                Arguments.of(3, 3, 4, 8),
                Arguments.of(3, 3, 5, 10),
                Arguments.of(3, 3, 6, 14),
                Arguments.of(3, 3, 7, 16),
                Arguments.of(3, 3, 8, 20),
                Arguments.of(3, 3, 9, 24),
                Arguments.of(1, 4, 4, 6),
                Arguments.of(4, 1, 4, 6),
                Arguments.of(1, 4, 2, 2),
                Arguments.of(4, 1, 2, 2),
                Arguments.of(5, 5, 25, 80),
            )
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class FindMax {
        @ParameterizedTest
        @MethodSource("testCases")
        fun given_input_should_return_expected(
            m: Int,
            n: Int,
            introvertsCount: Int,
            extrovertsCount: Int,
            expected: Int
        ) {
//            assertEquals(expected, solution.findMax(m, n, introvertsCount, extrovertsCount));
        }

        fun testCases(): List<Arguments> {
            return listOf(
                Arguments.of(1, 1, 1, 0, 120),
                Arguments.of(1, 1, 0, 1, 40),
                Arguments.of(1, 2, 2, 0, 180),
                Arguments.of(1, 2, 0, 2, 120),
                Arguments.of(1, 2, 1, 1, 150),
                Arguments.of(2, 1, 2, 0, 180),
                Arguments.of(2, 1, 0, 2, 120),
                Arguments.of(2, 1, 1, 1, 150),
//                Arguments.of(2, 2, 4, 8),
//                Arguments.of(3, 3, 1, 0),
//                Arguments.of(3, 3, 2, 2),
//                Arguments.of(3, 3, 3, 4),
//                Arguments.of(3, 3, 4, 8),
//                Arguments.of(3, 3, 5, 10),
//                Arguments.of(3, 3, 6, 14),
//                Arguments.of(3, 3, 7, 16),
//                Arguments.of(3, 3, 8, 20),
//                Arguments.of(3, 3, 9, 24),
//                Arguments.of(1, 4, 4, 6),
//                Arguments.of(4, 1, 4, 6),
//                Arguments.of(1, 4, 2, 2),
//                Arguments.of(4, 1, 2, 2),
//                Arguments.of(5, 5, 25, 80),
            )
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class MaxNeighbours {
        @ParameterizedTest
        @MethodSource("testCases")
        fun given_input_should_return_expected(
            m: Int,
            n: Int,
            total: Int,
            expected: Map<Int, Int>
        ) {
            assertEquals(expected, solution.maxNeighbours(m, n, total))
        }

        fun testCases(): List<Arguments> {
            return listOf(
                Arguments.of(1, 1, 0, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(1, 1, 1, mapOf(Pair(0, 1), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(1, 2, 0, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(1, 2, 2, mapOf(Pair(0, 0), Pair(1, 2), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(2, 1, 0, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(2, 1, 2, mapOf(Pair(0, 0), Pair(1, 2), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(3, 3, 1, mapOf(Pair(0, 1), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(3, 3, 6, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 4), Pair(3, 2), Pair(4, 0))),
                Arguments.of(3, 3, 9, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 4), Pair(3, 4), Pair(4, 1))),
            )
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class MinNeighbours {
        @ParameterizedTest
        @MethodSource("testCases")
        fun given_input_should_return_expected(
            m: Int,
            n: Int,
            total: Int,
            expected: Map<Int, Int>
        ) {
            assertEquals(expected, solution.minNeighbours(m, n, total))
        }

        fun testCases(): List<Arguments> {
            return listOf(
                Arguments.of(1, 1, 0, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(1, 1, 1, mapOf(Pair(0, 1), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(1, 2, 0, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(1, 2, 2, mapOf(Pair(0, 0), Pair(1, 2), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(2, 1, 0, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(2, 1, 2, mapOf(Pair(0, 0), Pair(1, 2), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(3, 3, 1, mapOf(Pair(0, 1), Pair(1, 0), Pair(2, 0), Pair(3, 0), Pair(4, 0))),
                Arguments.of(3, 3, 6, mapOf(Pair(0, 2), Pair(1, 3), Pair(2, 0), Pair(3, 1), Pair(4, 0))),
                Arguments.of(3, 3, 9, mapOf(Pair(0, 0), Pair(1, 0), Pair(2, 4), Pair(3, 4), Pair(4, 1))),
            )
        }
    }
}