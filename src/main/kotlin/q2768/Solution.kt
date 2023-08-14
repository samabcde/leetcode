package q2768

class Solution {
    fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {
        val positionToBlackPointCountMap = mutableMapOf<Position, Int>()
        coordinates.forEach { point ->
            val row = point[0]
            val col = point[1]
            if (row > 0) {
                if (col > 0) {
                    positionToBlackPointCountMap.merge(Position(row - 1, col - 1), 1) { int1, int2 -> int1 + int2 }
                }
                if (col < n - 1) {
                    positionToBlackPointCountMap.merge(Position(row - 1, col), 1) { int1, int2 -> int1 + int2 }
                }
            }
            if (row < m - 1) {
                if (col > 0) {
                    positionToBlackPointCountMap.merge(Position(row, col - 1), 1) { int1, int2 -> int1 + int2 }
                }
                if (col < n - 1) {
                    positionToBlackPointCountMap.merge(Position(row, col), 1) { int1, int2 -> int1 + int2 }
                }
            }
        }
        val totalNumberOfBlock = (m - 1).toLong() * (n - 1).toLong()
        val blackBoxCount = LongArray(5) { 0 }
        positionToBlackPointCountMap.values.forEach {
            blackBoxCount[it]++
        }
        blackBoxCount[0] =
            totalNumberOfBlock - blackBoxCount[1] - blackBoxCount[2] - blackBoxCount[3] - blackBoxCount[4]
        return blackBoxCount
    }

    data class Position(
        val row: Int,
        val col: Int
    )
}