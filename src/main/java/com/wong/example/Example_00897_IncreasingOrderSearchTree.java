package com.wong.example;

import com.wong.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class Example_00897_IncreasingOrderSearchTree {
    //region 方法一：中序遍历之后生成新的树
    public TreeNode increasingBST_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (Integer value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
    //endregion

    //region 方法二：在中序遍历的过程中改变节点指向
    public TreeNode increasingBST_2(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        TreeNode resNode = dummyNode;
        inorder(root, resNode);
        return dummyNode.right;
    }

    private TreeNode inorder(TreeNode node, TreeNode resNode) {
        if (node == null) {
            return resNode;
        }
        resNode = inorder(node.left, resNode);

        resNode.right = node;
        node.left = null;
        resNode = node;

        resNode = inorder(node.right, resNode);
        return resNode;
    }
    //endregion
}