package q41

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {
    var solution = Solution()

    @Test
    fun Given_InputIsEmpty_Should_return1() {
        assertEquals(1, solution.firstMissingPositive(intArrayOf()))
    }

    @Test
    fun Given_InputOnlyContainsNonPositive_Should_return1() {
        assertEquals(1, solution.firstMissingPositive(intArrayOf(0, -1, -2)))
    }

    @Test
    fun Given_InputContains0And1_Should_return2() {
        assertEquals(2, solution.firstMissingPositive(intArrayOf(0, 1)))
    }

    @Test
    fun Given_InputContains0And2_Should_return1() {
        assertEquals(1, solution.firstMissingPositive(intArrayOf(0, 2)))
    }

    @Test
    fun Given_InputContains1To100_Should_return101() {
        assertEquals(101, solution.firstMissingPositive(IntRange(1, 100).toList().toIntArray()))
    }

    @Test
    fun Given_InputContains1To49And51To100_Should_return101() {
        assertEquals(
            50,
            solution.firstMissingPositive((IntRange(1, 49).toList() + IntRange(51, 100).toList()).toIntArray())
        )
    }

    @Test
    fun Given_InputContains1To500000_Should_return500001() {
        assertEquals(500001, solution.firstMissingPositive(IntRange(1, 500000).toList().toIntArray()))
    }

    @Test
    fun Given_InputContains2To500000_Should_return500001() {
        assertEquals(1, solution.firstMissingPositive(IntRange(2, 500000).toList().toIntArray()))
    }
}