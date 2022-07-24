package q72;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
		test2();

	}

	private static void test1() {
		String word1 = "a";
		String word2 = "a";
		int expected = 0;
		int result = solution.minDistance(word1, word2);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		String word1 = "afbgchdi";
		String word2 = "fagbhcid";
		int expected = 5;
		int result = solution.minDistance(word1, word2);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
