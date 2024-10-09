package com.forketyfork.codingproblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * CtCI, 1.6
 *
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than
 * the original string, your method should return the original string. You can assume the string has only uppercase
 * and lowercase letters (a - z).
 */
public class StringCompression2 {

    public String compress(String s) {
        int newLength = 0;
        char prev = 0;
        int count = 1;
        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            }
            else if (prev > 0) {
                newLength += digitCount(count) + 1;
                count = 1;
            }
            prev = c;
        }
        if (count != 0) {
            newLength += digitCount(count) + 1;
        }

        if (newLength >= s.length()) {
            return s;
        }
        char[] compressed = new char[newLength];

        prev = 0;
        count = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == prev) {
                count++;
            }
            else if (prev > 0) {
                compressed[index++] = prev;
                while (count > 0) {
                    stack.push(count % 10);
                    count /= 10;
                }
                while (!stack.isEmpty()) {
                    Integer digit = stack.pop();
                    compressed[index++] = (char) ('0' + digit);
                }
                count = 1;
            }
            prev = c;
        }

        compressed[index++] = prev;
        while (count > 0) {
            stack.push(count % 10);
            count /= 10;
        }
        while (!stack.isEmpty()) {
            Integer digit = stack.pop();
            compressed[index++] = (char) ('0' + digit);
        }

        return new String(compressed);
    }

    private int digitCount(int num) {
        int digitCount = 0;
        while (num > 0) {
            num /= 10;
            digitCount++;
        }
        return digitCount;
    }
}
