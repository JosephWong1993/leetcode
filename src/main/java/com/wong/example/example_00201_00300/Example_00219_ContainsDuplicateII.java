package com.wong.example.example_00201_00300;

import java.util.*;

/**
 * 219. 存在重复元素 II
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 */
public class Example_00219_ContainsDuplicateII {
    /**
     * 方法:哈希表
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if (map.containsKey(item) && i - map.get(item) <= k) {
                return true;
            } else {
                map.put(item, i);
            }
        }
        return false;
    }
    
    /**
     * 方法一 （线性搜索）
     */
    public boolean containsNearbyDuplicate_1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < i; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * 方法二 （二叉搜索树）
     */
    public boolean containsNearbyDuplicate_2(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    
    /**
     * 方法三 （散列表）
     */
    public boolean containsNearbyDuplicate_3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
