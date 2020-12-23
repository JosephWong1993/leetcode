package com.wong.example;

import com.wong.model.TreeNode;
import org.springframework.stereotype.Component;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
@Component
public class Example_00105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
    /**
     * 键表示一个元素（节点的值），值表示其在中序遍历中的出现位置
     */
    private Map<Integer, Integer> indexMap;
    
    /**
     * 方法一：递归
     *
     * @param preorder 二叉树的前序遍历
     * @param inorder  二叉树的中序遍历
     * @return 构造出的二叉树结果
     */
    public TreeNode buildTree_1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    
    private TreeNode myBuildTree(int[] preorder,
                                 int[] inorder,
                                 int preorder_left_index,
                                 int preorder_right_index,
                                 int inorder_left_index,
                                 int inorder_right_index) {
        if (preorder_left_index > preorder_right_index) {
            return null;
        }
        //前序遍历中的第一个节点就是根节点
        int preorder_root_index = preorder_left_index;
        //建立根节点
        TreeNode root = new TreeNode(preorder[preorder_root_index]);
        //在中序遍历中定位根节点
        int inorder_root_index = indexMap.get(root.val);
        //得到左子树中的节点数目
        int subtree_left_size = inorder_root_index - inorder_left_index;
        
        //递归构造左子树，并连接到根节点
        //前序遍历中【从左边界+1开始的subtree_left_size】个元素就对应了中序遍历中【从左边界开始到根节点定位-1】的元素
        root.left = myBuildTree(preorder, inorder, preorder_left_index + 1, preorder_left_index + subtree_left_size,
                inorder_left_index, inorder_root_index - 1);
        //递归构造右子树
        //前序遍历中【从左边界+1+左子树节点数目 开始到 右边界】的元素就对应了中序遍历中【从根节点定位+1到右边界】的元素
        root.right = myBuildTree(preorder, inorder, preorder_left_index + subtree_left_size + 1, preorder_right_index,
                inorder_root_index + 1, inorder_right_index);
        return root;
    }
    
    /**
     * 方法二：迭代
     */
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        //[当前节点的所有还没有考虑过右儿子的祖先节点]
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        //当前节点不断向左走达到的最终节点的中序遍历索引
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
