package com.wong.Example_00073;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 */
public class SetMatrixZeroes {
    
    /**
     * 方法 1：额外存储空间方法
     */
    public void setZeroes_1(int[][] matrix) {
        Set<Integer> row_set = new HashSet<>();
        Set<Integer> column_set = new HashSet<>();
        
        int r_length = matrix.length;
        int c_length = matrix[0].length;
        for (int row_index = 0; row_index < r_length; row_index++) {
            for (int column_index = 0; column_index < c_length; column_index++) {
                if (matrix[row_index][column_index] == 0) {
                    row_set.add(row_index);
                    column_set.add(column_index);
                }
            }
        }
        
        for (int row_index = 0; row_index < r_length; row_index++) {
            for (int column_index = 0; column_index < c_length; column_index++) {
                if (row_set.contains(row_index) || column_set.contains((column_index))) {
                    matrix[row_index][column_index] = 0;
                }
            }
        }
    }
    
    /**
     * 方法 2
     */
    public void setZeroes_2(int[][] matrix) {
        int r_length = matrix.length;
        int c_length = matrix[0].length;
        boolean isCol = false;
        for (int r_index = 0; r_index < r_length; r_index++) {
            if (matrix[r_index][0] == 0) {
                isCol = true;
            }
            for (int c_index = 1; c_index < c_length; c_index++) {
                if (matrix[r_index][c_index] == 0) {
                    matrix[0][c_index] = 0;
                    matrix[r_index][0] = 0;
                }
            }
        }
        
        for (int r_index = 1; r_index < r_length; r_index++) {
            for (int c_index = 1; c_index < c_length; c_index++) {
                if (matrix[r_index][0] == 0 || matrix[0][c_index] == 0) {
                    matrix[r_index][c_index] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int c_index = 0; c_index < c_length; c_index++) {
                matrix[0][c_index] = 0;
            }
        }
        if (isCol) {
            for (int r_index = 0; r_index < r_length; r_index++) {
                matrix[r_index][0] = 0;
            }
        }
    }
}