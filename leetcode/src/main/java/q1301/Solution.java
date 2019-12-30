package q1301;

import java.util.List;

class Solution {
	private static final int PATH_MOD = 1000000007;
	static int boardSize;

	public int[] pathsWithMaxScore(List<String> board) {
		int[] output = new int[2];
		boardSize = board.size();
		Square[] squares = new Square[boardSize * boardSize];
		for (int i = 0; i < boardSize; i++) {
			String row = board.get(i);
			char[] cols = row.toCharArray();
			for (int j = 0; j < cols.length; j++) {
				Square square = new Square(i, j, cols[j]);
				squares[i * boardSize + j] = square;
			}
		}
		computeMaxScorePaths(squares);
		Square start = squares[squares.length - 1];
		output[0] = start.maxScoreToEnd;
		output[1] = start.noOfPathMaxScoreToEnd;
		return output;
	}

	private static void computeMaxScorePath(Square square, Square[] squares) {
		if (square.isEnd || square.isObstacle) {
			return;
		}
		int maxScoreToEndU = 0;
		int noOfPathMaxScoreToEndU = 0;
		int maxScoreToEndL = 0;
		int noOfPathMaxScoreToEndL = 0;
		int maxScoreToEndUL = 0;
		int noOfPathMaxScoreToEndUL = 0;
		Square squareU = null;
		Square squareL = null;
		Square squareUL = null;
		if (square.rowIndex > 0 && square.colIndex > 0) {
			squareU = squares[(square.rowIndex - 1) * boardSize + square.colIndex];
			squareL = squares[(square.rowIndex) * boardSize + square.colIndex - 1];
			squareUL = squares[(square.rowIndex - 1) * boardSize + square.colIndex - 1];
			if (squareU != null && !squareU.isObstacle && squareU.noOfPathMaxScoreToEnd > 0) {
				noOfPathMaxScoreToEndU = squareU.noOfPathMaxScoreToEnd;
				maxScoreToEndU = squareU.maxScoreToEnd;
			}
			if (squareL != null && !squareL.isObstacle && squareL.noOfPathMaxScoreToEnd > 0) {
				noOfPathMaxScoreToEndL = squareL.noOfPathMaxScoreToEnd;
				maxScoreToEndL = squareL.maxScoreToEnd;
			}
			if (noOfPathMaxScoreToEndU > 0 || noOfPathMaxScoreToEndL > 0) {
				int maxScoreToEnd = Math.max(maxScoreToEndU, maxScoreToEndL);
				int noOfPathMaxScoreToEnd = 0;
				if (maxScoreToEndU == maxScoreToEnd) {
					noOfPathMaxScoreToEnd += noOfPathMaxScoreToEndU;
				}
				if (maxScoreToEndL == maxScoreToEnd) {
					noOfPathMaxScoreToEnd += noOfPathMaxScoreToEndL;
				}
				square.maxScoreToEnd = maxScoreToEnd + square.score;
				if (noOfPathMaxScoreToEnd > PATH_MOD) {
					square.noOfPathMaxScoreToEnd = noOfPathMaxScoreToEnd % PATH_MOD;
				} else {
					square.noOfPathMaxScoreToEnd = noOfPathMaxScoreToEnd;
				}
				return;
			}
			if (squareUL != null && !squareUL.isObstacle && squareUL.noOfPathMaxScoreToEnd > 0) {
				noOfPathMaxScoreToEndUL = squareUL.noOfPathMaxScoreToEnd;
				maxScoreToEndUL = squareUL.maxScoreToEnd;
			}
			if (noOfPathMaxScoreToEndU == 0 && noOfPathMaxScoreToEndL == 0 && noOfPathMaxScoreToEndUL == 0) {
				return;
			}
			square.maxScoreToEnd = maxScoreToEndUL + square.score;
			square.noOfPathMaxScoreToEnd = noOfPathMaxScoreToEndUL;
			return;
		}
		if (square.rowIndex > 0 && square.colIndex == 0) {
			squareU = squares[(square.rowIndex - 1) * boardSize + square.colIndex];
			if (squareU.noOfPathMaxScoreToEnd == 0) {
				return;
			}
			square.maxScoreToEnd = squareU.maxScoreToEnd + square.score;
			square.noOfPathMaxScoreToEnd = squareU.noOfPathMaxScoreToEnd;
			return;
		}
		if (square.rowIndex == 0 && square.colIndex > 0) {
			squareL = squares[(square.rowIndex) * boardSize + square.colIndex - 1];
			if (squareL.noOfPathMaxScoreToEnd == 0) {
				return;
			}
			square.maxScoreToEnd = squareL.maxScoreToEnd + square.score;
			square.noOfPathMaxScoreToEnd = squareL.noOfPathMaxScoreToEnd;
			return;
		}
	}

	private static void computeMaxScorePaths(Square[] squares) {
		int length = boardSize;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				Square squareIJ = squares[boardSize * i + j];
				computeMaxScorePath(squareIJ, squares);
				Square squareJI = squares[boardSize * j + i];
				computeMaxScorePath(squareJI, squares);
			}
			Square squareII = squares[boardSize * i + i];
			computeMaxScorePath(squareII, squares);
		}
	}

	private static class Square {
		private final int rowIndex;
		private final int colIndex;
		private int score = 0;
		private boolean isEnd = false;
		private boolean isObstacle = false;
		private int noOfPathMaxScoreToEnd = 0;
		private int maxScoreToEnd = 0;

		Square(int rowIndex, int colIndex, char value) {
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
			switch (value) {
			case '1':
				this.score = 1;
				break;
			case '2':
				this.score = 2;
				break;
			case '3':
				this.score = 3;
				break;
			case '4':
				this.score = 4;
				break;
			case '5':
				this.score = 5;
				break;
			case '6':
				this.score = 6;
				break;
			case '7':
				this.score = 7;
				break;
			case '8':
				this.score = 8;
				break;
			case '9':
				this.score = 9;
				break;
			case 'X':
				this.isObstacle = true;
				break;
			case 'E':
				this.isEnd = true;
				this.noOfPathMaxScoreToEnd = 1;
				break;
			case 'S':
				break;
			}
		}
	}
}
