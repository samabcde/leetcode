package q1307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	private static final int[] POWER_OF_TEN = new int[] { 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000 };

	public boolean isSolvable(String[] words, String result) {
		List<Character> possibleChars = new ArrayList<>();
		Map<Character, List<Integer>> charToPossibleValuesMap = new HashMap<>();
		for (int i = 0; i < result.length(); i++) {
			Character character = result.charAt(i);
			if (!possibleChars.contains(character)) {
				possibleChars.add(character);
				List<Integer> allPossibleValues = getAllPossibleValues();
				if (i == 0 && result.length() > 1) {
					allPossibleValues.remove(0);
				}
				charToPossibleValuesMap.put(character, allPossibleValues);
			}
		}
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -(o1.length() - o2.length());
			}
		});
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				Character character = word.charAt(i);
				if (!possibleChars.contains(character)) {
					possibleChars.add(character);
					List<Integer> allPossibleValues = getAllPossibleValues();
					if (i == 0 && word.length() > 1) {
						allPossibleValues.remove(0);
					}
					charToPossibleValuesMap.put(character, allPossibleValues);
				}
			}
		}
		Map<Character, Integer> mappedCharToValueMap = new HashMap<>();
		int[] lastPossibleValues = new int[possibleChars.size()];

		for (int i = 0; i < possibleChars.size();) {
			Character possibleChar = possibleChars.get(i);
			boolean isBounded = false;
			List<Integer> possibleValues = charToPossibleValuesMap.get(possibleChar);
			int lastMinSumMaxResult = -1;
			int lastMaxSumMinResult = -1;
			for (int j = lastPossibleValues[i]; j < possibleValues.size(); j++) {
				if (mappedCharToValueMap.containsValue(possibleValues.get(j))) {
					continue;
				}
				mappedCharToValueMap.put(possibleChar, possibleValues.get(j));
				int minSum = minSum(words, mappedCharToValueMap);
				int maxSum = maxSum(words, mappedCharToValueMap);
				int minResult = minValue(result, mappedCharToValueMap);
				int maxResult = maxValue(result, mappedCharToValueMap);
//				String level = "";
//				for (int m = 0; m < i; m++) {
//					level += "->";
//				}
//				System.out.println(
//						String.format("%s possibleChar %s value %s minSum %s maxSum %s minResult %s maxResult %s",
//								level, possibleChar, possibleValues.get(j), minSum, maxSum, minResult, maxResult));
				if (maxResult < minSum) {
					if (lastMinSumMaxResult > -1 && minSum - maxResult > lastMinSumMaxResult) {
						break;
					}
					lastMinSumMaxResult = minSum - maxResult;
					mappedCharToValueMap.remove(possibleChar);
					continue;
				}
				if (minResult > maxSum) {
					if (lastMaxSumMinResult > -1 && minResult - maxSum > lastMaxSumMinResult) {
						break;
					}
					lastMaxSumMinResult = minResult - maxSum;
					mappedCharToValueMap.remove(possibleChar);
					continue;
				}
				if (maxResult == minResult && minSum == maxSum) {
					return maxResult == maxSum;
				}
				lastPossibleValues[i] = j + 1;
				isBounded = true;
				break;
			}
			if (isBounded) {
				i++;
			} else {
				if (i == 0) {
					break;
				}
				lastPossibleValues[i] = 0;
				mappedCharToValueMap.remove(possibleChar);
				i--;
			}
		}
		return false;
	}

	private static List<Integer> getAllPossibleValues() {
		List<Integer> allPossibleValues = new ArrayList<Integer>();
		for (Integer i = 0; i < 10; i++) {
			allPossibleValues.add(i);
		}
		return allPossibleValues;
	}

	private static int maxSum(String[] words, Map<Character, Integer> mappedValue) {
		int sum = 0;
		for (String word : words) {
			sum += maxValue(word, mappedValue);
		}
		return sum;
	}

	private static int minSum(String[] words, Map<Character, Integer> mappedValue) {
		int sum = 0;
		for (String word : words) {
			sum += minValue(word, mappedValue);
		}
		return sum;
	}

	private static int maxValue(String input, Map<Character, Integer> mappedValue) {
		int value = 0;
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (mappedValue.containsKey(chars[i])) {
				value += mappedValue.get(chars[i]) * POWER_OF_TEN[chars.length - i - 1];
				continue;
			}
			for (int n = 9; n >= 0; n--) {
				if (!mappedValue.containsValue(n)) {
					value += n * POWER_OF_TEN[chars.length - i - 1];
					break;
				}
			}
		}
		return value;
	}

	private static int minValue(String input, Map<Character, Integer> mappedValue) {
		int value = 0;
		char[] chars = input.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (mappedValue.containsKey(chars[i])) {
				value += mappedValue.get(chars[i]) * POWER_OF_TEN[chars.length - i - 1];
				continue;
			}
			int start = (i == 0 && chars.length > 1) ? 1 : 0;
			for (int n = start; n <= 9; n++) {
				if (!mappedValue.containsValue(n)) {
					value += n * POWER_OF_TEN[chars.length - i - 1];
					break;
				}
			}
		}
		return value;
	}
}