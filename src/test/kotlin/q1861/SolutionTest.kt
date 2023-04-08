package q1861

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class SolutionTest {
    private val solution = Solution()

    @TestFactory
    fun test() = listOf(
        Triple(
            "obstacle 1",
            """|*..|""",
            """
            |*|
            |.|
            |.|
            """
        ),
        Triple(
            "obstacle 2",
            """
                |*..|
                |.*.|
               """,
            """
                |.*|
                |*.|
                |..|
                """
        ),
        Triple(
            "obstacle 3",
            """
                |*..*|
                |.**.|
                """,
            """
                |.*|
                |*.|
                |*.|
                |.*|
                """
        ),
        Triple(
            "stone 1",
            "|#..|",
            """
            |.|
            |.|
            |#|
            """
        ),
        Triple(
            "stone 2",
            """
                |###|
                |##.|
               """,
            """
                |.#|
                |##|
                |##|
                """
        ),
        Triple(
            "stone 3",
            """
                |#..#|
                |.##.|
                """,
            """
                |..|
                |..|
                |##|
                |##|
                """
        ),
        Triple(
            "stone and obstacle 1",
            "|#*.|",
            """
            |#|
            |*|
            |.|
            """
        ),
        Triple(
            "stone and obstacle 2",
            """
                |#*#.|
                |#.*#|
               """,
            """
                |.#|
                |#*|
                |*.|
                |##|
                """
        ),
        Triple(
            "stone and obstacle 3",
            """
                |#.#..***|
                |#.*#.*#.|
                """,
            """
                |..|
                |#.|
                |*.|
                |.#|
                |##|
                |**|
                |.*|
                |#*|
                """
        ),
    ).map { (displayName, input, expected) ->
        DynamicTest.dynamicTest(displayName) {
            assertArrayEquals(expected.toBox(), solution.rotateTheBox(input.toBox()))
        }
    }

    private fun String.toBox(): Array<CharArray> {
        return this.trimIndent().replace("|", "").split("\n").map { s ->
            s.toCharArray()
        }.toTypedArray()
    }
}