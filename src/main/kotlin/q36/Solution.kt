package q36

import kotlin.collections.HashSet

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return isAllColumnValid(board) && isAllRowValid(board) && isAllSubBoxValid(board)
    }

    private fun isAllRowValid(board: Array<CharArray>): Boolean {
        return board.all { row -> isNumsValid(row) }
    }

    private fun isAllColumnValid(board: Array<CharArray>): Boolean {
        var column = charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        for (i in 0..8) {
            for (j in 0..8) {
                column[j] = board[j][i]
            }
            if (!isNumsValid(column)) {
                return false
            }
        }
        return true
    }

    private fun isAllSubBoxValid(board: Array<CharArray>): Boolean {
        var subBox = charArrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.')
        for (i in 0..8) {
            for (k in 0..8) {
                var x = k / 3 + ((i / 3) * 3)
                var y = (k % 3) + ((i % 3) * 3)
                subBox[k] = board[x][y]
                // i 0 k 0 -> 0, 0
                // i 0 k 1 -> 0, 1
                // i 0 k 2 -> 0, 2
                // i 0 k 3 -> 1, 0
                // i 0 k 4 -> 1, 1
                // i 0 k 5 -> 1, 2
                // i 0 k 6 -> 2, 0
                // i 0 k 7 -> 2, 1
                // i 0 k 8 -> 2, 2
                // i 1 k 0 -> 0, 0
                // i 1 k 1 -> 0, 1
                // i 1 k 2 -> 0, 2
                // i 1 k 3 -> 1, 0
                // i 1 k 4 -> 1, 1
                // i 1 k 5 -> 1, 2
                // i 1 k 6 -> 2, 0
                // i 1 k 7 -> 2, 1
                // i 1 k 8 -> 2, 2
            }
            if (!isNumsValid(subBox)) {
                return false;
            }
        }
        return true
    }

    private fun isNumsValid(nums: CharArray): Boolean {
        var filledNums = nums.filter { num -> num != '.' }
        var set = HashSet<Char>()
        for (c in filledNums) {
            if (!set.add(c)) {
                println("nums: ${nums.contentToString()}, filledNums: $filledNums")
                return false
            }
        }
        return true
    }
}