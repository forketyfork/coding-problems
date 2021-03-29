package com.forketyfork.codingproblems;

import java.util.Arrays;

/**
 * There is a strange printer with the following two special requirements:
 * <p>
 * The printer can only print a sequence of the same character each time.
 * At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
 * <p>
 * Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.
 *
 * @see <a href="https://leetcode.com/problems/strange-printer/">LeetCode #664. Strange Printer</a>
 */
public class StrangePrinter {

    // an array for memoization (caching) of intermediate results
    private int[][] memo;

    // a squashed string (without repeating characters)
    private char[] array;

    public int strangePrinter(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        // we can squash the repeating characters in the string to a single one,
        // as it doesn't affect the result, but decreases the N
        array = squash(s);

        // array for result memoization, where memo[i][j] is a solution for the substring s[i..j] inclusive.
        int N = array.length;
        memo = new int[N][];

        // populating the memoization array for 1 and 2 letter sequences, since it's trivial
        for (int i = 0; i < N; i++) {
            // building a diagonal array of [int[N], int[N - 1], ..., int[1]]
            memo[i] = new int[N];
            // it takes 1 step to print a single letter
            memo[i][i] = 1;
            if (i != N - 1) {
                int next = i + 1;
                // it takes 1 or 2 steps to print 2 letters, depending on whether they are equal
                memo[i][next] = array[i] == array[next] ? 1 : 2;
            }
        }

        return strangePrinter(0, array.length - 1);
    }

    public int strangePrinter(int i, int j) {
        if (i > j) {
            return 0;
        }
        // skip calculations, if a memoized result is present
        if (memo[i][j] == 0) {

            int nextIdx = i + 1;
            int letter = array[i];

            // worst case - we just print the current letter and then everything else,
            // e.g. when there's no occurrences of the letter in the subsequent string
            int answer = 1 + strangePrinter(nextIdx, j);

            // now we try to find a better solution
            for (int k = nextIdx; k <= j; k++) {
                if (array[k] == letter) {

                    // If the letter is repeated at least once in the subsequent string (e.g. at position k),
                    // we can do better than the worst case above, by printing a row of letters at s[i..k] first,
                    // and then everything else.
                    // But then printing s[i..k] would take the same amount of steps as printing s[i..k-1],
                    // so we have an opportunity to reduce the problem by removing s[k].
                    int betterAnswer = strangePrinter(i, k - 1) + strangePrinter(k + 1, j);

                    // choose the best answer
                    answer = Math.min(answer, betterAnswer);
                }
            }
            memo[i][j] = answer;
        }
        return memo[i][j];
    }

    /**
     * Squashing a string into a char array without repeating characters
     *
     * @param s input string
     * @return a char array from the string, with repeating characters squashed
     */
    char[] squash(String s) {
        char[] chars = s.toCharArray();
        int last = 0;
        int fullLength = chars.length;
        for (int i = 1; i < fullLength; i++) {
            if (chars[i] != chars[last]) {
                chars[++last] = chars[i];
            }
        }
        return Arrays.copyOf(chars, last + 1);
    }

}
