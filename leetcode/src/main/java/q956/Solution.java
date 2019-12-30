package q956;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		Solution a = new Solution();
		// System.out.println("" + a.tallestBillboard(new int[] { 2, 2 }));
		System.out.println("" + a.tallestBillboard(new int[] { 5, 5, 5, 7, 8 }));
		System.out.println("" + a.tallestBillboard(new int[] { 4, 5, 5, 7, 8 }));
		System.out.println("" + a
				.tallestBillboard(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 }));
		System.out.println("" + a.tallestBillboard(
				new int[] { 175, 145, 180, 156, 151, 132, 131, 150, 154, 144, 137, 128, 156, 161, 150 }));
		System.out.println("" + a.tallestBillboard(
				new int[] { 187, 163, 197, 215, 219, 196, 201, 219, 199, 215, 192, 204, 177, 225, 191 }));

		System.out.println("" + a.tallestBillboard(
				new int[] { 33, 30, 41, 34, 37, 29, 26, 31, 42, 33, 38, 27, 33, 31, 35, 900, 900, 900, 900, 900 }));
	}

	public int tallestBillboard(int[] rods) {
		Arrays.sort(rods);
		return calculateTallest(rods, 0);
	}

	static Set<Container> computed = new HashSet<Container>();

	public static class Container {
		final int[] computed;

		public Container(int[] computed) {
			super();
			this.computed = computed;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((computed == null) ? 0 : Arrays.hashCode(computed));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Container other = (Container) obj;
			if (computed == null) {
				if (other.computed != null)
					return false;
			} else if (!Arrays.equals(computed, other.computed))
				return false;
			return true;
		}

	}

	/**
	 * @param rods
	 * @param maxHeight
	 * @return
	 */
	private int calculateTallest(int[] rods, int maxHeight) {
		Container e = new Container(rods);
		if (computed.contains(e)) {
			return 0;
		}
		computed.add(e);
		if (rods.length <= 1) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < rods.length; i++) {
			sum += rods[i];
		}
		int target;
		if (sum % 2 == 0) {
			target = sum / 2;
			int result = possibleSum(rods, target);
			if (result > 0) {
				return result;
			}
			for (int i = 0; i < rods.length; i++) {
				int[] removed = new int[rods.length - 1];
				for (int j = 0; j < rods.length - 1; j++) {
					removed[j] = rods[j >= i ? j + 1 : j];
				}
				if ((sum - rods[i]) / 2 < maxHeight) {
					return maxHeight;
				}
				maxHeight = Math.max(calculateTallest(removed, maxHeight), maxHeight);
			}
		} else {
			for (int i = 0; i < rods.length; i++) {
				if (rods[i] % 2 == 1) {
					int[] removed = new int[rods.length - 1];
					for (int j = 0; j < rods.length - 1; j++) {
						removed[j] = rods[j >= i ? j + 1 : j];
					}
					if ((sum - rods[i]) / 2 < maxHeight) {
						return maxHeight;
					}
					maxHeight = Math.max(calculateTallest(removed, maxHeight), maxHeight);
				}
			}
		}

		return maxHeight;
	}

	private static int possibleSum(int[] rods, int target) {
		int level = rods.length / 2;

		for (int i = level; i >= 1; i--) {
			if (findSum(rods, i, target)) {
				return target;
			}
		}
		return 0;
	}

	private static boolean findSum(int[] rods, int level, int target) {
		int[] lastExceed = null;
		for (int[] arr = initialize(level); isContinue(arr, rods.length);) {
			if (greaterThanLast(arr, lastExceed)) {
				incrementToNext(arr, rods.length, 0);
			} else {
				int sum = calculateSum(rods, arr);
				if (sum == target) {
					return true;
				}
				if (sum > target) {
					lastExceed = Arrays.copyOf(arr, arr.length);
					incrementToNext(arr, rods.length, 0);
				}
			}

			increment(arr, rods.length);

		}
		return false;
	}

	static boolean greaterThanLast(int[] arr, int[] lastExceed) {
		if (lastExceed == null) {
			return false;
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= lastExceed[arr.length - 1]) {
				return true;
			}
			if (arr[i] < lastExceed[i]) {
				return false;
			}
		}
		return true;
	}

	private static int calculateSum(int[] rods, int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += rods[arr[i]];
		}
		return sum;
	}

	private static int[] initialize(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		return arr;
	}

	private static boolean isContinue(int[] arr, int length) {
		return arr[0] != -1;

	}

	private static void increment(int[] arr, int length) {

		if (arr[0] == length - arr.length && arr[arr.length - 1] == length - 1) {
			arr[0] = -1;
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[arr.length - 1 - i] == length - 1 - i) {
				continue;
			}
			int n = arr[arr.length - 1 - i] + 1;
			for (int j = arr.length - 1 - i; j < arr.length; j++, n++) {
				arr[j] = n;
			}
			break;
		}
	}

	private static void incrementToNext(int[] arr, int length, int level) {
		for (int i = 0; i < level; i++) {
			arr[arr.length - 1 - i] = length - 1 - i;
		}
	}
}