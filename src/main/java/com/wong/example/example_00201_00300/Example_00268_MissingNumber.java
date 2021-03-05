package com.wong.example.example_00201_00300;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268. 丢失的数字
 */
public class Example_00268_MissingNumber {
    /**
     * 方法一：排序
     */
    public int missingNumber_1(int[] nums) {
        Arrays.sort(nums);
        
        if (nums[0] != 0) {
            return 0;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        
        return nums.length;
    }
    
    /**
     * 方法二：哈希表
     */
    public int missingNumber_2(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        for (int number = 0; number <= nums.length; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        
        return -1;
    }
    
    /**
     * 方法三：位运算
     */
    public int missingNumber_3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
    
    /**
     * 方法四：数学
     */
    public int missingNumber_4(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSUm = 0;
        for (int num : nums) {
            actualSUm += num;
        }
        return expectedSum - actualSUm;
    }
}
