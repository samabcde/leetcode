package q488;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		String board = "R";
		String hand = "RR";
		int expected = 2;
		int result = solution.findMinStep(board, hand);
		if (expected != result) {
			System.out.println(result);
		}
		assert (expected == result);
		System.out.println(expected == result);
	}

}
