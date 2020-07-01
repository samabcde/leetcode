package q1419;

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
		String croakOfFrogs = "croak";
		int expected = 1;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		String croakOfFrogs = "ccrrooaakk";
		int expected = 2;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		String croakOfFrogs = "ccrcroroaakkoak";
		int expected = 3;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		String croakOfFrogs = "rcccroroaakkoak";
		int expected = -1;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		String croakOfFrogs = "ccrrookkaa";
		int expected = -1;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test6() {
		String croakOfFrogs = "croakc";
		int expected = -1;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test7() {
		String croakOfFrogs = "croackroackroackroackroackroak";
		int expected = 2;
		int result = solution.minNumberOfFrogs(croakOfFrogs);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
