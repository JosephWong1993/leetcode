package com.wong.example;

/**
 * 300. 最长递增子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Example_00300_LongestIncreasingSubsequence {

    /**
     * 方法一：动态规划
     */
    public int lengthOfLIS_1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    //TODO：还有其他解法
}
