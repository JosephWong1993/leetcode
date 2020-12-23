package com.wong.example.example_00001_00100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Example_00015_ThreeSum {
    /**
     * 方法一：排序 + 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                
                if (nums[second] + nums[third] == target) {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[first]);
                    item.add(nums[second]);
                    item.add(nums[third]);
                    ans.add(item);
                }
            }
        }
        return ans;
    }
}
