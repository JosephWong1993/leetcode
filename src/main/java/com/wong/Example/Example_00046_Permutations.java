package com.wong.Example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 */
@Component
public class Example_00046_Permutations {
    /**
     * 方法一：搜索回溯
     */
    public List<List<Integer>> permute_1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        
        bracktrack(res, output, nums.length, 0);
        return res;
    }
    
    private void bracktrack(List<List<Integer>> res, List<Integer> output, int n, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            //继续递归填下一个数
            bracktrack(res, output, n, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
    
    /**
     * 方法二：回溯算法
     */
    public List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> source = new ArrayList<>();
        for (int num : nums) {
            source.add(num);
        }
        
        bracktrack(res, source, new ArrayList<Integer>());
        return res;
    }
    
    private void bracktrack(List<List<Integer>> res, List<Integer> source, List<Integer> output) {
        if (source.size()==0) {
            res.add(new ArrayList<>(output));
        } else {
            for (int i =0; i < source.size(); i++) {
                output.add(source.remove(i));
                bracktrack(res, source, output);
                source.add(i, output.remove(output.size() - 1));
            }
        }
    }
}
