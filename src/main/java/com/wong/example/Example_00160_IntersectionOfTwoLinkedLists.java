package com.wong.example;

import com.wong.model.ListNode;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 */
@Component
public class Example_00160_IntersectionOfTwoLinkedLists {
    /**
     * 方法一: 暴力法
     */
    public ListNode getIntersectionNode_1(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = null;
        while (curA != null) {
            curB = headB;
            while (curB != null) {
                if (curA == curB) {
                    return curA;
                }
                curB = curB.next;
            }
            curA = curA.next;
        }
        return null;
    }
    
    /**
     * 方法二: 哈希表法
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        Set<ListNode> set = new HashSet<>();
        while (curA != null) {
            set.add(curA);
            curA = curA.next;
        }
        while (curB != null) {
            if (set.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }
    
    /**
     * 方法三：双指针法
     */
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }
}
