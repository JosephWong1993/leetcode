package com.wong.example.example_00301_00400;

import java.util.*;

/**
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class Example_00349_IntersectionOfTwoArrays {
    /**
     * 方法一：两个集合
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(n -> set.add(n));

        Arrays.stream(nums2).forEach(n -> {
            if (set.contains(n)) {
                ans.add(n);
            }
        });
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 方法二：排序 + 双指针
     */
    public int[] intersection_2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] intersection = new int[Math.max(length1, length2)];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}