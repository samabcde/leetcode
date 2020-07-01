package q1021;

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
		String s = "()";
		String expected = "";
		String result = solution.removeOuterParentheses(s);
		assert (expected.equals(result));
		System.out.println(expected.equals(result));
	}

	private static void test2() {
		String s = "(()())(())";
		String expected = "()()()";
		String result = solution.removeOuterParentheses(s);
		assert (expected.equals(result));
		System.out.println(expected.equals(result));
	}

	private static void test3() {
		String s = "()()(()())(())()()";
		String expected = "()()()";
		String result = solution.removeOuterParentheses(s);
		assert (expected.equals(result));
		System.out.println(expected.equals(result));
	}

	private static void test4() {
		StringBuilder stringBuilder = new StringBuilder(10000);
		for (int i = 0; i < 10000; i++) {
			stringBuilder.append(i % 2 == 0 ? "(" : ")");
		}
		String s = stringBuilder.toString();
		String expected = "";
		String result = solution.removeOuterParentheses(s);
		assert (expected.equals(result));
		System.out.println(expected.equals(result));
	}

	private static void test5() {
		String s = "((((())))()())(())";
		String expected = "(((())))()()()";
		String result = solution.removeOuterParentheses(s);
		assert (expected.equals(result));
		System.out.println(expected.equals(result));
	}
}
