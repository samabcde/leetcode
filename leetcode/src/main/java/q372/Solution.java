package q372;

class Solution {
	private static final int TARGET = 1337;
	private static final int PHI_TARGET = 1140;

	public int superPow(int a, int[] b) {
		int aModTarget = a % TARGET;
		if (aModTarget == 0 || aModTarget == 1) {
			return aModTarget;
		}
		if (aModTarget % 7 == 0) {
			return calculateByChineseRemainderTheorem(b, aModTarget, 7);
		}
		if (aModTarget % 191 == 0) {
			return calculateByChineseRemainderTheorem(b, aModTarget, 191);
		}
		return calculateByEularTheorem(b, aModTarget, TARGET, PHI_TARGET);
	}

	private int calculateByChineseRemainderTheorem(int[] b, int aModTarget, int divisible) {
		if (divisible == 7) {
			return (7 * calculateByEularTheorem(b, aModTarget, 191, 190) * 82) % TARGET;
		} else {
			return (191 * calculateByEularTheorem(b, aModTarget, 7, 6) * 4) % TARGET;
		}
	}

	private int calculateByEularTheorem(int[] b, int aModPrime, int target, int phiTarget) {
		int[] powerOfTenModPhiTarget;
		powerOfTenModPhiTarget = new int[b.length];

		int d = 0;
		for (int i = 0; i < b.length; i++) {
			int calculatePowerOfTenModPhiTarget = calculatePowerOfTenModPhiTarget(powerOfTenModPhiTarget, phiTarget, i);
			int digitOfPowerOfTen = b[b.length - 1 - i];
			if (digitOfPowerOfTen == 0) {
				continue;
			}
			d += (digitOfPowerOfTen * calculatePowerOfTenModPhiTarget) % (phiTarget);
			if (d > phiTarget) {
				d -= phiTarget;
			}
		}
		int result = 1;
		while (d > 0) {
			result *= aModPrime;
			result = result % target;
			d--;
		}
		return result;
	}

	private static int calculatePowerOfTenModPhiTarget(int[] powerOfTenModPhiTarget, int phiTarget, int powerOfTen) {
		if (powerOfTen == 0) {
			powerOfTenModPhiTarget[powerOfTen] = 1;
			return 1;
		}
		int result = (powerOfTenModPhiTarget[powerOfTen - 1] * 10) % phiTarget;
		powerOfTenModPhiTarget[powerOfTen] = result;
		return result;
	}

}