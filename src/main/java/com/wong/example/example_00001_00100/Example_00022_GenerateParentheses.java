package com.wong.example.example_00001_00100;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
@Component
public class Example_00022_GenerateParentheses {
    /**
     * 方法一：暴力法
     */
    public List<String> generateParenthesis_1(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }
    
    private void generateAll(char[] currrent, int pos, List<String> result) {
        if (pos == currrent.length) {
            if (valid(currrent)) {
                result.add(new String(currrent));
            }
        } else {
            currrent[pos] = '(';
            generateAll(currrent, pos + 1, result);
            currrent[pos] = ')';
            generateAll(currrent, pos + 1, result);
        }
    }
    
    private boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
    
    /**
     * 方法二：回溯法
     */
    public List<String> generateParenthesis_2(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
    
    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    
    List<String>[] cache = new ArrayList[100];
    
    /**
     * 方法三：按括号序列的长度递归
     */
    public List<String> generateParenthesis_3(int n) {
        return generate(n);
    }
    
    private List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++) {
                for (String left : generate(c)) {
                    for (String right : generate(n - c - 1)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }
}