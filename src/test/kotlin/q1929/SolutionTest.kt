package q1929

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {
    var solution = Solution()

    @Test
    fun given_input_is_empty_should_return_empty() {
        assertArrayEquals(intArrayOf(), solution.getConcatenation(intArrayOf()))
    }

    @Test
    fun `given_input_is_1_should_return_1,1`() {
        assertArrayEquals(intArrayOf(1,1), solution.getConcatenation(intArrayOf(1)))
    }
    @Test
    fun `given_input_is_1,2,3_should_return_1,2,3,1,2,3`() {
        assertArrayEquals(intArrayOf(1,1), solution.getConcatenation(intArrayOf(1)))
    }
}