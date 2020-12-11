package com.wong.Example;

import com.wong.model.TreeNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
@Component
public class Example_00094_BinaryTreeInorderTraversal {
    /**
     * 方法一：递归
     */
    public List<Integer> inorderTraversal_1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    
    /**
     * 方法二：栈
     */
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    
    /**
     * 方法三：Morris 中序遍历
     */
    public List<Integer> inorderTraversal_3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null) {
            // 如果没有左孩子，则直接访问右孩子
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                //predecessor 节点就是当前root节点向左一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    predecessor.right = root;
                    root = root.left;
                } else {
                    // 说明左子树已经访问完了，我们需要断开链接
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }
}
