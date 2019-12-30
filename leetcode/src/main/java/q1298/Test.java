package q1298;

public class Test {
	public static Solution solution = new Solution();

	public static void main(String[] args) {
		test1();
		test2();
	}

	private static void test1() {
		int[] status = new int[] { 1, 1, 1 };
		int[] candies = new int[] { 100, 1, 100 };
		int[][] keys = new int[][] { new int[] {}, new int[] { 0, 2 }, new int[] {} };
		int[][] containedBoxes = new int[][] { new int[] {}, new int[] {}, new int[] {} };
		int[] initialBoxes = new int[] { 1 };
		int expected = 1;
		int result = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
		assert (expected == result);
		System.out.println(expected == result);
	}

	private static void test2() {
		int[] status = new int[] { 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0,
				1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0 };
		int[] candies = new int[] { 732, 320, 543, 300, 814, 568, 947, 685, 142, 111, 805, 233, 813, 306, 55, 1, 290,
				944, 36, 592, 150, 596, 372, 299, 644, 445, 605, 202, 64, 807, 753, 731, 552, 766, 119, 862, 453, 136,
				43, 572, 801, 518, 936, 408, 515, 215, 492, 738, 154 };
		int[][] keys = new int[][] { new int[] { 42, 2, 24, 8, 39, 16, 46 },
				new int[] { 20, 39, 46, 21, 32, 31, 43, 16, 12, 23, 3 },
				new int[] { 21, 14, 30, 2, 11, 13, 27, 37, 4, 48 }, new int[] { 16, 17, 15, 6 },
				new int[] { 31, 14, 3, 32, 35, 19, 42, 43, 44, 29, 25, 41 },
				new int[] { 7, 39, 2, 3, 40, 28, 37, 35, 43, 22, 6, 23, 48, 10, 21, 11 },
				new int[] { 27, 1, 37, 3, 45, 32, 30, 26, 16, 2, 35, 19, 31, 47, 5, 14 },
				new int[] { 28, 35, 23, 17, 6 }, new int[] { 6, 39, 34, 22 },
				new int[] { 44, 29, 36, 31, 40, 22, 9, 11, 17, 25, 1, 14, 41 },
				new int[] { 39, 37, 11, 36, 17, 42, 13, 12, 7, 9, 43, 41 }, new int[] { 23, 16, 32, 37 },
				new int[] { 36, 39, 21, 41 }, new int[] { 15, 27, 5, 42 },
				new int[] { 11, 5, 18, 48, 25, 47, 17, 0, 41, 26, 9, 29 },
				new int[] { 18, 36, 40, 35, 12, 33, 11, 5, 44, 14, 46, 7 }, new int[] { 48, 22, 11, 33, 14 },
				new int[] { 44, 12, 3, 31, 25, 15, 18, 28, 42, 43 }, new int[] { 36, 9, 0, 42 },
				new int[] { 1, 22, 3, 24, 9, 11, 43, 8, 35, 5, 41, 29, 40 },
				new int[] { 15, 47, 32, 28, 33, 31, 4, 43 }, new int[] { 1, 11, 6, 37, 28 },
				new int[] { 46, 20, 47, 32, 26, 15, 11, 40 }, new int[] { 33, 45, 26, 40, 12, 3, 16, 18, 10, 28, 5 },
				new int[] { 14, 6, 4, 46, 34, 9, 33, 24, 30, 12, 37 }, new int[] { 45, 24, 18, 31, 32, 39, 26, 27 },
				new int[] { 29, 0, 32, 15, 7, 48, 36, 26, 33, 31, 18, 39, 23, 34, 44 },
				new int[] { 25, 16, 42, 31, 41, 35, 26, 10, 3, 1, 4, 29 },
				new int[] { 8, 11, 5, 40, 9, 18, 10, 16, 26, 30, 19, 2, 14, 4 }, new int[] {},
				new int[] { 0, 20, 17, 47, 41, 36, 23, 42, 15, 13, 27 },
				new int[] { 7, 15, 44, 38, 41, 42, 26, 19, 5, 47 }, new int[] {}, new int[] { 37, 22 },
				new int[] { 21, 24, 15, 48, 33, 6, 39, 11 }, new int[] { 23, 7, 3, 29, 10, 40, 1, 16, 6, 8, 27 },
				new int[] { 27, 29, 25, 26, 46, 15, 16 }, new int[] { 33, 40, 10, 38, 13, 19, 17, 23, 32, 39, 7 },
				new int[] { 35, 3, 39, 18 }, new int[] { 47, 11, 27, 23, 35, 26, 43, 4, 22, 38, 44, 31, 1, 0 },
				new int[] {}, new int[] { 18, 43, 46, 9, 15, 3, 42, 31, 13, 4, 12, 39, 22 },
				new int[] { 42, 45, 47, 18, 26, 41, 38, 9, 0, 35, 8, 16, 29, 36, 31 },
				new int[] { 3, 20, 29, 12, 46, 41, 23, 4, 9, 27 }, new int[] { 19, 33 }, new int[] { 32, 18 },
				new int[] { 17, 28, 7, 35, 6, 22, 4, 43 },
				new int[] { 41, 31, 20, 28, 35, 32, 24, 23, 0, 33, 18, 39, 29, 30, 16 }, new int[] { 43, 47, 46 } };
		int[][] containedBoxes = new int[][] { new int[] { 14 }, new int[] {}, new int[] { 26 }, new int[] { 4, 47 },
				new int[] {}, new int[] { 6 }, new int[] { 39, 43, 46 }, new int[] { 30 }, new int[] {}, new int[] {},
				new int[] { 0, 3 }, new int[] {}, new int[] {}, new int[] {}, new int[] {}, new int[] { 27 },
				new int[] {}, new int[] {}, new int[] {}, new int[] {}, new int[] { 12 }, new int[] {}, new int[] {},
				new int[] { 41 }, new int[] {}, new int[] { 31 }, new int[] { 20, 29 }, new int[] { 13, 35 },
				new int[] { 18 }, new int[] { 10, 40 }, new int[] {}, new int[] { 38 }, new int[] {}, new int[] {},
				new int[] { 19 }, new int[] { 5 }, new int[] {}, new int[] {}, new int[] { 11 }, new int[] { 1 },
				new int[] { 15 }, new int[] {}, new int[] {}, new int[] {}, new int[] { 24 }, new int[] {},
				new int[] {}, new int[] {}, new int[] {} };
		int[] initialBoxes = new int[] { 2, 7, 8, 9, 16, 17, 21, 22, 23, 25, 28, 32, 33, 34, 36, 37, 42, 44, 45, 48 };
		int expected = 23185;
		int result = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
		assert (expected == result);
		System.out.println(expected == result);
	}
}
