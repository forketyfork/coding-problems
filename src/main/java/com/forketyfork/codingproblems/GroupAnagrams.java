package com.forketyfork.codingproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of strings, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * strings[i] consists of lower-case English letters.
 *
 * @see <a href="https://leetcode.com/problems/group-anagrams/">LeetCode #49. Group Anagrams</a>
 */
public class GroupAnagrams {

    /**
     * Groups anagrams together from an array of strings.
     * Uses character frequency counting to identify anagrams efficiently.
     *
     * @param strings the input array of strings (all lowercase English letters)
     * @return a list of lists, where each inner list contains all anagrams of a particular pattern
     *
     * <p>Time Complexity: O(n * k) where n is the number of strings and k is the maximum length of a string
     * <p>Space Complexity: O(n * k) for storing all strings and their keys
     *
     * <p>This approach is more efficient than sorting-based approaches (O(n * k * log(k)))
     * because it uses character frequency arrays as keys.
     */
    public List<List<String>> groupAnagrams(String[] strings) {

        return Arrays.stream(strings)
                .collect(Collectors.groupingBy(Key::new))
                .values().stream().toList();
    }

    /**
     * Grouping key based on character frequency arrays.
     * Two strings are anagrams if and only if they have the same character frequencies.
     */
    private static class Key {

        private final int[] frequencies;
        private final int hashCode;

        /**
         * Creates a key from a string by computing character frequencies.
         *
         * @param string the input string (lowercase English letters only)
         */
        Key(String string) {
            frequencies = new int[26];
            string.chars().forEach(c -> frequencies[c - 'a']++);
            // Pre-compute hashCode for efficiency
            hashCode = Arrays.hashCode(frequencies);
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Key otherKey) {
                return Arrays.equals(this.frequencies, otherKey.frequencies);
            }
            return false;
        }
    }

}
