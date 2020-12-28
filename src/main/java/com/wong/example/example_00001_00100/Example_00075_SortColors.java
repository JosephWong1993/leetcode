package com.wong.example.example_00001_00100;

/**
 * 75. 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 */
public class Example_00075_SortColors {
    /**
     * 方法一：单指针
     */
    public void sortColors_1(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[ptr];
                nums[ptr] = nums[i];
                nums[i] = temp;
                ptr++;
            }
        }
    }

    /**
     * 方法二：双指针
     */
    public void sortColors_2(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            } else if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                if (p0 < p1) {
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                }
                p1++;
                p0++;
            }
        }
    }

    /**
     * 方法三：双指针
     */
    public void sortColors_3(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (nums[i] == 2 && i <= p2) {
                int temp = nums[p2];
                nums[p2] = nums[i];
                nums[i] = temp;
                p2--;
            }
            if (nums[i] == 0) {
                int temp = nums[p0];
                nums[p0] = nums[i];
                nums[i] = temp;
                p0++;
            }
        }
    }
}
