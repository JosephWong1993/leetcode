package com.wong.example.example_00201_00300;

import com.wong.model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class Example_00230_KthSmallestElementInABST {
    /**
     * 方法一：递归
     */
    public int kthSmallest_1(TreeNode root, int k) {
        List<Integer> inorderNums = inorder(root, new ArrayList<>());
        return inorderNums.get(k - 1);
    }
    
    private List<Integer> inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }
    
    /**
     * 方法二：迭代
     */
    public int kthSmallest_2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
            node = node.right;
        }
        return -1;
    }
}
