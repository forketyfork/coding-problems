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
     * Initializes the Trie data structure with an empty root node.
     * Each node can have up to 26 children (one for each lowercase letter).
     *
     * <p>Time Complexity: O(1)
     * <p>Space Complexity: O(1)
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie. The method recursively traverses the trie,
     * creating new nodes as needed for each character in the word.
     *
     * @param word the word to insert (must contain only lowercase letters a-z)
     *
     * <p>Time Complexity: O(n) where n is the length of the word
     * <p>Space Complexity: O(n) for the recursive call stack, plus O(n) for new nodes if the word doesn't share prefixes
     */
    public void insert(String word) {
        if (word.isEmpty()) {
            // Mark this node as the end of a complete word
            this.end = true;
        }
        else {
            // Calculate the index for the first character (a=0, b=1, ..., z=25)
            int idx = word.charAt(0) - 'a';
            if (children[idx] == null) {
                var trie = new Trie();
                children[idx] = trie;
            }
            // Recursively insert the rest of the word
            children[idx].insert(word.substring(1));
        }
    }

    /**
     * Searches for a complete word in the trie. A word is considered to exist only if
     * it was previously inserted and the end marker is set at the final character's node.
     *
     * @param word the word to search for (must contain only lowercase letters a-z)
     * @return true if the word exists in the trie, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the word
     * <p>Space Complexity: O(n) for the recursive call stack
     */
    public boolean search(String word) {
        if (word.isEmpty()) {
            return end;
        }
        int idx = word.charAt(0) - 'a';
        return children[idx] != null && children[idx].search(word.substring(1));
    }

    /**
     * Checks if there is any word in the trie that starts with the given prefix.
     * Unlike search(), this method doesn't require the prefix to be a complete word.
     *
     * @param prefix the prefix to search for (must contain only lowercase letters a-z)
     * @return true if any word in the trie starts with the given prefix, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the prefix
     * <p>Space Complexity: O(n) for the recursive call stack
     */
    public boolean startsWith(String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        int idx = prefix.charAt(0) - 'a';
        return children[idx] != null && children[idx].startsWith(prefix.substring(1));
    }
}
