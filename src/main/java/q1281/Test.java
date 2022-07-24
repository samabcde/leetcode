package q1281;

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
		int n = 1;
		int expected = 0;
		int result = solution.subtractProductAndSum(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int n = 10;
		int expected = -1;
		int result = solution.subtractProductAndSum(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int n = 12345;
		int expected = 105;
		int result = solution.subtractProductAndSum(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int n = 990;
		int expected = -18;
		int result = solution.subtractProductAndSum(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int n = 9999;
		int expected = 6525;
		int result = solution.subtractProductAndSum(n);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
