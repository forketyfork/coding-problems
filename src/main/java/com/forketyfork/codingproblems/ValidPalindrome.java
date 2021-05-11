package com.forketyfork.codingproblems;

/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * 1 <= s.length <= 2 * 105, s consists only of printable ASCII characters.
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">LeetCode #125. Valid Palindrome</a>
 */
class ValidPalindrome {

    public boolean isPalindrome(String s) {

        // start with two pointers to the leftmost and the rightmost character
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

    // we can use !Character.isNumber(c) && !Character.isLetter(c) instead,
    // but since the character set is limited to ASCII, we can implement it in a more performant way
    private boolean isNotAlphanumeric(char c) {
        return (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9');
    }

    // we can use Character.toLowerCase(c) instead, but since the character is limited to ASCII,
    // we can implement it in a more performant way
    private char toLowerCase(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32); // c - 'A' + 'a'
        }
        return c;
    }

}
