package com.wong.Example;

import com.wong.model.ListNode;
import org.springframework.stereotype.Component;

/**
 * 2. 两数相加
 */
@Component
public class Example_00002_AddTwoNumbers {
    /**
     * 方法一：模拟
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        ListNode l1_index = l1;
        ListNode l2_index = l2;
        int carry = 0;
        while (l1_index != null || l2_index != null) {
            int num1 = l1_index != null ? l1_index.val : 0;
            int num2 = l2_index != null ? l2_index.val : 0;
            int sum = num1 + num2 + carry;
            if (tail == null) {
                tail = head = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1_index != null) {
                l1_index = l1_index.next;
            }
            if (l2_index != null) {
                l2_index = l2_index.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
