package com.wong.example.example_00201_00300;

import com.wong.model.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class Example_00226_InvertBinaryTree {
    /**
     * 方法一：递归
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copyNode = new TreeNode(root.val);
        copyNode.left = invertTree(root.right);
        copyNode.right = invertTree(root.left);
        return copyNode;
    }
}
