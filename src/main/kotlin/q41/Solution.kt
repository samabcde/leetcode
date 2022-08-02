package q41

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        // 1,2,3,4...
        // find minimum exclude value <= 0
        // find minimum m that m-1 in array and m not in
        var positiveNums = nums.filter { i -> i > 0 }
        var booleanArray = BooleanArray(positiveNums.size + 1) { false }
        for (i in positiveNums.indices) {
            if (positiveNums[i] > booleanArray.size) {
                continue
            }
            booleanArray[positiveNums[i] - 1] = true
        }
        for (i in booleanArray.indices) {
            if (!booleanArray[i]) {
                return i + 1
            }
        }
        throw IllegalStateException("Should have at least 1 holes")
    }
}