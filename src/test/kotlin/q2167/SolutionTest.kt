package q2167

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {
    var solution = Solution()

    @Test
    fun given_allCarContainIllegalGoods_should_returnNumberOfCars() {
        assertEquals(5, solution.minimumTime("11111"))
    }

    @Test
    fun given_middleCarContainIllegalGoods_should_return2() {
//        assertEquals(2, solution.minimumTime("010"))
        assertEquals(2, solution.minimumTime("00100"))
    }

    @Test
    fun given_middle2CarContainIllegalGoods_should_return3() {
        assertEquals(3, solution.minimumTime("0110"))
    }

    @Test
    fun given_010110_should_return5() {
        assertEquals(5, solution.minimumTime("010110"))
    }

    @Test
    fun given_01111100100111110_should_return14() {
        assertEquals(14, solution.minimumTime("01111100100111110"))
    }
    @Test
    fun given_0111001110_should_return8() {
        assertEquals(8, solution.minimumTime("0111001110"))
    }
    @Test
    fun given_10111111100000100101010111111001011110010101011110110101001110101010000_should_return65(){
        assertEquals(65, solution.minimumTime("10111111100000100101010111111001011110010101011110110101001110101010000"))
    }
    @Test
    fun given_10000CarContainIllegalGoodsAlternatively_should_return9999() {
        assertEquals(9999, solution.minimumTime("10".repeat(5000)))
    }

    @Test
    fun given_20000CarContainIllegalGoodsAlternatively_should_return19999() {
        assertEquals(19999, solution.minimumTime("10".repeat(10000)))
    }

    @Test
    fun given_18000CarContainIllegalGoods1in3_should_return11999() {
        assertEquals(11999, solution.minimumTime("100".repeat(6000)))
    }

    @Test
    fun given_leftHasLotsOf1_should_return25() {
        assertEquals(25, solution.minimumTime("011001111111101001010000001010011"))
    }

    @Test
    fun given_All_L_Same_As_All_A_should_return82() {
        assertEquals(
            82, solution.minimumTime(
                "" +
                        "01" +
                        "001" +
                        "0001" +
                        "00001" +
                        "000001" +
                        "0000001" +
                        "00000001" + // 35L 14A
                        "00000000000001111111111111111111111111111111111" + // 47L / 34*2=68A
                        "000000000000000000000000000000000000000000" +
                        "000000000000000000000000000000000000000000" +
                        "000000000000000000000000000000000000000000"
            )
        )
    }

    @Test
    fun given_All_L_Same_BetterThan_All_A_should_return82() {
        assertEquals(
            81, solution.minimumTime(
                "" +
                        "01" +
                        "001" +
                        "0001" +
                        "00001" +
                        "000001" +
                        "0000001" +
                        "00000001" + // 35L 14A
                        "0000000000001111111111111111111111111111111111" + // 46L / 34*2=68A
                        "000000000000000000000000000000000000000000" +
                        "000000000000000000000000000000000000000000" +
                        "000000000000000000000000000000000000000000"
            )
        )
    }

    @Test
    fun given_All_L_Same_WorseThan_All_A_should_return82() {
        assertEquals(
            80, solution.minimumTime(
                "" +
                        "01" +
                        "001" +
                        "0001" +
                        "00001" +
                        "000001" +
                        "0000001" +
                        "00000001" + // 35L 14A
                        "00000000000000111111111111111111111111111111111" + // 47L / 33*2=66A
                        "000000000000000000000000000000000000000000" +
                        "000000000000000000000000000000000000000000" +
                        "000000000000000000000000000000000000000000"
            )
        )
    }
}