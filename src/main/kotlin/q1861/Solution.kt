package q1861

class Solution {
    companion object {
        private const val STONE = '#'
        private const val OBSTACLE = '*'
        private const val SPACE = '.'
    }

    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        return box.rotate()
            .fall()
    }

    // [[1, 2, 3]]-> [[1],[2],[3]]
    // 0,0->0,0
    // 0,1->1,0
    // 0,2->2,0
    // [[1, 2, 3], [4, 5, 6]-> [[4, 1],[5, 2],[6, 3]]
    // 0,0->0,1
    // 0,1->1,1
    // 0,2->2,1
    // 1,0->0,0
    // 1,1->1,0
    // 1,2->2,0
    private fun Array<CharArray>.rotate(): Array<CharArray> {
        val box = this
        if (box.isEmpty()) {
            return box
        }
        val height = box.size
        val width = box[0].size
        val rotated = Array(width) { CharArray(height) }
        box.forEachIndexed { rowIndex, chars ->
            chars.forEachIndexed { colIndex, char ->
                rotated[colIndex][height - rowIndex - 1] = char
            }
        }
        return rotated
    }

    private fun Array<CharArray>.fall(): Array<CharArray> {
        val box = this
        val height = box.size
        val width = box[0].size
        for (col in (0 until width)) {
            val obstacleIndexToStoneCountMap = mutableMapOf<Int, Int>()
            var currentIndex = height
            obstacleIndexToStoneCountMap[currentIndex] = 0
            for (row in (0 until height).reversed()) {
                if (box[row][col] == OBSTACLE) {
                    currentIndex = row
                    obstacleIndexToStoneCountMap[currentIndex] = 0
                } else if (box[row][col] == STONE) {
                    obstacleIndexToStoneCountMap.computeIfPresent(currentIndex) { _, v ->
                        v + 1
                    }
                }
            }
            obstacleIndexToStoneCountMap.forEach { (obstacleIndex, stoneCount) ->
                for (row in (obstacleIndex - stoneCount until obstacleIndex).reversed()) {
                    box[row][col] = STONE
                }
                for (row in (0 until obstacleIndex - stoneCount).reversed()) {
                    if (box[row][col] == OBSTACLE) {
                        break
                    }
                    box[row][col] = SPACE
                }
            }
        }
        return box
    }
}