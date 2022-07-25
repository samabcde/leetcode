package q2347

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class SolutionTest {
    private var solution = Solution()
    @Test
    fun given_allSuitAreSame_should_return_flush() {
        assertEquals("Flush", solution.bestHand(intArrayOf(1, 2, 3, 4, 5), charArrayOf('a', 'a', 'a', 'a', 'a')))
    }

    @Test
    fun given_threeCardWithSameRank_should_return_threeOfAKind() {
        assertEquals("Three of a Kind", solution.bestHand(intArrayOf(3, 3, 3, 4, 5), charArrayOf('a', 'b', 'b', 'a', 'a')))
    }

    @Test
    fun given_twoCardWithSameRank_should_return_pair() {
        assertEquals("Pair", solution.bestHand(intArrayOf(3, 3, 1, 4, 5), charArrayOf('a', 'b', 'b', 'a', 'a')))
        assertEquals("Pair", solution.bestHand(intArrayOf(1, 1, 2, 4, 5), charArrayOf('a', 'b', 'b', 'a', 'a')))
        assertEquals("Pair", solution.bestHand(intArrayOf(13, 13, 2, 4, 5), charArrayOf('a', 'b', 'b', 'a', 'a')))
    }

    @Test
    fun given_noPairDifferentSuit_should_return_highCard() {
        assertEquals("High Card", solution.bestHand(intArrayOf(3, 6, 1, 4, 5), charArrayOf('a', 'b', 'b', 'a', 'a')))
    }
}