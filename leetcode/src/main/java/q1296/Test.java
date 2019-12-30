package q1296;

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
		int[] nums = new int[] { 1, 2, 3 };
		int k = 2;
		boolean expected = false;
		boolean result = solution.isPossibleDivide(nums, k);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int[] nums = new int[] { 1, 1, 2, 2, 3, 3 };
		int k = 3;
		boolean expected = true;
		boolean result = solution.isPossibleDivide(nums, k);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int[] nums = new int[] { 1, 1, 2, 2, 3, 3 };
		int k = 2;
		boolean expected = false;
		boolean result = solution.isPossibleDivide(nums, k);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int[] nums = new int[] { 1, 2, 3, 3, 4, 5 };
		int k = 3;
		boolean expected = true;
		boolean result = solution.isPossibleDivide(nums, k);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int[] nums = new int[] { 1, 2, 3, 5, 6, 7, 8, 9 };
		int k = 4;
		boolean expected = false;
		boolean result = solution.isPossibleDivide(nums, k);
		assert (expected == result);
		System.out.println(expected == result);

	}
}
