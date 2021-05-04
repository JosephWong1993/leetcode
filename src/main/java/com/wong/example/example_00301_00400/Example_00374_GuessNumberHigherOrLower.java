package com.wong.example.example_00301_00400;

/**
 * 374. 猜数字大小
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class Example_00374_GuessNumberHigherOrLower {
    private int guess(int num) {
        return 0;
    }

    /**
     * 方法：二分查找
     */
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            switch (guess) {
                case 0:
                    return mid;
                case -1:
                    right = mid - 1;
                    break;
                case 1:
                    left = mid + 1;
            }
        }
        return 0;
    }
}
