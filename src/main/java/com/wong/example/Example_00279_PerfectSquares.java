package com.wong.example;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
@Component
public class Example_00279_PerfectSquares {
    //region 方法一：暴力枚举法 [超出时间限制]
    public int numSquares_1(int n) {
        //预先计算可能的平方数
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }
        return minNumSquares(square_nums, n);
    }
    
    private int minNumSquares(int[] square_nums, int k) {
        for (int i = 0; i < square_nums.length; i++) {
            if (k == square_nums[i]) {
                return 1;
            }
        }
        
        int min_num = Integer.MAX_VALUE;
        
        for (int i = 1; i < square_nums.length; ++i) {
            if (k < square_nums[i]) {
                break;
            }
            
            int new_num = minNumSquares(square_nums, (k - square_nums[i])) + 1;
            min_num = Math.min(min_num, new_num);
        }
        return min_num;
    }
    //endregion
    
    /**
     * 方法二：动态规划
     */
    public int numSquares_2(int n) {
        //创建一个一维数组dp来保存中间子解的值
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        //预先计算可能的平方数
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }
        
        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }
    
    //TODO：方法三：贪心枚举
}