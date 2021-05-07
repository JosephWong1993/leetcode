package com.wong.example;

/**
 * 1486. 数组异或操作
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 */
public class Example_01486_XorOperationInAnArray {
    /**
     * 方法一：模拟
     */
    public int xorOperation_1(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= start + 2 * i;
        }
        return ans;
    }

    //TODO：方法二：数学
}