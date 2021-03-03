package com.wong.example;

/**
 * 231. 2的幂
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
    
    //TODO：方法一：位运算：获取二进制中最右边的 1
    
    //TODO：方法二：位运算：去除二进制中最右边的 1
}