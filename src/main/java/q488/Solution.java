package q488;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int findMinStep(String board, String hand) {
		return 0;
	}

	private static String reduce(String board, char added, int addIndex) {
		StringBuilder stringBuilder = new StringBuilder(board);
		stringBuilder.insert(addIndex, added);

		if (addIndex > 0 && addIndex < board.length()) {
		} else if (addIndex == 0) {

		} else if (addIndex == board.length()) {

		}
		return "";
	}

	private static int minStepRemains(String board, List<Character> hands) {
		if (board.isEmpty()) {
			return 0;
		}
		if (!isPossibleToSolve(board, hands)) {
			return -1;
		}
		for (int i = 0; i <= board.length(); i++) {
			int minStep = -1;
			for (int j = 0; j < hands.size(); j++) {
				List<Character> next = new ArrayList<>(hands);
				next.remove(j);
				int minStepI = minStepRemains(reduce(board, hands.get(i), i), next);
				if (minStepI > -1) {
					if (minStep > -1) {
						minStep = Math.min(minStep, minStepI);
					} else {
						minStep = minStepI;
					}
				}
			}
		}
		return 0;
	}

	private static boolean isPossibleToSolve(String board, List<Character> hand) {
		return false;
	}
}