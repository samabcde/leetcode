package q1012;

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
		test10();
		test11();
		test12();
		test13();
	}

	private static void test1() {
		int n = 1;
		int expected = 0;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int n = 10;
		int expected = 0;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int n = 101;
		int expected = 11;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int n = 1000;
		int expected = 262;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int n = 1009;
		int expected = 271;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test6() {
		int n = 7654321;
		int expected = 7077801;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test7() {
		int n = 321;
		int expected = 69;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test8() {
		int n = 4321;
		int expected = 1887;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test9() {
		int n = 21;
		int expected = 1;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test10() {
		int n = 1234567;
		int expected = 1058291;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test11() {
		int n = 1234;
		int expected = 431;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test12() {
		int n = 1234321;
		int expected = 1058051;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test13() {
		int n = 1_000_000_000;
		int expected = 994388230;
		int result = solution.numDupDigitsAtMostN(n);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
