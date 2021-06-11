package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int num1 = nums[i];
            if (num1 > 0) {
                break;
            }
            if (i > 0 && num1 == nums[i - 1]) {
                continue;
            }

            int sum = -num1;

            int lo = i + 1, hi = nums.length - 1;

            while (lo < hi) {
                int num2 = nums[lo], num3 = nums[hi];
                int currSum = num2 + num3;
                if (currSum == sum) {
                    result.add(List.of(num1, num2, num3));
                    while (lo < hi && nums[lo] == num2) {
                        lo++;
                    }
                    while (lo < hi && nums[hi] == num3) {
                        hi--;
                    }
                }
                else if (currSum > sum) {
                    while (lo < hi && nums[hi] == num3) {
                        hi--;
                    }
                }
                else {
                    while (lo < hi && nums[lo] == num2) {
                        lo++;
                    }
                }
            }

        }

        return result;
    }
}
