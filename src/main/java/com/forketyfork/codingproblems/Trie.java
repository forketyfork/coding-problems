package com.forketyfork.codingproblems;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in
 * a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <ul>
 * <li>Trie() Initializes the trie object.</li>
 * <li>void insert(String word) Inserts the string word into the trie.</li>
 * <li>boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 * and false otherwise.</li>
 * <li>boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix
 * prefix, and false otherwise.</li>
 * </ul>
 *
 * @see <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">LeetCode #208. Implement Trie (Prefix Tree)</a>
 */
public class Trie {

    private boolean end;
    private Trie[] children = new Trie[26];

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.isEmpty()) {
            this.end = true;
        }
        else {
            int idx = word.charAt(0) - 'a';
            if (children[idx] == null) {
                var trie = new Trie();
                children[idx] = trie;
            }
            children[idx].insert(word.substring(1));
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.isEmpty()) {
            return end;
        }
        int idx = word.charAt(0) - 'a';
        return children[idx] != null && children[idx].search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        int idx = prefix.charAt(0) - 'a';
        return children[idx] != null && children[idx].startsWith(prefix.substring(1));
    }
}
