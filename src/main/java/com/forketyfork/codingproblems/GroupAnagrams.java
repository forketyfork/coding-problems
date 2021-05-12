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

    public List<List<String>> groupAnagrams(String[] strings) {

        return Arrays.stream(strings)
                .collect(Collectors.groupingBy(Key::new))
                .values().stream().toList();
    }

    // Grouping key is an array of character frequencies which should be the same for all anagrams
    private static class Key {

        private final int[] frequencies;
        private final int hashCode;

        Key(String string) {
            frequencies = new int[26];
            string.chars().forEach(c -> frequencies[c - 'a']++);
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
