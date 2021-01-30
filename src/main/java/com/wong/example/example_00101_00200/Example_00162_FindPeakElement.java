package com.wong.example.example_00101_00200;

/**
 * 162. 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 */
public class Example_00162_FindPeakElement {
    /**
     * 方法一: 线性扫描
     */
    public int findPeakElement_1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    /**
     * 方法二：递归二分查找
     */
    public int findPeakElement_2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        } else {
            return search(nums, mid + 1, r);
        }
    }

    /**
     * 方法三：迭代二分查找
     */
    public int findPeakElement_3(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
