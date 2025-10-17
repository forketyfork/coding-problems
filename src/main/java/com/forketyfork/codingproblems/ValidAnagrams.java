package com.forketyfork.codingproblems;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * @see <a href="https://leetcode.com/problems/valid-anagram/">LeetCode #242. Valid Anagram</a>
 */
public class ValidAnagrams {

    /**
     * Checks if two strings are anagrams using character frequency counting.
     * An anagram is formed by rearranging the letters of a string.
     *
     * @param s the first string
     * @param t the second string
     * @return true if t is an anagram of s, false otherwise
     *
     * <p>Time Complexity: O(n + m) where n and m are the lengths of the two strings
     * <p>Space Complexity: O(1) - uses fixed-size array of 26 elements
     *
     * <p>Algorithm: Count character frequencies in s (increment), then decrement
     * for characters in t. If all counts are zero at the end, they're anagrams.
     */
    public boolean isAnagram(String s, String t) {
        char[] chars = new char[26];
        // Increment count for each character in s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }
        // Decrement count for each character in t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            chars[c - 'a']--;
        }
        // Check if all counts are zero (or negative, meaning extra chars in t)
        for (char aChar : chars) {
            if (aChar != 0) {
                return false;
            }
        }
        return true;
    }
}
