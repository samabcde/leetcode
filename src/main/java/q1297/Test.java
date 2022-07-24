package q1297;

import java.io.*;
import java.util.stream.Collectors;

public class Test {
    public static Solution solution = new Solution();

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        long startTime = System.currentTimeMillis();
        test5();
        long endTime = System.currentTimeMillis();
        System.out.println("Used:" + (endTime - startTime));
    }

    private static void test1() {
        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;
        int expected = 2;
        int result = solution.maxFreq(s, maxLetters, minSize, maxSize);
        assert (expected == result);
        System.out.println(expected == result);
    }

    private static void test2() {
        String s = "aaaa";
        int maxLetters = 1;
        int minSize = 3;
        int maxSize = 3;
        int expected = 2;
        int result = solution.maxFreq(s, maxLetters, minSize, maxSize);
        assert (expected == result);
        System.out.println(expected == result);
    }

    private static void test3() {
        String s = "abadabadabad";
        int maxLetters = 1;
        int minSize = 2;
        int maxSize = 4;
        int expected = 0;
        int result = solution.maxFreq(s, maxLetters, minSize, maxSize);
        assert (expected == result);
        System.out.println(expected == result);
    }

    private static void test4() {
        String s = "abababbb";
        int maxLetters = 1;
        int minSize = 2;
        int maxSize = 4;
        int expected = 2;
        int result = solution.maxFreq(s, maxLetters, minSize, maxSize);
        assert (expected == result);
        System.out.println(expected == result);
    }

    private static void test5() {
        String s = new BufferedReader(new InputStreamReader(Test.class.getResourceAsStream("test5.txt"))).lines().collect(Collectors.joining(""));
        int maxLetters = 7;
        int minSize = 4;
        int maxSize = 23;
        int expected = 200;
        int result = solution.maxFreq(s, maxLetters, minSize, maxSize);
        assert (expected == result);
        System.out.println(expected == result);
    }
}
