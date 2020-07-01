package q665;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
	}

	private static void test1() {
		int[] nums = new int[] { 1, 2, 3 };
		boolean expected = true;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int[] nums = new int[] { 3, 2, 3 };
		boolean expected = true;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int[] nums = new int[] { 3, 2, 2, 4 };
		boolean expected = true;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int[] nums = new int[] { 3, 2, 5, 2 };
		boolean expected = false;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int[] nums = new int[] { 3, 4, 2, 3 };
		boolean expected = false;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test6() {
		int[] nums = new int[] { 3, 4, 2, 5 };
		boolean expected = true;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test7() {
		int[] nums = new int[] { 2, 4, 2, 3 };
		boolean expected = true;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test8() {
		int[] nums = new int[] { 2, 4, 2, 4 };
		boolean expected = true;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test9() {
		int[] nums = new int[] { 2, 4, 2, 4, 5, 4 };
		boolean expected = false;
		boolean result = solution.checkPossibility(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
