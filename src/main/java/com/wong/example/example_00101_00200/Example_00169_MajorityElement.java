package com.wong.example.example_00101_00200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 */
public class Example_00169_MajorityElement {
    //region 方法一：哈希表
    public int majorityElement_1(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);
        
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
    
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        return counts;
    }
    //endregion
    
    /**
     * 方法二：排序
     */
    public int majorityElement_2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    //region 方法三：随机化
    public int majorityElement_3(int[] nums) {
        Random rand = new Random();
        
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurrences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
    
    public int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
    public int countOccurrences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    //endregion
    
    //region 方法四：分治
    public int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
    
    private int majorityElementRec(int[] nums, int lo, int hi) {
        //在长度为1的数组中唯一的元素是多数元素
        if (lo == hi) {
            return nums[lo];
        }
        
        int mid = (hi - lo) / 2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);
        
        if (left == right) {
            return left;
        }
        
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }
    
    public int majorityElement_4(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
    //endregion
    
    /**
     * 方法五：Boyer-Moore 投票算法
     */
    public int majorityElement_5(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
