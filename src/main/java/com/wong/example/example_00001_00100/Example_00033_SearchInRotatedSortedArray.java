package com.wong.example.example_00001_00100;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Example_00033_SearchInRotatedSortedArray {
    /**
     * 方法一：二分搜索
     */
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int n=nums.length;
        if(n==1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
