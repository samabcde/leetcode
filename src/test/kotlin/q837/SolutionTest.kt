package q837

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SolutionTest {
    private val solution = Solution()

    @Test
    fun `when n is 0 then probability is 1`() {
        val actual = solution.new21Game(0, 0, 1)
        assertEquals(1.0, actual)
    }

    @ParameterizedTest
    @CsvSource(
        textBlock = """
         n,   k, maxPts
         2,   1,      1
         4,   2,      2
         6,   3,      3
        10,   5,      5""", useHeadersInDisplayName = true
    )
    fun `when 2k-1 lt n and maxPts le k then probability is 1`(n: Int, k: Int, maxPts: Int) {
        val actual = solution.new21Game(n, k, maxPts)
        assertEquals(1.0, actual, 0.00001)
    }

    @ParameterizedTest
    @CsvSource(
        textBlock = """
         n,    k, maxPts, expected
         1,    0,      1,      1.0
         2,    2,      2,     0.75
         2,    2,      3,  0.44444
         1,    1,     10,      0.1
         2,    1,     10,      0.2
         3,    1,     10,      0.3
         4,    1,     10,      0.4
         5,    1,     10,      0.5
         6,    1,     10,      0.6
         7,    1,     10,      0.7
         8,    1,     10,      0.8
         9,    1,     10,      0.9
        10,    1,     10,      1.0
      1000,    1,   1000,      1.0
      5000, 4800,   3000,  0.13231
      9301, 9224,   7771,  0.01846
     19301,19224,  17771,  0.00778
     19302,19224,  17771,  0.00788
     19303,19224,  17771,  0.00798
     19304,19224,  17771,  0.00808
     19305,19224,  17771,  0.00818
     19306,19224,  17771,  0.00828
     19307,19224,  17771,  0.00838
     19308,19224,  17771,  0.00848
     19309,19224,  17771,  0.00858
     19310,19224,  17771,  0.00868
        21,   17,     10,  0.73278""", useHeadersInDisplayName = true
    )
    fun `when 2k-1 ge n`(n: Int, k: Int, maxPts: Int, expected: Double) {
        val actual = solution.new21Game(n, k, maxPts)
        assertEquals(expected, actual, 0.00001)

    }
}