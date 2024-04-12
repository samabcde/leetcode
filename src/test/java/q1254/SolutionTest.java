package q1254;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void singleLandWithoutWater_countAs0() {
        int[][] input = build("0");

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void singleLandTopBottomWater_countAs0() {
        int[][] input = build("""
                1
                0
                1
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void singleLandLeftRightWater_countAs0() {
        int[][] input = build("""
                101
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void singleLandBottomTopLeftRightWater_countAs1() {
        int[][] input = build("""
                111
                101
                111
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(1, actual);
    }

    @Test
    void multipleLandBottomTopLeftRightWater_countAs1() {
        int[][] input = build("""
                1111
                1001
                1111
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(1, actual);
    }

    @Test
    void multipleIslandSurroundByWater_countAsMultiple() {
        int[][] input = build("""
                1111
                1011
                1101
                1111
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(2, actual);
    }

    @Test
    void islandTouchTopSide_countAs0() {
        int[][] input = build("""
                101
                101
                111
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void islandTouchLeftSide_countAs0() {
        int[][] input = build("""
                111
                001
                111
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void islandTouchRightSide_countAs0() {
        int[][] input = build("""
                111
                100
                111
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void islandTouchBottomSide_countAs0() {
        int[][] input = build("""
                111
                101
                101
                """
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    @Test
    void maxIsland_countAs0() {
        int[][] input = build(
                ("0".repeat(1000) + "\n").repeat(1000)
        );

        int actual = solution.closedIsland(input);

        assertEquals(0, actual);
    }

    private int[][] build(String map) {
        return Arrays.stream(map.split("\n")).map(
                it -> {
                    int[] row = new int[it.length()];
                    for (int i = 0; i < row.length; i++) {
                        row[i] = it.charAt(i) == '0' ? 0 : 1;
                    }
                    return row;
                }
        ).toList().toArray(new int[][]{});
    }
}