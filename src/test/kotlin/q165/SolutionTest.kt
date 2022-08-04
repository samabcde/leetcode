package q165

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {
    var solution = Solution()

    @Test
    fun `given version1 and version2 are 0 should return 0`() {
        assertEquals(0, solution.compareVersion("0", "0"))
    }

    @Test
    fun `given version1 is 00 version2 is 0 should return 0`() {
        assertEquals(0, solution.compareVersion("00", "0"))
    }

    @Test
    fun `given version1 and version2 are 1 should return 0`() {
        assertEquals(0, solution.compareVersion("1", "1"))
    }

    @Test
    fun `given version1 is 01 and version2 are 1 should return 0`() {
        assertEquals(0, solution.compareVersion("01", "1"))
    }

    @Test
    fun `given version1 is Int max and version2 is Int max should return 0`() {
        assertEquals(0, solution.compareVersion("${Int.MAX_VALUE}", "${Int.MAX_VALUE}"))
    }

    @Test
    fun `given both has same revision1 and version1 has revision2 as 0 and version2 has no revision2 should return 0`() {
        assertEquals(0, solution.compareVersion("0.0", "0"))
    }

    @Test
    fun `given version1 is 2 and version2 is 1 should return 1`() {
        assertEquals(1, solution.compareVersion("2", "1"))
    }

    @Test
    fun `given version1 is Int max and version2 is 1 should return 1`() {
        assertEquals(1, solution.compareVersion("${Int.MAX_VALUE}", "1"))
    }

    @Test
    fun `given version1 is 1_1_2 and version2 is 1_1_1 should return 1`() {
        assertEquals(1, solution.compareVersion("1.1.2", "1.1.1"))
    }

    @Test
    fun `given version1 is 1 and version2 is 2 should return -1`() {
        assertEquals(-1, solution.compareVersion("1", "2"))
    }

    @Test
    fun `given version1 is 1 and version2 is Int max should return -1`() {
        assertEquals(-1, solution.compareVersion("1", "${Int.MAX_VALUE}"))
    }

    @Test
    fun `given version1 is 1_1_1 and version2 is 1_1_2 should return -1`() {
        assertEquals(-1, solution.compareVersion("1.1.1", "1.1.2"))
    }

    @Test
    fun `given version1 are version2 same with 500 char should return 0`() {
        assertEquals(0, solution.compareVersion("01" + ".1".repeat(249), "01" + ".1".repeat(249)))
    }

    @Test
    fun `given version1 are version2 with 500 char and version1 is greater than version2 is last revision should return 1`() {
        assertEquals(1, solution.compareVersion("1" + ".1".repeat(248) + ".11", "1" + ".1".repeat(248)+".10"))
    }
    @Test
    fun `given version1 are version2 with 500 char and version1 is smaller than version2 is last revision should return -1`() {
        assertEquals(-1, solution.compareVersion("1" + ".1".repeat(248) + ".10", "1" + ".1".repeat(248)+".11"))
    }
}