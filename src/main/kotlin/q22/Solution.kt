package q22

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        // 1 ()
        // 2 ()() (())
        // 3 ()()() (()()) (())() ((())) ()(())
        return generateGroup(n * 2, 0, listOf(""))
    }

    private fun generateGroup(n: Int, current: Int, result: List<String>): List<String> {
        if (n == 0) {
            return result
        }
        if (current == 0) {
            return generateGroup(n - 1, current + 1, result.map { "$it(" })
        } else {
            if (current == n) {
                return generateGroup(n - 1, current - 1, result.map { "$it)" })
            } else {
                return generateGroup(n - 1, current + 1, result.map { "$it(" }) +
                        generateGroup(n - 1, current - 1, result.map { "$it)" })
            }
        }
    }
}