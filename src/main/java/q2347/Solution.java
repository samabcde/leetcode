package q2347;

class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        if (isFlush(suits)) {
            return "Flush";
        }
        if (isThreeOfAKind(ranks)) {
            return "Three of a Kind";
        }
        if (isPair(ranks)) {
            return "Pair";
        }
        return "High Card";
    }

    private static boolean isThreeOfAKind(int[] ranks) {
        int[] counts = new int[13];
        for (int i = 0; i < 5; i++) {
            counts[ranks[i] - 1]++;
            if (counts[ranks[i] - 1] == 3) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPair(int[] ranks) {
        int[] counts = new int[13];
        for (int i = 0; i < 5; i++) {
            counts[ranks[i] - 1]++;
            if (counts[ranks[i] - 1] == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean isFlush(char[] suits) {
        char first = suits[0];
        for (int i = 1; i < 5; i++) {
            if (suits[i] != first) {
                return false;
            }
        }
        return true;
    }
}
