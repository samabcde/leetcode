package q665;

class Solution {
	public boolean checkPossibility(int[] nums) {
		boolean modifiedOnce = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				if (modifiedOnce) {
					return false;
				}
				boolean isLastDiffLessThanCurrentDiff = i == 0 || nums[i] - nums[i + 1] <= nums[i] - nums[i - 1];
				boolean isNextDiffLessThanCurrentDiff = i == nums.length - 2
						|| nums[i] - nums[i + 1] <= nums[i + 2] - nums[i + 1];
				if (isLastDiffLessThanCurrentDiff || isNextDiffLessThanCurrentDiff) {
					modifiedOnce = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}