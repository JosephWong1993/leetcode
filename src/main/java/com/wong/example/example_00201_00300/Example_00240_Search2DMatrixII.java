package com.wong.example.example_00201_00300;

/**
 * 240. 搜索二维矩阵 II
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */
public class Example_00240_Search2DMatrixII {
    /**
     * 方法一：暴力法
     */
    public boolean searchMatrix_1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法二：二分法搜索
     */
    public boolean searchMatrix_2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            boolean verticalFound = binarySearch(matrix, target, i, true);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix.length - 1 : matrix[start].length - 1;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (vertical) {
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else {
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法三：搜索空间的缩减
     */
    public boolean searchMatrix_3(int[][] matrix, int target) {
        // 一个空矩阵中显然不会包含 target
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean searchRec(int[][] matrix, int target, int up, int down, int left, int right) {
        // 这个子矩阵不存在 高度 或 宽度
        if (up > down || left > right) {
            return false;
        }
        // 在这个子矩阵中 target 已经比最小的元素更小 或比 最大的元素更大
        else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = (left + right) / 2;

        // 锁定满足 matrix[row-1][mid] < target <matrix[row][mid] 的行
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }

        // 搜索 左下 和 右上 两个子矩阵
        return searchRec(matrix, target, row, down, left, mid - 1) ||
                searchRec(matrix, target, up, row - 1, mid + 1, right);
    }


    /**
     * 方法四
     */
    public boolean searchMatrix_4(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] < target) {
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
