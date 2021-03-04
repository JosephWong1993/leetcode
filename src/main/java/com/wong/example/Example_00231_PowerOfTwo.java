package com.wong.example;

/**
 * 231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class Example_00231_PowerOfTwo {
    /**
     * 方法：迭代
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
    
    /**
     * 方法一：位运算：获取二进制中最右边的 1
     */
    public boolean isPowerOfTwo_1(int n) {
        if (n == 0) {
            return false;
        }
        long num = Long.parseLong(Integer.toString(n));
        return (num & (-num)) == num;
    }
    
    /**
     * 方法二：位运算：去除二进制中最右边的 1
     */
    public boolean isPowerOfTwo_2(int n) {
        if (n == 0) {
            return false;
        }
        long num = Long.parseLong(Integer.toString(n));
        return (num & num - 1) == 0;
    }
}