package com.wong.example.example_00301_00400;

import java.util.HashSet;
import java.util.Set;

/**
 * 342. 4的幂
 * https://leetcode-cn.com/problems/power-of-four/
 */
public class Example_00342_PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;
    }

    //region 方法一：暴力法 + 预计算
    private Set<Integer> numsSet = new HashSet<>();

    public Example_00342_PowerOfFour() {
        int n = (int) (Math.log(Integer.MAX_VALUE) / Math.log(4));
        int lastNum = 1;
        numsSet.add(lastNum);
        for (int i = 1; i <= n; i++) {
            lastNum = lastNum * 4;
            numsSet.add(lastNum);
        }
    }

    public boolean isPowerOfFour_1(int n) {
        return numsSet.contains(n);
    }
    //endregion

    /**
     * 方法二：数学运算
     */
    public boolean isPowerOfFour_2(int n) {
        return n > 0 && (Math.log(n) / Math.log(2) % 2 == 0);
    }

    /**
     * 方法三：位操作
     */
    public boolean isPowerOfFour_3(int n) {
        return n > 0 && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }

    /**
     * 方法四：位运算 + 数学运算
     */
    public boolean isPowerOfFour_4(int n) {
        return n > 0 && ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
