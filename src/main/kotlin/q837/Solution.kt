package q837

class Solution {
    private lateinit var dp: Array<Double>

    /**
     * return p = P(totalPts <= n)
     * stop when >= k
     * 0 <= k <= n <= 10^4
     * 1 <= maxPts <= 10^4
     * dp memorize
     */
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        dp = Array(k + maxPts + 1) { i ->
            when (i) {
                in (k..n) -> 1.0
                in ((n + 1) until (k + maxPts + 1)) -> 0.0
                else -> -1.0
            }
        }
        if (k > 0) {
            var pk_1 = 0.0
            for (i in (k until maxPts + k)) {
                pk_1 += dp[i]
            }
            pk_1 = pk_1.div(maxPts)
            dp[k - 1] = pk_1
        }
        for (i in (0 until k - 1).reversed()) {
            computeProb(i, maxPts)
        }
        return dp[0]
    }


    // 22 20 10
    // 1 2 3 3 4 5 6 7 8 9 10 11 12
    // 13 14 15 16 17 18 19
    // 20 21 22 -> 1
    // 23 24 25 26 27 28 29 -> 0
    // P(19) = Sum(P(20-29)) / 10
    // P(18) = Sum(P(19-28)) / 10
    // P(17) = Sum(P(18-27)) / 10
    // ...
    // P(0)  = Sum(P(1-10)) / 10
    private fun computeProb(currentPts: Int, maxPts: Int) {
        val p_mc = dp[maxPts + currentPts + 1]
        val p_next = dp[currentPts + 1]
        val p_c = (p_next.times(maxPts + 1) - p_mc).div(maxPts)
        dp[currentPts] = p_c
    }
}