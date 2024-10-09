package com.forketyfork.codingproblems;

import java.util.ArrayList;
import java.util.List;

public class NumberOfWaysToReorderArray {

    private static final long MODULO = 1000000007L;

    private int[][] triangle;

    public int numOfWays(int[] nums) {
        fillTriangle(nums.length);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return (int) numOfWays(list) - 1;
    }

    private long numOfWays(List<Integer> nums) {
        if (nums.size() <= 1) {
            return 1;
        }
        int root = nums.get(0);
        List<Integer> less = nums.stream().filter(i -> i < root).toList();
        List<Integer> more = nums.stream().filter(i -> i > root).toList();
        int total = less.size() + more.size();

        long combinations = comb(total, less.size()) % MODULO;

        combinations *= numOfWays(less);
        combinations %= MODULO;

        combinations *= numOfWays(more);
        combinations %= MODULO;

        return combinations;
    }

    private void fillTriangle(int n) {
        triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;
            for (int j = 1; j < i; j++)
                triangle[i][j] = (int) (((long) triangle[i - 1][j - 1] + triangle[i - 1][j]) % MODULO);
        }
    }

    private int comb(int n, int k) {
        return triangle[n][k];
    }

}