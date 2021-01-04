package com.wong.example.example_00001_00100;

public class Example_00034_FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * 方法一：二分查找
     */
    public int[] searchRange_1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * 方法二：二分查找
     */
    public int[] searchRange_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = r = mid;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        while (l > 0 && nums[l - 1] == target) {
            l = l - 1;
        }
        while (r < nums.length - 1 && nums[r + 1] == target) {
            r = r + 1;
        }
        return new int[]{l, r};
    }
}
