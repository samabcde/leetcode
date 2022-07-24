package q1269;

import java.util.Arrays;

class Solution {
	private static final int MOD = 1_000_000_007;

	public int numWays(int steps, int arrLen) {
		int end = Math.min(steps + 1, arrLen);
		int[][] dp = new int[steps + 1][end];
		for (int remainSteps = 0; remainSteps < steps + 1; remainSteps++) {
			int to = Math.min(remainSteps, end-1);
			for (int position = 0; position <= to; position++) {
				if (remainSteps == 0) {
					dp[remainSteps][position] = (position == 0 ? 1 : 0);
				} else {
					dp[remainSteps][position] += dp[remainSteps - 1][position];
					if (dp[remainSteps][position] > MOD) {
						dp[remainSteps][position] -= MOD;
					}
					if (position > 0) {
						dp[remainSteps][position] += dp[remainSteps - 1][position - 1];
						if (dp[remainSteps][position] > MOD) {
							dp[remainSteps][position] -= MOD;
						}
					}
					if (position < end - 1) {
						dp[remainSteps][position] += dp[remainSteps - 1][position + 1];
						if (dp[remainSteps][position] > MOD) {
							dp[remainSteps][position] -= MOD;
						}
					}
				}
			}
		}
		for (int remainSteps = 0; remainSteps < steps + 1; remainSteps++) {
			System.out.println(Arrays.toString(dp[remainSteps]));
		}
		return dp[steps][0];
	}
}