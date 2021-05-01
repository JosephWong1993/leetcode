package com.wong.example.example_00301_00400;

public class Example_00367_ValidPerfectSquare {
    /**
     * 方法一：二分查找
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 0;
        long right = num / 2;
        while (left <= right) {
            long mid = (left + right) / 2;
            long guessSquared = mid * mid;
            if (guessSquared == num) {
                return true;
            } else if (guessSquared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    //TODO：方法二：牛顿迭代法
}