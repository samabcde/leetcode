package q964;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.junit.Assert;

class Solution {
	public static void main(String[] args) {
		Solution a = new Solution();
		System.out.println(a.leastOpsExpressTarget(3, 200));
		System.out.println(a.leastOpsExpressTarget(3, 929));
		System.out.println(a.leastOpsExpressTarget(3, 365));
		System.out.println(a.leastOpsExpressTarget(3, 7));
		System.out.println(a.leastOpsExpressTarget(3, 8));
		System.out.println(a.leastOpsExpressTarget(3, 9));
		System.out.println(a.leastOpsExpressTarget(3, 300));
		System.out.println(a.leastOpsExpressTarget(3, 100));
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

	private static int minOps = Integer.MAX_VALUE;

	private static void compute(int x, int target, int totalOps, int currentPower, boolean isExistCoef) {
		if (totalOps > minOps) {
			return;
		}
		if (target == 0 || target == 1) {
			int ops = totalOps + target * (currentPower - 1 + (totalOps == 0 ? 0 : 1));
			minOps = Math.min(ops, minOps);
			return;
		}
		int remain = target % x;

		if (remain == 0) {
			compute(x, target / x, totalOps, currentPower + 1, isExistCoef);
		} else {
			compute(x, (target - (remain)) / x, calculateOps(x, remain, currentPower, totalOps, isExistCoef),
					currentPower + 1, true);
			compute(x, (target + (x - remain)) / x, calculateOps(x, x - remain, currentPower, totalOps, isExistCoef),
					currentPower + 1, true);
		}
	}

	private static int calculateOps(int x, int coeff, int power, int totalOps, boolean isExistCoef) {
		return totalOps + (coeff) * (power == 0 ? 1 : power - 1) + (coeff - 1)
				+ (coeff != 0 && (totalOps != 0 || isExistCoef) ? 1 : 0);
	}

	public int leastOpsExpressTarget(int x, int target) {
		minOps = Integer.MAX_VALUE;
		if (target == x) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		compute(x, target, 0, 0, false);
		return minOps;
	}
}