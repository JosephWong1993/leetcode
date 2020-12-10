package com.wong.Example;

import com.wong.model.ListNode;
import org.springframework.stereotype.Component;

/**
 * 328. 奇偶链表
 */
@Component
public class Example_00328_OddEvenLinkedList {
    /**
     * 方法一：分离节点后合并
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
