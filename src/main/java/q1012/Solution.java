package q1012;

class Solution {
	int[] POWER_OF_TEN = new int[] { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000,
			1_000_000_000 };

	private static int noOfUniqueDigit(int num) {
		int noOfUniqueDigit = 0;
		boolean[] isDigitExist = new boolean[10];
		while (num > 0) {
			int digit = num % 10;
			if (!isDigitExist[digit]) {
				noOfUniqueDigit++;
				isDigitExist[digit] = true;
			}
			num = num / 10;
		}
		return noOfUniqueDigit;
	}

	public int numDupDigitsAtMostN(int N) {

		int noOfUnique = 0;
		int power = 0;
		// 0-9
		// 10-99
		// 100-999
		// 1000-9999
		// ...
		// ABCDEFG
		// System.out.println(String.format("N:%s", N));
		while (power < 9 && N >= POWER_OF_TEN[power + 1] - 1) {
			noOfUnique += 9 * (nPr(9, power));
			power++;
			// System.out.println(String.format("noOfUnique:%s", noOfUnique));
		}
		// power = 6
		for (int i = 0; i <= power; i++) {
			int from = -1;
			int to = -1;
			if (i < power) {
				from = (i == 0 ? 1 : 0) + (i == 0 ? 0 : (N / (POWER_OF_TEN[power + 1 - i])) * POWER_OF_TEN[1]);
				to = N / (POWER_OF_TEN[power - i]) - 1;
			} else {
				from = (i == 0 ? 1 : 0) + ((N / (POWER_OF_TEN[power + 1 - i])) * POWER_OF_TEN[1]);
				to = N / (POWER_OF_TEN[power - i]);
			}
			// System.out.println(String.format("from:%s, to:%s", from, to));
			for (int j = from; j <= to; j++) {
				int noOfUniqueDigit = noOfUniqueDigit(j);
				if (noOfUniqueDigit == i + 1) {
					if (i == power) {
						if (noOfUniqueDigit == power + 1) {
							noOfUnique++;
						}
					} else {
						noOfUnique += nPr(10 - noOfUniqueDigit, power - i);
					}
				}
				// System.out.println(
				// String.format("j:%s, noOfUniqueDigit:%s, noOfUnique:%s", j, noOfUniqueDigit,
				// noOfUnique));
			}
		}
		// ABCDEFG
		// 1000000-(A-1)999999
		// A000000-(AB-1)99999
		// AB00000-(ABC-1)9999
		// ABC0000-(ABCD-1)999
		// ABCD000-(ABCDE-1)99
		// ABCDE00-(ABCDEF-1)9
		// ABCDEF0-ABCDEFG
		// System.out.println("result:" + (N - noOfUnique));
		return N - noOfUnique;
	}

	private static int nPr(int n, int r) {
		if (r == 0 || n == r) {
			return 1;
		}
		if (r > n) {
			throw new IllegalArgumentException(String.format("r:%s must less than n%s", r, n));
		}
		return productTo(n - r + 1, n);
	}

	private static int productTo(int from, int to) {
		int result = 1;
		for (int i = from; i <= to; i++) {
			result *= i;
		}
		return result;
	}
}