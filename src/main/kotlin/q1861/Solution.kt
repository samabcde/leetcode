package q1861

class Solution {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        return rotate(box)
    }

    // [[1, 2, 3]]-> [[1],[2],[3]]
    // 0,0->0,0
    // 0,1->1,0
    // 0,2->2,0
    private fun rotate(box: Array<CharArray>): Array<CharArray> {
        if (box.isEmpty()) {
            return box
        }
        val height = box.size
        val width = box[0].size
        val rotated = Array(width) { CharArray(height) }
        box.forEachIndexed { rowIndex, chars ->
            chars.forEachIndexed { colIndex, char ->
                rotated[colIndex][rowIndex] = char
            }
        }
        return rotated;
    }
}