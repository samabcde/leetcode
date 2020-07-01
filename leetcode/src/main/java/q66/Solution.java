package q66;

class Solution {

	public int[] plusOne(int[] digits) {
		boolean isAllNine = true;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 9) {
				isAllNine = false;
				break;
			}
		}
		if (isAllNine) {
			int[] result = new int[digits.length + 1];
			result[0] = 1;
			return result;
		}
		for (int i = 0; i < digits.length; i++) {
			if (digits[digits.length - 1 - i] == 9) {
				digits[digits.length - 1 - i] = 0;
			} else {
				digits[digits.length - 1 - i]++;
				break;
			}
		}
		return digits;
	}
}