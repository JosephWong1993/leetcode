package com.wong.example.example_00101_00200;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class Example_00118_PascalTriangle {
    /**
     * 方法：动态规划
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows < 1) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for (int rowIndex = 1; rowIndex < numRows; rowIndex++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(rowIndex - 1);
            
            row.add(1);
            
            for (int j = 1; j < rowIndex; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
