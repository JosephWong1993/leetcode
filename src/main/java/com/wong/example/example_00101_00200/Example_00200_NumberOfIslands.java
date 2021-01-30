package com.wong.example.example_00101_00200;

import java.util.LinkedList;
import java.util.Queue;

public class Example_00200_NumberOfIslands {
    /**
     * 方法一：深度优先搜索
     */
    public int numIslands_1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        int islandsNum = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    islandsNum++;
                    dfs(grid, r, c);
                }
            }
        }
        return islandsNum;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length; //获取数组的行数
        int nc = grid[0].length; //获取数组的列数
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
    
    /**
     * 方法二：广度优先搜索
     */
    public int numIslands_2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int nr = grid.length;
        int nc = grid[0].length;
        int islandsNum = 0;
        
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    islandsNum++;
                    grid[r][c] = '0';
                    
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            grid[row - 1][col] = '0';
                            neighbors.add((row - 1) * nc + col);
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            grid[row + 1][col] = '0';
                            neighbors.add((row + 1) * nc + col);
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            grid[row][col - 1] = '0';
                            neighbors.add(row * nc + col - 1);
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            grid[row][col + 1] = '0';
                            neighbors.add(row * nc + col + 1);
                        }
                    }
                }
            }
        }
        return islandsNum;
    }
}
