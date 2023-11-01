package q1920;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void Given_singleElementArray_Should_returnSingleElementArray() {
        int[] input = {0};
        int[] actual = solution.buildArray(input);
        int[] expected = {0};
        assertArrayEquals(expected, actual);
    }

    @Test
    void Given_multipleElementArray_Should_returnArrayWithSameLength() {
        int[] input = {0, 1};
        int[] actual = solution.buildArray(input);

        assertEquals(2, actual.length);
    }

    @Test
    void test() {
        int[] input = {1, 0};
        int[] actual = solution.buildArray(input);
        int[] expected = {0, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testMaxLength() {
        int[] input = new int[1000];
        for (int i = 0; i < input.length; i++) {
            input[i] = i;
        }
        int[] actual = solution.buildArray(input);
        int[] expected = input;
        assertArrayEquals(expected, actual);
    }
}