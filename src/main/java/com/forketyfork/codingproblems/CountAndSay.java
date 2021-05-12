package com.forketyfork.codingproblems;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <ul>
 * <li>countAndSay(1) = "1"
 * <li>countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * </ul>
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a
 * contiguous section all of the same character. Then for each group, say the number of characters, then say the
 * character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 * <p>
 * For example, the saying and conversion for digit string "3322251":
 * 3322251 -> two 3's, three 2's, one 5, and one 1 -> 2 3 + 3 2 + 1 5 + 1 1 -> 23321511
 * <p>
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 * <p>
 * Constraints: 1 <= n <= 30
 *
 * @see <a href="https://leetcode.com/problems/count-and-say/">LeetCode #38. Count and Say</a>
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return convert(countAndSay(n - 1));
    }

    private String convert(String string) {
        var builder = new StringBuilder();
        var count = 1;
        var prev = string.charAt(0);
        for (var i = 1; i < string.length(); i++) {
            var next = string.charAt(i);
            if (prev == next) {
                count++;
            }
            else {
                builder.append(count).append(prev);
                prev = next;
                count = 1;
            }
        }
        builder.append(count).append(prev);
        return builder.toString();
    }

}
