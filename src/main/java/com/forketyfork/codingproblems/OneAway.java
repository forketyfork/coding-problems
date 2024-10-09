package com.forketyfork.codingproblems;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character, remove a character,
 * or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAway {

    boolean isOneEditAway(String s1, String s2) {
        // check length
        if (Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        // switch strings to get rid of the 3rd case
        if (s1.length() > s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        // compare strings
        boolean foundDiff = false;
        for (int i = 0, j = 0; i < s1.length(); i++, j++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                if (foundDiff) {
                    return false;
                }
                else {
                    foundDiff = true;
                    if (s1.length() != s2.length()) {
                        j++;
                    }
                }
            }
        }
        return true;
    }

}
