package com.wong.Example_00334;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 334. 递增的三元子序列
 */
@Component
@Scope("singleton")
public class IncreasingTripletSubsequence {
    /**
     * 方法一：双指针
     */
    public boolean increasingTriplet_1(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 方法二：动态规划
     */
    public boolean increasingTriplet_2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (dp[i] >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 方法三：前后遍历
     */
    public boolean increasingTriplet_3(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        Arrays.fill(mins, nums[0]);
        Arrays.fill(maxs, nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(nums[i], mins[i - 1]);
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            maxs[i] = Math.max(nums[i], maxs[i + 1]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (mins[i] < nums[i] && nums[i] < maxs[i]) {
                return true;
            }
        }
        return false;
    }
}
