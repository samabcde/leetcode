package q1108;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		String address = "1.1.1.1";
		String expected = "1[.]1[.]1[.]1";
		String result = solution.defangIPaddr(address);
		assert (expected.equals(result));
		System.out.println(expected.equals(result));
	}
}
