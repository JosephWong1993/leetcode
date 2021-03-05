package com.wong.example.example_00201_00300;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    //region 方法三：贪心枚举
    public int numSquares_3(int n) {
        Set<Integer> square_nums = new HashSet<>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }
        
        int count = 1;
        while (count <= n) {
            if (is_divided_by(square_nums, n, count)) {
                return count;
            }
            count++;
        }
        return count;
    }
    
    private boolean is_divided_by(Set<Integer> square_nums, int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }
        
        for (Integer square : square_nums) {
            if (is_divided_by(square_nums, n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }
    //endregion
    
    /**
     * 方法四：贪心 + BFS（广度优先搜索）
     */
    public int numSquares_4(int n) {
        List<Integer> square_nums = new ArrayList<>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }
        
        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        
        int level = 0;
        while (queue.size() > 0) {
            level++;
            Set<Integer> next_queue = new HashSet<>();
            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
    
    //TODO：方法五：数学运算
}