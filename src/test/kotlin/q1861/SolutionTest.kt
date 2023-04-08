package q1861

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SolutionTest {
    private val solution = Solution()

    @Test
    fun rotateAllBlank() {
        assertArrayEquals(
            "|*, , |".toBox(), solution.rotateTheBox(
                """
                   |*|
                   | |
                   | |
               """.trimIndent().toBox()
            )
        )
    }

    private fun String.toBox(): Array<CharArray> {
        return this.replace("|", "").split("\n").map {
            it.split(",").map { s ->
                s.single()
            }.toCharArray()
        }.toTypedArray()
    }
}