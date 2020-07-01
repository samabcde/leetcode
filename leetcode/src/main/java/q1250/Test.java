package q1250;

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
		int[] nums = new int[] { 1 };
		boolean expected = true;
		boolean result = solution.isGoodArray(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int[] nums = new int[] { 2, 4, 6, 8, 99 };
		boolean expected = true;
		boolean result = solution.isGoodArray(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int[] nums = new int[] { 3, 6, 9, 12 };
		boolean expected = false;
		boolean result = solution.isGoodArray(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int[] nums = new int[] { 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };
		boolean expected = false;
		boolean result = solution.isGoodArray(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int[] nums = new int[100000];
		for (int i = 0; i < 100000; i++) {
			nums[i] = i * 2 + 2;
			if (i == 99999) {
				nums[i]--;
			}
		}
		boolean expected = true;
		boolean result = solution.isGoodArray(nums);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
