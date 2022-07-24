package q2347;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void given_allSuitAreSame_should_return_flush() {
        assertEquals("Flush", solution.bestHand(new int[]{1, 2, 3, 4, 5}, new char[]{'a', 'a', 'a', 'a', 'a'}));
    }

    @Test
    public void given_threeCardWithSameRank_should_return_threeOfAKind() {
        assertEquals("Three of a Kind", solution.bestHand(new int[]{3, 3, 3, 4, 5}, new char[]{'a', 'b', 'b', 'a', 'a'}));
    }

    @Test
    public void given_twoCardWithSameRank_should_return_pair() {
        assertEquals("Pair", solution.bestHand(new int[]{3, 3, 1, 4, 5}, new char[]{'a', 'b', 'b', 'a', 'a'}));
        assertEquals("Pair", solution.bestHand(new int[]{1, 1, 2, 4, 5}, new char[]{'a', 'b', 'b', 'a', 'a'}));
        assertEquals("Pair", solution.bestHand(new int[]{13, 13, 2, 4, 5}, new char[]{'a', 'b', 'b', 'a', 'a'}));
    }

    @Test
    public void given_noPairDifferentSuit_should_return_highCard() {
        assertEquals("High Card", solution.bestHand(new int[]{3, 6, 1, 4, 5}, new char[]{'a', 'b', 'b', 'a', 'a'}));
    }

}