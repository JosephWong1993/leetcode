package com.wong.example.example_00201_00300;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class Example_00232_ImplementQueueUsingStacks {
}

class MyQueue {
    private final Stack<Integer> stack1;
    
    private final Stack<Integer> stack2;
    
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    
    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack1.pop();
    }
    
    /**
     * Get the front element.
     */
    public int peek() {
        return stack1.peek();
    }
    
    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * 方法一：双栈
 */
class MyQueue_1 {
    private final Deque<Integer> inStack;
    
    private final Deque<Integer> outStack;
    
    /**
     * Initialize your data structure here.
     */
    public MyQueue_1() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }
    
    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inStack.push(x);
    }
    
    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (outStack.isEmpty()) {
            inToOutStack();
        }
        return outStack.pop();
    }
    
    /**
     * Get the front element.
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inToOutStack();
        }
        return outStack.peek();
    }
    
    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    
    private void inToOutStack() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}