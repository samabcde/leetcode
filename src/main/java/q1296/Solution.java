package q1296;

import java.util.Arrays;

class Solution {
	public boolean isPossibleDivide(int[] nums, int k) {
		if (nums.length % k != 0) {
			return false;
		}
		if (k == 1) {
			return true;
		}
		Arrays.sort(nums);
		int groupNum = nums.length / k;
		int[] groupCurrents = new int[groupNum];
		int[] groupEnds = new int[groupNum];
		for (int i = 0; i < groupNum; i++) {
			groupCurrents[i] = 0;
			groupEnds[i] = 0;
		}
		int complete = -1;
		for (int i = 0; i < nums.length; i++) {
			boolean isSet = false;
			for (int j = complete + 1; j < groupNum; j++) {
				if (groupCurrents[j] == 0) {
					groupCurrents[j] = nums[i];
					groupEnds[j] = nums[i] + k - 1;
					isSet = true;
					break;
				} else if (groupCurrents[j] == nums[i]) {
					continue;
				} else if (groupCurrents[j] == nums[i] - 1) {
					groupCurrents[j]++;
					if (groupCurrents[j] == groupEnds[j]) {
						complete = j;
					}
					isSet = true;
					break;
				} else {
					return false;
				}
			}
			if (!isSet) {
				return false;
			}
		}
		return complete == groupNum - 1;
	}
}
