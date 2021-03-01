package com.wong.example;

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

class TreeNode {
    int val;
    
    TreeNode left;
    
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
