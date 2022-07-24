package q1021;

class Solution {
	public String removeOuterParentheses(String S) {
		StringBuilder stringBuilder = new StringBuilder();
		char[] values = S.toCharArray();
		int unbalancedCount = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == '(') {
				if (unbalancedCount > 0) {
					stringBuilder.append(values[i]);
				}
				unbalancedCount++;
			}
			if (values[i] == ')') {
				unbalancedCount--;
				if (unbalancedCount > 0) {
					stringBuilder.append(values[i]);
				}
			}
		}
		return stringBuilder.toString();
	}
}