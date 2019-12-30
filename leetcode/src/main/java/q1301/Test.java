package q1301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	private static void test1() {
		int[] expected = new int[] { 7, 1 };
		List<String> board = Arrays.asList("E23", "2X2", "12S");
		int[] result = solution.pathsWithMaxScore(board);
		if (!Arrays.equals(expected, result)) {
			System.out.println(Arrays.toString(result));
		}
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test2() {
		int[] expected = new int[] { 4, 2 };
		List<String> board = Arrays.asList("E12", "1X1", "21S");
		int[] result = solution.pathsWithMaxScore(board);
		if (!Arrays.equals(expected, result)) {
			System.out.println(Arrays.toString(result));
		}
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test3() {
		int[] expected = new int[] { 0, 0 };
		List<String> board = Arrays.asList("E11", "XXX", "11S");
		int[] result = solution.pathsWithMaxScore(board);
		if (!Arrays.equals(expected, result)) {
			System.out.println(Arrays.toString(result));
		}
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test4() {
		int[] expected = new int[] { 17, 2 };
		List<String> board = Arrays.asList("E111111111", "1XXXXXXXX1", "1XXXXXXXX1", "1XXXXXXXX1", "1XXXXXXXX1",
				"1XXXXXXXX1", "1XXXXXXXX1", "1XXXXXXXX1", "1XXXXXXXX1", "111111111S");
		int[] result = solution.pathsWithMaxScore(board);
		if (!Arrays.equals(expected, result)) {
			System.out.println(Arrays.toString(result));
		}
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void test5() {
		int[] expected = new int[] { 197, 155788253 };
		List<String> board = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			StringBuilder stringBuilder = new StringBuilder(100);
			for (int j = 0; j < 100; j++) {
				if (i == 0 && j == 0) {
					stringBuilder.append('E');
				} else if (i == 99 && j == 99) {
					stringBuilder.append('S');
				} else if (i == j) {
					stringBuilder.append('X');
				} else {
					stringBuilder.append('1');
				}
			}
			board.add(stringBuilder.toString());
		}
		int[] result = solution.pathsWithMaxScore(board);
		if (!Arrays.equals(expected, result)) {
			System.out.println(Arrays.toString(result));
		}
		assert (Arrays.equals(expected, result));
		System.out.println(Arrays.equals(expected, result));
	}

	private static void testBoard() {
		for (int length = 2; length < 101; length++) {
			List<String> board = new ArrayList<String>();
			for (int i = 0; i < length; i++) {
				StringBuilder stringBuilder = new StringBuilder(length);
				for (int j = 0; j < length; j++) {
					if (i == 0 && j == 0) {
						stringBuilder.append('E');
					} else if (i == length - 1 && j == length - 1) {
						stringBuilder.append('S');
					} else if (i == j) {
						stringBuilder.append('X');
					} else {
						stringBuilder.append('1');
					}
				}
				board.add(stringBuilder.toString());
			}
			int[] result = solution.pathsWithMaxScore(board);
			System.out.println(Arrays.toString(result));
		}
	}
}
