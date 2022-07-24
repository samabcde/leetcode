package q1269;

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
	}

	private static void test1() {
		int steps = 1;
		int arrLen = 1;
		int expected = 1;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int steps = 2;
		int arrLen = 1;
		int expected = 1;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int steps = 2;
		int arrLen = 2;
		int expected = 2;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int steps = 3;
		int arrLen = 4;
		int expected = 4;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int steps = 4;
		int arrLen = 4;
		int expected = 9;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test6() {
		int steps = 500;
		int arrLen = 1_000_000;
		int expected = 374847123;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println("" + result + (expected == result));
	}

	private static void test7() {
		int steps = 10;
		int arrLen = 1_000_000;
		int expected = 2188;
		int result = solution.numWays(steps, arrLen);
		assert (expected == result);
		System.out.println("" + result + (expected == result));
	}
}
