package com.wong.example.example_00301_00400;

public class Example_00371_SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            // 计算二进制无进位累加值
            int temp = a ^ b;
            // 计算二进制累加进位值
            b = (a & b) << 1;
            
            a = temp;
        }
        return a;
    }
}
