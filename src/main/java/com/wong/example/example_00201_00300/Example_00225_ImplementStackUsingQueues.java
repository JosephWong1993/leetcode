package com.wong.example.example_00201_00300;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class Example_00225_ImplementStackUsingQueues {

}

/**
 * 方法一：两个队列
 */
class MyStack_1 {
    private Queue<Integer> queue1;
    
    private Queue<Integer> queue2;
    
    /**
     * Initialize your data structure here.
     */
    public MyStack_1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue1.poll();
    }
    
    /**
     * Get the top element.
     */
    public int top() {
        return queue1.peek();
    }
    
    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * 方法二：一个队列
 */
class MyStack_2 {
    private Queue<Integer> queue;
    
    /**
     * Initialize your data structure here.
     */
    public MyStack_2() {
        queue = new LinkedList<>();
    }
    
    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    
    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }
    
    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }
    
    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}