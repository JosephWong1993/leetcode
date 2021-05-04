package com.wong.example.example_00001_00100;

/**
 * 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class Example_00007_ReverseInteger {
    /**
     * 方法一：数学
     */
    public int reverse_1(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
