package com.wong.utils;

import com.wong.model.ListNode;

public class ListNodeHelper {
    public static ListNode createListNode(int[] array) {
        ListNode head = null;
        ListNode cur = null;
        for (int num : array) {
            if (head == null) {
                cur = head = new ListNode(num);
            } else {
                cur.next = new ListNode(num);
                cur = cur.next;
            }
        }
        return head;
    }
}
