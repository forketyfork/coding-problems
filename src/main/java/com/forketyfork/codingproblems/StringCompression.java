package com.forketyfork.codingproblems;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 * <p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 * * If the group's length is 1, append the character to s.
 * * Otherwise, append the character followed by the group's length.
 * <p>
 * The compressed string s should not be returned separately, but instead be stored in the input character array chars.
 * Note that group lengths that are 10 or longer will be split into multiple characters in chars.
 * <p>
 * After you are done modifying the input array, return the new length of the array.
 * You must write an algorithm that uses only constant extra space.
 *
 * @see <a href="https://leetcode.com/problems/string-compression/submissions/">LeetCode #443. String Compression</a>
 */
class StringCompression {

    public int compress(char[] chars) {
        char prev = chars[0];
        int prevIdx = 0;
        int curr = 0;
        for (int i = 1; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != prev) {
                chars[curr++] = prev;
                int count = i - prevIdx;
                if (count > 1) {
                    // We can't just convert the number to a string using Integer.toString(),
                    // as this contradicts to the constant extra space requirement.
                    // So here we convert the number to a string and write it directly into the array,
                    // but in reverse order.
                    int digits = 0;
                    while (count > 0) {
                        digits++;
                        chars[curr++] = (char) (count % 10 + '0');
                        count /= 10;
                    }
                    // If there were multiple digits, we now need to reverse them in-place in the array.
                    if (digits > 1) {
                        for (int j = 0; j < digits >> 1; j++) {
                            char tmp = chars[curr - digits + j];
                            chars[curr - digits + j] = chars[curr - 1 - j];
                            chars[curr - 1 - j] = tmp;
                        }
                    }
                }
                if (i < chars.length) {
                    prev = chars[i];
                    prevIdx = i;
                }
            }
        }

        return curr;
    }

}
