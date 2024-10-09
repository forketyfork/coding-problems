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

    public boolean areNumbersAscending(String s) {
        int previousNumber = 0;
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (currentNumber > 0) {
                    if (currentNumber <= previousNumber) {
                        return false;
                    }
                    previousNumber = currentNumber;
                    currentNumber = 0;
                }
            }
            else if (c >= '0' && c <= '9') {
                currentNumber = currentNumber * 10 + (c - '0');
            }
        }
        return currentNumber == 0 || currentNumber > previousNumber;
    }

}
