package com.wong.example;

/**
 * 633. 平方数之和
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 */
public class Example_00633_SumOfSquareNumbers {
    /**
     * 方法一：使用 sqrt 函数
     */
    public boolean judgeSquareSum_1(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：双指针
     */
    public boolean judgeSquareSum_2(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum > c) {
                right--;
            } else if (sum < c) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }
}
