package q66;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionTest {
	public static Solution solution = new Solution();

	@Test
	public void test1() {
		int[] digits = new int[] { 1, 2, 3 };
		int[] expected = new int[] { 1, 2, 4 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	@Test
	public void test2() {
		int[] digits = new int[] { 0 };
		int[] expected = new int[] { 1 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	@Test
	public void test3() {
		int[] digits = new int[] { 9, 9, 9 };
		int[] expected = new int[] { 1, 0, 0, 0 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	@Test
	public void test4() {
		int[] digits = new int[] { 9, 2, 9 };
		int[] expected = new int[] { 9, 3, 0 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}
}
