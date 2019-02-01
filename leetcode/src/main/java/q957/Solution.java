package q957;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public int[] prisonAfterNDays(int[] cells, int N) {
		PrisonState initial = new PrisonState(cells);
		List<PrisonState> prisonStates = new ArrayList<PrisonState>();
		prisonStates.add(initial);
		int remainingDay = N;
		PrisonState nextState = initial;
		while (remainingDay > 0) {
			remainingDay--;
			nextState = nextState.computeNextDateState();
			int alreadyExistState = prisonStates.indexOf(nextState);
			if (alreadyExistState > -1) {
				return prisonStates
						.get(alreadyExistState + (remainingDay % (prisonStates.size() - alreadyExistState))).cells;
			}
			prisonStates.add(nextState);
		}
		return prisonStates.get(N).cells;
	}

	static class PrisonState {
		int[] cells;

		public PrisonState(int[] cells) {
			this.cells = cells;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof PrisonState)) {
				return false;
			}
			return Arrays.equals(this.cells, ((PrisonState) other).cells);
		}

		public PrisonState computeNextDateState() {
			int[] nextCells = Arrays.copyOf(this.cells, 8);
			for (int i = 0; i < 8; i++) {
				if (i == 0) {
					nextCells[0] = 0;
					continue;
				}
				if (i == 7) {
					nextCells[7] = 0;
					continue;
				}
				if ((this.cells[i - 1] == 0 && this.cells[i + 1] == 0)
						|| (this.cells[i - 1] == 1 && this.cells[i + 1] == 1)) {
					nextCells[i] = 1;
				} else {
					nextCells[i] = 0;
				}
			}
			return new PrisonState(nextCells);
		}
	}
}
