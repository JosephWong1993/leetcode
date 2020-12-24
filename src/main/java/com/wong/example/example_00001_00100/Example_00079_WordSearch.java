package com.wong.example.example_00001_00100;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 */
public class Example_00079_WordSearch {
    /**
     * 方法一：深度优先搜索
     */
    public boolean exist_1(char[][] board, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        for (int rowIndex = 0; rowIndex < rowLength; rowIndex++) {
            for (int colIndex = 0; colIndex < colLength; colIndex++) {
                if (check(board, visited, rowIndex, colIndex, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, boolean[][] visited, int rowIndex, int colIndex, String word, int wordIndex) {
        if (board[rowIndex][colIndex] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1) {
            return true;
        }
        visited[rowIndex][colIndex] = true;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        boolean result = false;
        for (int[] dir : directions) {
            int newRowIndex = rowIndex + dir[0];
            int newColIndex = colIndex + dir[1];
            if (newRowIndex >= 0 && newRowIndex < board.length && newColIndex >= 0 && newColIndex < board[0].length) {
                if (!visited[newRowIndex][newColIndex]) {
                    result = check(board, visited, newRowIndex, newColIndex, word, wordIndex + 1);
                    if (result) {
                        break;
                    }
                }
            }
        }
        visited[rowIndex][colIndex] = false;
        return result;
    }
    
    /**
     * 方法二：回溯
     */
    public boolean exist_2(char[][] board, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;
        for (int rowIndex = 0; rowIndex < rowLength; rowIndex++) {
            for (int colIndex = 0; colIndex < colLength; colIndex++) {
                if (breaktrack(board, rowIndex, colIndex, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean breaktrack(char[][] board, int rowIndex, int colIndex, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (rowIndex < 0 || rowIndex >= board.length || colIndex < 0 || colIndex >= board[0].length) {
            return false;
        }
        if (board[rowIndex][colIndex] != word.charAt(index)) {
            return false;
        }
        
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        char c = board[rowIndex][colIndex];
        board[rowIndex][colIndex] = ' ';
        boolean result = true;
        for (int[] dir : directions) {
            result = breaktrack(board, rowIndex + dir[0], colIndex + +dir[1], word, index + 1);
            if (result) {
                break;
            }
        }
        board[rowIndex][colIndex] = c;
        return result;
    }
}