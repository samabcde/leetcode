package q1419;

class Solution {
	public int minNumberOfFrogs(String croakOfFrogs) {
		int[] frogs = new int[5];
		char[] croaks = croakOfFrogs.toCharArray();
		for (int i = 0; i < croaks.length; i++) {
			switch (croaks[i]) {
			case 'c': {
				if (frogs[0] == 0) {
					frogs[0]++;
				}
				frogs[0]--;
				frogs[1]++;
				break;
			}
			case 'r': {
				if (frogs[1] == 0) {
					return -1;
				}
				frogs[1]--;
				frogs[2]++;
				break;
			}
			case 'o': {
				if (frogs[2] == 0) {
					return -1;
				}
				frogs[2]--;
				frogs[3]++;
				break;
			}
			case 'a': {
				if (frogs[3] == 0) {
					return -1;
				}
				frogs[3]--;
				frogs[4]++;
				break;
			}
			case 'k': {
				if (frogs[4] == 0) {
					return -1;
				}
				frogs[4]--;
				frogs[0]++;
				break;
			}
			default:
				throw new IllegalArgumentException("unexpected char:" + croaks[i]);
			}
		}
		if (frogs[1] > 0 || frogs[2] > 0 || frogs[3] > 0 || frogs[4] > 0) {
			return -1;
		}
		return frogs[0];
	}
}