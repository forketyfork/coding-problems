package com.forketyfork.codingproblems;

import java.util.Arrays;

/**
 * You are given an array arr which consists of only zeros and ones, divide the array into three non-empty parts such
 * that all of these parts represent the same binary value.
 * <p>
 * If it is possible, return any [i, j] with i + 1 < j, such that:
 * <p>
 * <ul>
 * <li>arr[0], arr[1], ..., arr[i] is the first part,</li>
 * <li>arr[i + 1], arr[i + 2], ..., arr[j - 1] is the second part, and</li>
 * <li>arr[j], arr[j + 1], ..., arr[arr.length - 1] is the third part.</li>
 * </ul>
 * All three parts have equal binary values.
 * <p>
 * If it is not possible, return [-1, -1].
 * <p>
 * Note that the entire part is used when considering what binary value it represents. For example, [1,1,0] represents
 * 6 in decimal, not 3. Also, leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 *
 * @see <a href="https://leetcode.com/problems/three-equal-parts/">LeetCode #927. Three Equal Parts</a>
 */
public class ThreeEqualParts {

    public int[] threeEqualParts(int[] arr) {

        int[] noSolution = new int[] {-1, -1};

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return noSolution;
        }

        int oneCount = sum / 3;

        if (oneCount == 0) {
            return new int[] {0, arr.length - 1};
        }

        sum = 0;
        int t2b = oneCount + 1, t2e = oneCount + oneCount, t3b = t2e + 1, t3e = t2e + oneCount;
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0, i3 = 0, j3 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                sum += arr[i];
                if (sum == 1) {
                    i1 = i;
                }
                if (sum == oneCount) {
                    j1 = i;
                }
                if (sum == t2b) {
                    i2 = i;
                }
                if (sum == t2e) {
                    j2 = i;
                }
                if (sum == t3b) {
                    i3 = i;
                }
                if (sum == t3e) {
                    j3 = i;
                }
                if (sum > t3e) {
                    break;
                }
            }
        }
        int tailZeroes = arr.length - j3 - 1;
        if (i2 - j1 - 1 < tailZeroes || i3 - j2 - 1 < tailZeroes) {
            return noSolution;
        }
        if (Arrays.compare(arr, i1, j1 + 1, arr, i2, j2 + 1) == 0
                && Arrays.compare(arr, i1, j1 + 1, arr, i3, j3 + 1) == 0) {
            return new int[] {j1 + tailZeroes, j2 + tailZeroes + 1};
        }
        return noSolution;

    }

}
