package q36

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class SolutionTest {
    val solution = Solution()

    @Test
    fun Given_emptyBoard_ShouldBeValid() {
        var board = """
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
""".trimIndent()
        assertTrue(solution.isValidSudoku(toArrayOfCharArray(board)))
    }

    @Test
    fun Given_1rowFilled1to9_ShouldBeValid() {
        var board = """
    -------------
    |123|456|789|
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
""".trimIndent()
        assertTrue(solution.isValidSudoku(toArrayOfCharArray(board)))
    }

    @Test
    fun Given_1rowWithDuplicate_ShouldBeInvalid() {
        var board = """
    -------------
    |123|456|71 |
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
""".trimIndent()
        assertFalse(solution.isValidSudoku(toArrayOfCharArray(board)))
    }
    @Test
    fun Given_1columnFilled1to9_ShouldBeValid() {
        var board = """
    -------------
    |1..|...|...|
    |2..|...|...|
    |3..|...|...|
    -------------
    |4..|...|...|
    |5..|...|...|
    |6..|...|...|
    -------------
    |7..|...|...|
    |8..|...|...|
    |9..|...|...|
    -------------
""".trimIndent()
        assertTrue(solution.isValidSudoku(toArrayOfCharArray(board)))
    }
    @Test
    fun Given_1columnWithDuplicate_ShouldBeInvalid() {
        var board = """
    -------------
    |1..|...|...|
    |2..|...|...|
    |3..|...|...|
    -------------
    |4..|...|...|
    |...|...|...|
    |3..|...|...|
    -------------
    |7..|...|...|
    |8..|...|...|
    |9..|...|...|
    -------------
""".trimIndent()
        assertFalse(solution.isValidSudoku(toArrayOfCharArray(board)))
    }
    @Test
    fun Given_1subBoxFilled1to9_ShouldBeValid() {
        var board = """
    -------------
    |147|...|...|
    |258|...|...|
    |369|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
    |...|...|...|
    |...|...|...|
    |...|...|...|
    -------------
""".trimIndent()
        assertTrue(solution.isValidSudoku(toArrayOfCharArray(board)))
    }

    @Test
    fun Given_1subBoxWithDuplicate_ShouldBeInvalid() {
        var board = """
    -------------
    |147|   |   |
    |2 8|   |   |
    |361|   |   |
    -------------
    |   |   |   |
    |   |   |   |
    |   |   |   |
    -------------
    |   |   |   |
    |   |   |   |
    |   |   |   |
    -------------
""".trimIndent()
        assertFalse(solution.isValidSudoku(toArrayOfCharArray(board)))
    }
    @Test
    fun Given_allSubBoxIsValid_ShouldBeValid() {
        var board = """
    -------------
    |53.|.7.|...|
    |6..|195|...|
    |.98|...|.6.|
    |8..|.6.|..3|
    |4..|8.3|..1|
    |7..|.2.|..6|
    |.6.|...|28.|
    |...|419|..5|
    |...|.8.|.79|
    -------------
""".trimIndent()
        assertTrue(solution.isValidSudoku(toArrayOfCharArray(board)))
    }
//    [
//    [53..7....]
//    [6..195...]
//    [.98....6.]
//    [8...6...3]
//    [4..8.3..1]
//    [7...2...6]
//    [.6....28.]
//    [...419..5]
//    [....8..79]
//    ]
    private fun toArrayOfCharArray(board: String): Array<CharArray> {
        return board.split(System.lineSeparator()).filter { line -> !line.startsWith("--") }
            .map { line -> line.replace("|", "").toCharArray() }.toTypedArray()
    }
}