package com.wong.example.example_00001_00100;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 */
@Component
public class Example_00078_Subsets {
    /**
     * 方法一：迭代法实现子集枚举
     */
    public List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> target = new ArrayList<>();
        for (int mask = 0; mask < (1 << nums.length); mask++) {
            target.clear();
            for (int i = 0; i < nums.length; i++) {
                if (((1 << i) & mask) != 0) {
                    target.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(target));
        }
        return ans;
    }
    
    /**
     * 方法二：递归法实现子集枚举
     */
    public List<List<Integer>> subsets_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        bracktrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void bracktrack(List<List<Integer>> res, List<Integer> target, int[] nums, int first) {
        if (first == nums.length) {
            res.add(new ArrayList<>(target));
            return;
        }
        // 考虑选择当前位置
        target.add(nums[first]);
        bracktrack(res, target, nums, first + 1);
        
        // 考虑不选择当前位置
        target.remove(target.size() - 1);
        bracktrack(res, target, nums, first + 1);
    }
}