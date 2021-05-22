package com.forketyfork.codingproblems;

/**
 * Given an integer n, add a dot (".") as the thousands separator and return it in string format.
 *
 * @see <a href="https://leetcode.com/problems/thousand-separator/">LeetCode #1556. Thousand Separator</a>
 */
public class ThousandSeparator {

    public String thousandSeparator(int n) {

        var builder = new StringBuilder();
        var digitsCounter = 0;

        // need to run the cycle at least once, for the case when n == 0
        do {
            builder.append(n % 10);
            n /= 10;
            digitsCounter++;

            // if we passed 3 digits, and this was not the last digit in the number, we append a dot
            if (digitsCounter % 3 == 0 && n > 0) {
                builder.append('.');
            }
        } while (n > 0);

        // we need to reverse the string, as we've been building it backwards
        return builder.reverse().toString();
    }
}
