package q1281;

class Solution {
	public int subtractProductAndSum(int n) {
		int digitProduct = 1;
		int digitSum = 0;
		while (n > 0) {
			int lastDigit = n % 10;
			n = n / 10;
			digitSum += lastDigit;
			if (digitProduct > 0) {
				digitProduct *= lastDigit;
			}
		}
		return digitProduct - digitSum;
	}
}