package com.wong.Example;

import com.wong.model.TreeNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 */
@Component
public class Example_00103_BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 方法一：BFS（广度优先遍历）
     */
    public List<List<Integer>> zigzagLevelOrder_1(TreeNode root) {
        List<List<Integer>> result_list = new ArrayList<>();
        if (root == null) {
            return result_list;
        }
        
        LinkedList<TreeNode> node_queue = new LinkedList<>();
        node_queue.addLast(root);
        //分隔符（例如：空节点）把不同层的节点分隔开。分隔符表示一层结束和新一层开始。
        //node_queue是一个队列，以null分割每一层节点。
        node_queue.addLast(null);
        
        //level_list是一个双端队列
        LinkedList<Integer> level_list = new LinkedList<>();
        boolean is_order_left = true;
        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left) {
                    level_list.addLast(curr_node.val);
                } else {
                    level_list.addFirst(curr_node.val);
                }
                if (curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }
                if (curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {
                result_list.add(level_list);
                level_list = new LinkedList<>();
                if (node_queue.size() > 0) {
                    node_queue.addLast(null);
                }
                is_order_left = !is_order_left;
            }
        }
        return result_list;
    }
    
    /**
     * 方法二：DFS （深度优先遍历）
     */
    public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
        List<List<Integer>> result_list = new ArrayList<>();
        if (root == null) {
            return result_list;
        }
        DFS(root, 0, result_list);
        return result_list;
    }
    
    private void DFS(TreeNode node, int level, List<List<Integer>> resultList) {
        if (level >= resultList.size()) {
            //第一次访问该层的节点，创建一个双端队列，并添加该节点到队列中。
            LinkedList<Integer> new_level_list = new LinkedList<>();
            new_level_list.addLast(node.val);
            resultList.add(new_level_list);
        } else {
            //如果当前层的双端队列已存在，根据顺序，将当前节点插入队列头部或尾部。
            if (level % 2 == 0) {
                resultList.get(level).add(node.val);
            } else {
                resultList.get(level).add(0, node.val);
            }
        }
        //最后，为每个节点调用该递归方法。
        if (node.left != null) {
            DFS(node.left, level + 1, resultList);
        }
        if (node.right != null) {
            DFS(node.right, level + 1, resultList);
        }
    }
}
