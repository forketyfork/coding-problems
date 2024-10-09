package com.forketyfork.codingproblems;

import java.util.List;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * @see <a href="https://leetcode.com/problems/n-th-tribonacci-number/">LeetCode #139. Word Break</a>
 */
class WordBreak {

    public static class TrieNode {

        boolean terminal;
        TrieNode[] children = new TrieNode[26];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        return wordBreak(s.toCharArray(), 0, root, new Boolean[s.length()]);
    }

    private boolean wordBreak(char[] s, int start, TrieNode root, Boolean[] memo) {
        if (start == s.length) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        TrieNode node = root;
        boolean hasBreak = false;
        for (int i = start; i < s.length; i++) {
            char c = s[i];
            int idx = c - 'a';
            if (node.children[idx] == null) {
                break;
            }
            node = node.children[idx];
            if (node.terminal) {
                hasBreak |= wordBreak(s, i + 1, root, memo);
            }
        }
        memo[start] = hasBreak;
        return hasBreak;
    }

    private TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.terminal = true;
        }
        return root;
    }
}



