package com.wong.example.example_00101_00200;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 137. 只出现一次的数字 II
 * https://leetcode-cn.com/problems/single-number-ii/
 */
public class Example_00137_SingleNumberII {

    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                count++;
            } else {
                if (count == 1) {
                    return pre;
                } else {
                    count = 1;
                    pre = nums[i];
                }
            }
        }
        return pre;
    }

    /**
     * 方法一：哈希表
     */
    public int singleNumber_1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    /**
     * 方法二：依次确定每一个二进制位
     */
    public int singleNumber_2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    //TODO：方法三：数字电路设计

    //TODO：方法四：数字电路设计优化
}
