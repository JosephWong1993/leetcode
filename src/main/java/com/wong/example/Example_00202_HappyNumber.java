package com.wong.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * https://leetcode-cn.com/problems/happy-number/
 */
public class Example_00202_HappyNumber {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            totalSum += d * d;
            n = n / 10;
        }
        return totalSum;
    }

    /**
     * 方法一：用 HashSet 检测循环
     */
    public boolean isHappy_1(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 方法二：快慢指针法
     */
    public boolean isHappy_2(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }

    private static Set<Integer> cycleMembers = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    /**
     * 方法三：数学
     */
    public boolean isHappy_3(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }
}
