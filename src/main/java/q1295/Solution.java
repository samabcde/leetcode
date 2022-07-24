package q1295;

class Solution {
	public int findNumbers(int[] nums) {
		int count = 0;
		for (int num : nums) {
			if (isEvenNumberOfDigit(num)) {
				count++;
			}
		}
		return count;
	}

	private boolean isEvenNumberOfDigit(int num) {
		boolean isEven = false;
		int result = num;
		while (true) {
			result = result / 10;
			if (result == 0) {
				return isEven;
			}
			isEven = !isEven;
		}
	}
}
