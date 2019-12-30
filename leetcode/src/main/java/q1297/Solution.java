package q1297;

import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		int possibleSubstringCount = s.length() - minSize + 1;
		Map<String, Integer> substringToFreqMap = new HashMap<String, Integer>();
		for (int i = 0; i < possibleSubstringCount; i++) {
			String substring = s.substring(i, i + minSize);
			if (isBelowMaxLetters(substring.toCharArray(), maxLetters)) {
				if (!substringToFreqMap.containsKey(substring)) {
					substringToFreqMap.put(substring, 1);
				} else {
					substringToFreqMap.merge(substring, 1, Integer::sum);
				}
			}
		}
		if (substringToFreqMap.isEmpty()) {
			return 0;
		}
		return Collections.max(substringToFreqMap.values());
	}

	private static boolean isBelowMaxLetters(char[] substring, int maxLetters) {
		if (substring.length <= maxLetters) {
			return true;
		}
		BitSet count = new BitSet(26);

		for (int i = 0; i < substring.length; i++) {
			count.set(substring[i] - 97);
			if (count.cardinality() > maxLetters) {
				return false;
			}
		}
		return true;
	}

}
