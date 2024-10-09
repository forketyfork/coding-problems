package com.forketyfork.codingproblems;

class ConstructTargetArrayWithMultipleSums {

    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        long sum = 0;
        for (int el : target) {
            sum += el;
        }
        buildHeap(target);
        while (sum > target.length) {
            int max = target[0];
            int maxChild = Math.max(target[1], outOfRange(target, 2) ? Integer.MIN_VALUE : target[2]);
            int diffToMaxChild = max - maxChild;
            long rest = sum - max;
            long timesToSubtractSum = diffToMaxChild / rest;
            if (timesToSubtractSum == 0) {
                timesToSubtractSum = 1;
            }
            long maxUpdated = max - (timesToSubtractSum * rest);
            if (maxUpdated <= 0) {
                return false;
            }
            target[0] = (int) maxUpdated;
            sum = rest + maxUpdated;
            sinkTop(target);
        }
        return true;
    }

    private void buildHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int idx = i;
            int parentIdx = getParentIdx(idx);
            while (!outOfRange(array, parentIdx) && array[parentIdx] < array[idx]) {
                swap(array, idx, parentIdx);
                idx = parentIdx;
                parentIdx = getParentIdx(idx);
            }
        }
    }

    private void sinkTop(int[] array) {
        int idx = 0;
        int maxIdx = 0;
        while (array[idx] <= array[maxIdx]) {
            swap(array, idx, maxIdx);
            idx = maxIdx;
            int childLeftIdx = getChildLeftIdx(idx);
            if (outOfRange(array, childLeftIdx)) {
                return;
            }
            int childRightIdx = childLeftIdx + 1;
            maxIdx = outOfRange(array, childRightIdx) || array[childLeftIdx] > array[childRightIdx]
                    ? childLeftIdx : childRightIdx;
        }
    }

    private int getParentIdx(int idx) {
        if (idx == 0) {
            return -1;
        }
        return ((idx + 1) >> 1) - 1;
    }

    private int getChildLeftIdx(int idx) {
        return ((idx + 1) << 1) - 1;
    }

    private boolean outOfRange(int[] array, int idx) {
        return idx < 0 || idx >= array.length;
    }

    private void swap(int[] array, int idx1, int idx2) {
        if (idx1 == idx2) {
            return;
        }
        int tmp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = tmp;
    }
}