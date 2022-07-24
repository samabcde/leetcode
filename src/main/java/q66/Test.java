package q66;

import java.util.Arrays;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	private static void test1() {
		int[] digits = new int[] { 1, 2, 3 };
		int[] expected = new int[] { 1, 2, 4 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test2() {
		int[] digits = new int[] { 0 };
		int[] expected = new int[] { 1 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test3() {
		int[] digits = new int[] { 9, 9, 9 };
		int[] expected = new int[] { 1, 0, 0, 0 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test4() {
		int[] digits = new int[] { 9, 2, 9 };
		int[] expected = new int[] { 9, 3, 0 };
		int[] result = solution.plusOne(digits);
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}
}
