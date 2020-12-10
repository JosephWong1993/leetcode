package com.wong.Example;

import com.wong.model.ListNode;
import com.wong.utils.ListNodeHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00160_IntersectionOfTwoLinkedListsTest {
    
    @Autowired
    private Example_00160_IntersectionOfTwoLinkedLists instance;
    
    private ListNode headA = null;
    
    private ListNode headB = null;
    
    @Before
    public void setUp() throws Exception {
        headA = ListNodeHelper.createListNode(new int[] { 4, 1, 8, 4, 5 });
        headB = ListNodeHelper.createListNode(new int[] { 5, 6 });
        headB.next.next = headA.next;
    }
    
    @Test
    public void getIntersectionNode_1() {
        ListNode ans = instance.getIntersectionNode_1(headA, headB);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println();
    }
    
    @Test
    public void getIntersectionNode_2() {
        ListNode ans = instance.getIntersectionNode_2(headA, headB);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println();
    }
    
    @Test
    public void getIntersectionNode_3() {
        ListNode ans = instance.getIntersectionNode_3(headA, headB);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println();
    }
    
}