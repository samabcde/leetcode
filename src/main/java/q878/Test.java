package q878;

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
		int N = 2;
		int A = 3;
		int B = 7;
		int expected = 6;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int N = 9;
		int A = 3;
		int B = 7;
		int expected = 21;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		int N = 19;
		int A = 3;
		int B = 7;
		int expected = 45;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		int N = 12;
		int A = 6;
		int B = 9;
		int expected = 54;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		int N = 240_000_000;
		int A = 6;
		int B = 9;
		int expected = 79_999_993;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test6() {
		int N = 1_000_000_000;
		int A = 1_000_000_007;
		int B = 1_000_000_007;
		int expected = 0;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test7() {
		int N = 3;
		int A = 8;
		int B = 3;
		int expected = 8;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test8() {
		int N = 4;
		int A = 8;
		int B = 3;
		int expected = 9;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test9() {
		int N = 1000000000;
		int A = 40000;
		int B = 40000;
		int expected = 999720007;
		int result = solution.nthMagicalNumber(N, A, B);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}
}
