package com.wong.example.example_00201_00300;

/**
 * 258. 各位相加
 * https://leetcode-cn.com/problems/add-digits/
 */
public class Example_00258_AddDigits {
    public int addDigits(int num) {
        while (num > 10) {
            num = getAddByBitNumber(num);
        }
        return num;
    }

    private int getAddByBitNumber(int num) {
        if (num < 0) {
            return num;
        } else {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            return sum;
        }
    }

    /**
     * 方法一：O(1)
     */
    public int addDigits_1(int num) {
//        if (num < 10) {
//            return num;
//        }
//        num = num % 9;
//        if (num == 0) {
//            num = 9;
//        }
//        return num;
        return (num - 1) % 9 + 1;
    }
}