package com.wong.example.example_00001_00100;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class Example_00062_UniquePaths {
    /**
     * 方法一：动态规划
     */
    public int uniquePaths_1(int m, int n) {
        int[][] f = new int[m][n];
        for (int r = 0; r < m; r++) {
            f[r][0] = 1;
        }

        for (int c = 0; c < n; c++) {
            f[0][c] = 1;
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                f[r][c] = f[r - 1][c] + f[r][c - 1];
            }
        }

        return f[m - 1][n - 1];
    }

    // TODO:还有其他解法
}
