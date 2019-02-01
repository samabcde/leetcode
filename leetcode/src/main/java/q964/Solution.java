package q964;

import java.util.HashMap;
import java.util.Map;

//import org.junit.Assert;

class Solution {
	public static void main(String[] args) {
		Solution a = new Solution();
		System.out.println(a.leastOpsExpressTarget(3, 365));
		System.out.println(a.leastOpsExpressTarget(3, 7));
		System.out.println(a.leastOpsExpressTarget(3, 8));
		System.out.println(a.leastOpsExpressTarget(3, 9));
		System.out.println(a.leastOpsExpressTarget(3, 300));
		System.out.println(a.leastOpsExpressTarget(3, 19));
		System.out.println(a.leastOpsExpressTarget(5, 501));
		System.out.println(a.leastOpsExpressTarget(100, 100000000));
		System.out.println(a.leastOpsExpressTarget(4, 7));
		System.out.println(a.leastOpsExpressTarget(2, 7));
		System.out.println(a.leastOpsExpressTarget(2, 10));
		System.out.println(a.leastOpsExpressTarget(2, 12));
		System.out.println(a.leastOpsExpressTarget(2, 15));
		System.out.println(a.leastOpsExpressTarget(100, 99));
	}

	public int leastOpsExpressTarget(int x, int target) {
		if (target == x) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}

		int maxPower = getMaxPower(x, target);
		int[] coeffsStartWith0 = new int[maxPower + 1];

		coeffsStartWith0[maxPower] = 0;

		int[] coeffsStartWith1 = new int[maxPower + 1];

		coeffsStartWith1[maxPower] = 1;

		int remainFor0 = target;
		int remainFor1 = target - power(x, maxPower);
		if (remainFor1 == 0) {
			return maxPower - 1;
		}
		for (int i = maxPower - 1; i > -1; i--) {
			int coef0 = getClosetCoef(remainFor0, i, x);
			int coef1 = getClosetCoef(remainFor1, i, x);
			coeffsStartWith0[i] = coef0;
			coeffsStartWith1[i] = coef1;
			remainFor0 -= coef0 * power(x, i);
			remainFor1 -= coef1 * power(x, i);
		}
		int noOps0 = 0;
		int noOps1 = 0;
		int nonZeroCoeff0 = 0;
		int nonZeroCoeff1 = 0;
		for (int i = 0; i < maxPower + 1; i++) {
			if (coeffsStartWith0[i] != 0) {
				nonZeroCoeff0++;
			}
			if (coeffsStartWith1[i] != 0) {
				nonZeroCoeff1++;
			}
			if (i == 0) {
				if (coeffsStartWith0[i] != 0) {
					noOps0 += 2 * Math.abs(coeffsStartWith0[i]) - 1;
				}
				if (coeffsStartWith1[i] != 0) {
					noOps1 += 2 * Math.abs(coeffsStartWith1[i]) - 1;
				}
			} else {
				if (coeffsStartWith0[i] != 0) {
					noOps0 += (i - 1) * Math.abs(coeffsStartWith0[i]) + Math.abs(coeffsStartWith0[i]) - 1;
				}
				if (coeffsStartWith1[i] != 0) {
					noOps1 += (i - 1) * Math.abs(coeffsStartWith1[i]) + Math.abs(coeffsStartWith1[i]) - 1;
				}
			}
		}
		noOps0 += (nonZeroCoeff0 - 1);
		noOps1 += (nonZeroCoeff1 - 1);
		return Math.min(noOps0, noOps1);
	}

	private int getClosetCoef(int remain, int power, int x) {
		if (remain == 0) {
			return 0;
		}
		int xToPower = power(x, power);
		if (remain > 0) {
			for (int i = 0; i < x; i++) {
				if ((remain - (i * xToPower) >= 0) && (remain - ((i + 1) * xToPower) < 0)) {
					if ((remain - (i * xToPower)) <= -(remain - ((i + 1) * xToPower))) {
						return i;
					} else {
						return (i + 1);
					}
				}
			}
		} else {
			for (int i = 0; i < x; i++) {
				if ((remain + (i * xToPower) <= 0) && (remain + ((i + 1) * xToPower) > 0)) {
					if (-(remain + (i * xToPower)) <= (remain + ((i + 1) * xToPower))) {
						return -i;
					} else {
						return -(i + 1);
					}
				}
			}
		}
		throw new RuntimeException("");
	}

	private int getMaxPower(int x, int target) {
		for (int i = 1; i < 10000; i++) {
			if (power(x, i) >= target) {
				return i;
			}
		}
		throw new RuntimeException("");
	}

	public int power(int x, int power) {
		if (power == 0) {
			return 1;
		}
		int result = 1;
		for (int i = 0; i < power; i++) {
			result = result * x;
		}
		return result;
	}
}