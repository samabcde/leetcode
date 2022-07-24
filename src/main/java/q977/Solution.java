package q977;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		Solution a = new Solution();
		System.out.println(Arrays.toString(a.sortedSquares(new int[] { -2, 0, 1 })));
	}

	public int[] sortedSquares(int[] A) {
		if (A.length == 0) {
			return A;
		}
		int changeSignIndex = -1;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < 0 && A[i + 1] >= 0) {
				changeSignIndex = i;
				break;
			}
		}
		if (changeSignIndex == -1) {
			boolean reverse = false;
			if (A[0] < 0) {
				reverse = true;
			}
			for (int i = 0; i < A.length; i++) {
				A[i] = A[i] * A[i];
			}
			if (reverse) {
				for (int i = 0; i < A.length / 2; i++) {
					int temp = A[i];
					A[i] = A[A.length - i - 1];
					A[A.length - i - 1] = temp;
				}
			}
			return A;
		}
		int[] sorted = new int[A.length];
		int negativeStart = changeSignIndex;
		int positiveStart = changeSignIndex + 1;
		int sortedIndex = 0;
		while (negativeStart > -1 || positiveStart < A.length) {
			if (negativeStart == -1) {
				sorted[sortedIndex] = A[positiveStart] * A[positiveStart];
				positiveStart++;
			} else if (positiveStart == A.length) {
				sorted[sortedIndex] = A[negativeStart] * A[negativeStart];
				negativeStart--;
			} else if (-A[negativeStart] < A[positiveStart]) {
				sorted[sortedIndex] = A[negativeStart] * A[negativeStart];
				negativeStart--;
			} else {
				sorted[sortedIndex] = A[positiveStart] * A[positiveStart];
				positiveStart++;
			}
			sortedIndex++;
		}
		return sorted;
	}
}
