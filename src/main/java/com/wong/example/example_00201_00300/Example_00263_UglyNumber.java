package com.wong.example.example_00201_00300;

/**
 * 263. 丑数
 * https://leetcode-cn.com/problems/ugly-number/
 */
public class Example_00263_UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}