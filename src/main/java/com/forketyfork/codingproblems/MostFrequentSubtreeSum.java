package com.forketyfork.codingproblems;

import com.forketyfork.codingproblems.structures.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return the most frequent subtree sum.
 * If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
 * (including the node itself).
 *
 * @see "Daily Coding Problem #748"
 * @see <a href="https://leetcode.com/problems/most-frequent-subtree-sum/">LeetCode #508. Most Frequent Subtree Sum</a>
 */
public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> counts = new HashMap<>();
        calculateSubtreeSum(root, counts);
        List<Integer> maxSums = new ArrayList<>();
        int maxSumCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxSumCount) {
                maxSums.add(entry.getKey());
            }
            else if (entry.getValue() > maxSumCount) {
                maxSums.clear();
                maxSums.add(entry.getKey());
                maxSumCount = entry.getValue();
            }
        }
        int[] result = new int[maxSums.size()];
        for (int i = 0; i < maxSums.size(); i++) {
            result[i] = maxSums.get(i);
        }
        return result;
    }

    private int calculateSubtreeSum(TreeNode tree, Map<Integer, Integer> counts) {
        if (tree == null) {
            return 0;
        }
        int sum = tree.val
                + calculateSubtreeSum(tree.left, counts)
                + calculateSubtreeSum(tree.right, counts);

        counts.merge(sum, 1, Integer::sum);
        return sum;
    }

}