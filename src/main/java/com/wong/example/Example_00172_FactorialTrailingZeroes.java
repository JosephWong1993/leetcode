package com.wong.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Example_00172_FactorialTrailingZeroes {
    /**
     * 方法一：计算阶乘
     */
    public int trailingZeroes_1(int n) {
        BigInteger nFactorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        int zeroCount = 0;
        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            nFactorial = nFactorial.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }

    //region 方法二：计算因子 5
    public int trailingZeroes_2_1(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int curFactor = i;
            while (curFactor % 5 == 0) {
                zeroCount++;
                curFactor = curFactor / 5;
            }
        }
        return zeroCount;
    }

    public int trailingZeroes_2_2(int n) {
        int zeroCount = 0;
        for (int i = 5; i <= n; i += 5) {
            int powerOf5 = 5;
            while (i % powerOf5 == 0) {
                zeroCount++;
                powerOf5 *= 5;
            }
        }
        return zeroCount;
    }
    //endregion

    /**
     * 方法三：高效的计算因子 5
     */

    //region 方法三：高效的计算因子 5
    public int trailingZeroes_3_1(int n) {
        int zeroCount = 0;
        int powerOf5 = 5;
        while (powerOf5 <= n) {
            zeroCount += (n / powerOf5);
            powerOf5 *= 5;
        }
        return zeroCount;
    }

    public int trailingZeroes_3_2(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n = n / 5;
            zeroCount += n;
        }
        return zeroCount;
    }
    //endregion
}
