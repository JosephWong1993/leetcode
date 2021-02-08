package com.wong.example.example_00101_00200;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class Example_00150_EvaluateReversePolishNotation {
    /**
     * 方法：栈
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer first = stack.pop();
                    Integer second = stack.pop();
                    stack.push(second - first);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer dividend = stack.pop();
                    Integer divisor = stack.pop();
                    stack.push(divisor / dividend);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}