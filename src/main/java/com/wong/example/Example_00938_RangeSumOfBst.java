package com.wong.example;

import com.wong.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. 二叉搜索树的范围和
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class Example_00938_RangeSumOfBst {
    /**
     * 方法一：深度优先搜索
     */
    public int rangeSumBST_1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST_1(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST_1(root.left, low, high);
        }
        return root.val + rangeSumBST_1(root.left, low, high) + rangeSumBST_1(root.right, low, high);
    }

    /**
     * 方法二：广度优先搜索
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (node.val < low) {
                queue.offer(node.right);
            } else if (node.val > high) {
                queue.offer(node.left);
            } else {
                sum += node.val;
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sum;
    }
}