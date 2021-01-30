package com.wong.example.example_00101_00200;

import com.wong.model.Node;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
@Component
public class Example_00116_PopulatingNextRightPointersInEachNode {
    /**
     * 方法一：层次遍历
     * 基于广度优先搜索
     */
    public Node connect_1(Node root) {
        if (root == null) {
            return null;
        }
        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for (int i = 0; i < size; i++) {
                // 从队首取出元素
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                // 连接
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 拓展下一层节点
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
    
    /**
     * 方法二：使用已建立的 \text{next}next 指针
     */
    public Node connect_2(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            //遍历这层节点组织成的链表，为下一层的节点更新next指针
            Node head = leftmost;
            while (head != null) {
                //建立连接1
                head.left.next = head.right;
                
                //建立连接2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                //指针向后移动
                head = head.next;
            }
            //去下一层最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
