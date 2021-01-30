package com.wong.example.example_00101_00200;

/**
 * 171. Excel表列序号
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class Example_00171_ExcelColumnNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }
}