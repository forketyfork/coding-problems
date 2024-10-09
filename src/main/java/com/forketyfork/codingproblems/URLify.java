package com.forketyfork.codingproblems;

/**
 * CtCI, 1.3
 * <p>
 * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient
 * space at the end to hold the additional characters,and that you are given the "true" length of the string.
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {

    public void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        int newIdx = trueLength + spaceCount * 2 - 1;
        for (int oldIdx = trueLength - 1; oldIdx >= 0; oldIdx--) {
            if (str[oldIdx] == ' ') {
                str[newIdx--] = '0';
                str[newIdx--] = '2';
                str[newIdx--] = '%';
            }
            else {
                str[newIdx--] = str[oldIdx];
            }
        }
    }

}
