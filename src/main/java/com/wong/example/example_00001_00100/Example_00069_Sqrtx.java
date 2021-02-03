package com.wong.example.example_00001_00100;

/**
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Example_00069_Sqrtx {
    //TODO: 方法一：袖珍计算器算法

    /**
     * 方法二：二分查找
     */
    public int mySqrt_2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //TODO: 方法三：牛顿迭代
}
