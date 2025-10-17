package com.forketyfork.codingproblems;

/**
 * A sentence is a list of tokens separated by a single space with no leading or trailing spaces. Every token is
 * either a positive number consisting of digits 0-9 with no leading zeros, or a word consisting of lowercase
 * English letters.
 * <p>
 * For example, "a puppy has 2 eyes 4 legs" is a sentence with seven tokens: "2" and "4" are numbers and the other
 * tokens such as "puppy" are words.
 * Given a string s representing a sentence, you need to check if all the numbers in s are strictly increasing from
 * left to right (i.e., other than the last number, each number is strictly smaller than the number on its right in s).
 * <p>
 * Return true if so, or false otherwise.
 *
 * @see <a href="https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/">LeetCode #2042. Check if Numbers Are Ascending in a Sentence</a>
 */
public class CheckIfNumbersAreAscending {

    /**
     * Checks if all numbers in the sentence are in strictly ascending order.
     * The method parses numbers on-the-fly while iterating through the string,
     * comparing each number with the previous one.
     *
     * @param s the sentence string containing tokens separated by single spaces
     * @return true if all numbers are strictly increasing from left to right, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the string
     * <p>Space Complexity: O(1) - only uses a constant amount of extra space
     */
    public boolean areNumbersAscending(String s) {
        int previousNumber = 0;
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                // End of a token - check if it was a number
                if (currentNumber > 0) {
                    if (currentNumber <= previousNumber) {
                        return false;
                    }
                    previousNumber = currentNumber;
                    currentNumber = 0;
                }
            }
            else if (c >= '0' && c <= '9') {
                // Build the current number digit by digit
                currentNumber = currentNumber * 10 + (c - '0');
            }
        }
        // Check the last token if it's a number
        return currentNumber == 0 || currentNumber > previousNumber;
    }

}
