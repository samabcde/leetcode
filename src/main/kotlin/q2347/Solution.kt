package q2347

internal class Solution {
    fun bestHand(ranks: IntArray, suits: CharArray): String {
        if (isFlush(suits)) {
            return "Flush"
        }
        if (isThreeOfAKind(ranks)) {
            return "Three of a Kind"
        }
        return if (isPair(ranks)) {
            "Pair"
        } else "High Card"
    }

    companion object {
        private fun isThreeOfAKind(ranks: IntArray): Boolean {
            val counts = IntArray(13)
            for (i in 0..4) {
                counts[ranks[i] - 1]++
                if (counts[ranks[i] - 1] == 3) {
                    return true
                }
            }
            return false
        }

        private fun isPair(ranks: IntArray): Boolean {
            val counts = IntArray(13)
            for (i in 0..4) {
                counts[ranks[i] - 1]++
                if (counts[ranks[i] - 1] == 2) {
                    return true
                }
            }
            return false
        }

        private fun isFlush(suits: CharArray): Boolean {
            val first = suits[0]
            for (i in 1..4) {
                if (suits[i] != first) {
                    return false
                }
            }
            return true
        }
    }
}