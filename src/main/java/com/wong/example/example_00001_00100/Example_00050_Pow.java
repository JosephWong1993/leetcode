package com.wong.example.example_00001_00100;

import org.springframework.stereotype.Component;

/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
@Component
public class Example_00050_Pow {
    //#region 方法一：快速幂 + 递归
    public double myPow_1(double x, int n) {
        long longN = n;
        return n >= 0 ? quickMul_1(x, longN) : 1.0 / quickMul_1(x, -longN);
    }

    private double quickMul_1(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul_1(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
    //endregion

    //region 方法二：快速幂 + 迭代
    public double myPow_2(double x, int n) {
        long longN = n;
        return n >= 0 ? quickMul_2(x, longN) : 1.0 / quickMul_2(x, -longN);
    }

    private double quickMul_2(double x, long n) {
        double ans = 1.0;
        //贡献的初始值为x
        double x_contribute = x;
        //在对n进行二进制拆分的同时计算答案;
        while (n > 0) {
            if (n % 2 == 1) {
                //如果n二进制标识的最低位为1，那么需要计入贡献
                ans *= x_contribute;
            }
            x_contribute = x_contribute * x_contribute;
            n = n / 2;
        }
        return ans;
    }
    //endregion
}