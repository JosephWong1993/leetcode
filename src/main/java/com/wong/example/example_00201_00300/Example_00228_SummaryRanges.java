package com.wong.example.example_00201_00300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 228. 汇总区间
 * https://leetcode-cn.com/problems/summary-ranges/
 */
public class Example_00228_SummaryRanges {
    /**
     * 方法一：一次遍历
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        int i = 0;
        int n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder builder = new StringBuilder(Integer.toString(nums[low]));
            if (low < high) {
                builder.append("->");
                builder.append(Integer.toString(nums[high]));
            }
            list.add(builder.toString());
        }
        return list;
    }
}
