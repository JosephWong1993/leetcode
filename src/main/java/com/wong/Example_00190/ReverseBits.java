package com.wong.Example_00190;

public class ReverseBits {
    /**
     * 方法一：逐位颠倒
     */
    public int reverseBits_1(int n) {
        int ret = 0;
        int power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        return ret;
    }
}
