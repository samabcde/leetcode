package q878;

public class Solution {
	private static final int MOD = 1_000_000_000 + 7;

	public int nthMagicalNumber(int N, int A, int B) {
		if (A == B) {
			return multiplyMod(N, A);
		}
		int min;
		int max;
		if (A > B) {
			max = A;
			min = B;
		} else {
			min = A;
			max = B;
		}
		int gcd = gcd(min, max);
		if (gcd == min) {
			return multiplyMod(N, min);
		}
		int noOfMultipleToLcm = min / gcd + max / gcd - 1;
		int lcmMultipyToN = N / noOfMultipleToLcm;
		int remain = N - lcmMultipyToN * noOfMultipleToLcm;
		if (remain == 0) {
			int lcm = multiplyMod(min / gcd, max);
			return multiplyMod(lcm, lcmMultipyToN);
		}
		int minMulti = 1;
		int maxMulti = 1;
		boolean isLastMin = true;
		while (remain > 0) {
			if (fromLeTo(min, max, minMulti, maxMulti)) {
				minMulti++;
				isLastMin = true;
			} else {
				maxMulti++;
				isLastMin = false;
			}
			remain--;
		}
		int lcm = multiplyMod(min / gcd, max);
		if (isLastMin) {
			return (int) (((long) multiplyMod(lcm, lcmMultipyToN) + (long) multiplyMod(min, minMulti - 1)) % MOD);
		} else {
			return (int) (((long) multiplyMod(lcm, lcmMultipyToN) + (long) multiplyMod(max, maxMulti - 1)) % MOD);
		}
	}

	private static boolean fromLeTo(int min, int max, int minMulti, int maxMulti) {
		long minMultiple = multiply(min, minMulti);
		long maxMultiple = multiply(max, maxMulti);
		return minMultiple <= maxMultiple;
	}

	private static long multiply(int x, int y) {
		return (long) x * (long) y;
	}

	private static int gcd(int min, int max) {
		if (max == min) {
			return max;
		}
		while (max > 0) {
			max = max % min;
			if (max == 1) {
				return 1;
			}
			if (max == 0) {
				return min;
			}
			int temp = max;
			max = min;
			min = temp;
		}
		return 1;
	}

	private static int multiplyMod(int x, int y) {
		x = x % MOD;
		y = y % MOD;
		return (int) (((long) x * (long) y) % MOD);
	}

}
