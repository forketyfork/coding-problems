package com.forketyfork.codingproblems;

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * 1 <= s.length <= 2 * 105, s consists only of printable ASCII characters.
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">LeetCode #125. Valid Palindrome</a>
 */
class ValidPalindrome {

    /**
     * Checks if a string is a palindrome, considering only alphanumeric characters and ignoring case.
     * Uses two-pointer technique for O(1) space complexity.
     *
     * @param s the string to check
     * @return true if the string is a palindrome, false otherwise
     *
     * <p>Time Complexity: O(n) where n is the length of the string
     * <p>Space Complexity: O(1)
     */
    public boolean isPalindrome(String s) {

        // Start with two pointers to the leftmost and rightmost character
        int p1 = 0, p2 = s.length() - 1;

        while (p1 < p2) {
            char c1 = s.charAt(p1), c2 = s.charAt(p2);
            if (isNotAlphanumeric(c1)) {
                // if the left character is not alphanumeric, skip it
                p1++;
            }
            else if (isNotAlphanumeric(c2)) {
                // if the right character is not alphanumeric, skip it
                p2--;
            }
            else if (toLowerCase(c1) == toLowerCase(c2)) {
                // if both characters are alphanumeric and equal, then skip both of them
                p1++;
                p2--;
            }
            else {
                // we've found two alphanumeric characters that are not equal
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a character is not alphanumeric using ASCII bounds.
     * More performant than Character.isLetter/isDigit for ASCII-only strings.
     *
     * @param c the character to check
     * @return true if not alphanumeric, false otherwise
     */
    private boolean isNotAlphanumeric(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    /**
     * Converts a character to lowercase using ASCII arithmetic.
     * More performant than Character.toLowerCase for ASCII-only strings.
     *
     * @param c the character to convert
     * @return the lowercase version of the character
     */
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // c - 'A' + 'a'
        }
        return c;
    }

}
