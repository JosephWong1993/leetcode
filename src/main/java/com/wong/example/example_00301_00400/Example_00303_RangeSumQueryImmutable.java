package com.wong.example.example_00301_00400;

/**
 * 303. 区域和检索 - 数组不可变
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 */
public class Example_00303_RangeSumQueryImmutable {
}

class NumArray {

    private int[] array;

    public NumArray(int[] nums) {
        array = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += array[i];
        }
        return sum;
    }
}

/**
 * 方法一：前缀和
 */
class NumArray_1 {

    int[] sums;

    public NumArray_1(int[] nums) {
        int length = nums.length;
        sums = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}