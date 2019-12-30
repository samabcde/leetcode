package q1298;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Solution {
	public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
		int candiesFromBox = 0;
		Set<Integer> pendingBoxes = new HashSet<Integer>();
		Deque<Integer> canOpenBoxes = new LinkedList<Integer>();
		for (int i = 0; i < initialBoxes.length; i++) {
			int initialBoxIndex = initialBoxes[i];
			if (status[initialBoxIndex] == 0) {
				pendingBoxes.add(initialBoxIndex);
			} else {
				canOpenBoxes.push(initialBoxIndex);
			}
		}
		while (!canOpenBoxes.isEmpty()) {
			Integer canOpenBox = canOpenBoxes.pop();
			candiesFromBox += candies[canOpenBox];
			for (int keyIndex : keys[canOpenBox]) {
				status[keyIndex] = 1;
				if (pendingBoxes.remove(keyIndex)) {
					canOpenBoxes.push(keyIndex);
				}
			}
			for (int boxIndex : containedBoxes[canOpenBox]) {
				if (status[boxIndex] == 1) {
					canOpenBoxes.push(boxIndex);
				} else {
					pendingBoxes.add(boxIndex);
				}
			}
		}
		return candiesFromBox;
	}
}
