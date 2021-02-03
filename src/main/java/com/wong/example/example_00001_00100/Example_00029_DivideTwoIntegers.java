package com.wong.example.example_00001_00100;

import org.springframework.stereotype.Component;

@Component
public class Example_00029_DivideTwoIntegers {
    /**
     * 方法:二分查找
     */
    public int divide(int dividend, int divisor) {
        boolean sign = (dividend ^ divisor) < 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dividendAbs = dividend;
        dividendAbs = dividend >= 0 ? dividend : -dividendAbs;
        long divisorAbs = divisor;
        divisorAbs = divisor >= 0 ? divisor : -divisorAbs;
        long l = 0, r = dividendAbs;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (mid * divisorAbs <= dividendAbs) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int) (sign ? -ans : ans);
    }
}
