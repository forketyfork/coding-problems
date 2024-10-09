package com.forketyfork.codingproblems;

/**
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement
 * of letters. The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class PalindromePermutation {
    public boolean isPermutationOfAPalindrome(String s) {
        int bitset = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            c = Character.toLowerCase(c);
            int mask = 1 << (c - 'a');
            bitset ^= mask;
        }
        return (bitset & (bitset - 1)) == 0;
    }

}
