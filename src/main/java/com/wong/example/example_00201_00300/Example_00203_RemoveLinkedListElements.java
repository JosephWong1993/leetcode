package com.wong.example.example_00201_00300;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class Example_00203_RemoveLinkedListElements {
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    
    /**
     * 方法：哨兵节点
     */
    public ListNode removeElements_1(ListNode head, int val) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}

class ListNode {
    int val;
    
    ListNode next;
    
    ListNode() {
    }
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}