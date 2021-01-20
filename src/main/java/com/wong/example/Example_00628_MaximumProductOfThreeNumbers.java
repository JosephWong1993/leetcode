package com.wong.example;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 */
public class Example_00628_MaximumProductOfThreeNumbers {
    /**
     * 方法一：排序
     */
    public int maximumProduct_1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    /**
     * 方法二：线性扫描
     */
    public int maximumProduct(int[] nums) {
        int minNum = Integer.MAX_VALUE, min2Num = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE, max2Num = Integer.MIN_VALUE, max3Num = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x < minNum) {
                min2Num = minNum;
                minNum = x;
            } else if (x < min2Num) {
                min2Num = x;
            }

            if (x > maxNum) {
                max3Num = max2Num;
                max2Num = maxNum;
                maxNum = x;
            } else if (x > max2Num) {
                max3Num = max2Num;
                max2Num = x;
            } else if (x > max3Num) {
                max3Num = x;
            }
        }
        return Math.max(minNum * min2Num * maxNum, maxNum * max2Num * max3Num);
    }
}
