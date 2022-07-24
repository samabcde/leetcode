package q1307;

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
	}

	private static void test1() {
		boolean expected = true;
		String[] words = new String[] { "A" };
		String expressionResult = "A";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		boolean expected = false;
		String[] words = new String[] { "A", "A" };
		String expressionResult = "AB";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test3() {
		boolean expected = true;
		String[] words = new String[] { "A", "B" };
		String expressionResult = "AC";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test4() {
		boolean expected = false;
		String[] words = new String[] { "AB", "BC" };
		String expressionResult = "DC";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test5() {
		boolean expected = true;
		String[] words = new String[] { "ABB", "BCC" };
		String expressionResult = "DEFG";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test6() {
		boolean expected = true;
		String[] words = new String[] { "THIS", "IS", "TOO" };
		String expressionResult = "FUNNY";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test7() {
		boolean expected = true;
		String[] words = new String[] { "SIX", "SEVEN", "SEVEN" };
		String expressionResult = "TWENTY";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test8() {
		boolean expected = true;
		String[] words = new String[] { "HJJDJJJ", "HJJJEJJ", "HJJJJFJ", "IJJJJJG", "IBCJJJJ" };
		String expressionResult = "ABCDEFG";
		boolean result = solution.isSolvable(words, expressionResult);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
