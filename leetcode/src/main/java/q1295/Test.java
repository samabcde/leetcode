package q1295;

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
		int expected = 0;
		int result = solution.findNumbers(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int[] nums = new int[] { 10, 2000, 300 };
		int expected = 2;
		int result = solution.findNumbers(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int[] nums = new int[] { 99999, 2, 300 };
		int expected = 0;
		int result = solution.findNumbers(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int[] nums = new int[] {};
		int expected = 0;
		int result = solution.findNumbers(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int[] nums = new int[] { 1 };
		int expected = 0;
		int result = solution.findNumbers(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
