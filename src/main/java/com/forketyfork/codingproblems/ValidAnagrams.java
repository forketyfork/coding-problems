package com.forketyfork.codingproblems;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * @see <a href="https://leetcode.com/problems/valid-anagram/">LeetCode #242. Valid Anagram</a>
 */
public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            chars[c - 'a']--;
        }
        for (char aChar : chars) {
            if (aChar > 0) {
                return false;
            }
        }
        return true;
    }
}
