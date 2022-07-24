package q1250;

class Solution {
	public boolean isGoodArray(int[] nums) {
		int gcd = nums[0];
		for (int i = 1; i < nums.length; i++) {
			gcd = gcd(gcd, nums[i]);
			if (gcd == 1) {
				return true;
			}
		}
		return gcd == 1;
	}

	private static int gcd(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
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
		return 0;
	}
}