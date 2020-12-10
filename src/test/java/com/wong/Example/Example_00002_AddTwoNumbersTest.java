package com.wong.Example;

import com.wong.model.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00002_AddTwoNumbersTest {
    
    @Autowired
    private Example_00002_AddTwoNumbers instance;
    
    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode ans = instance.addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println();
    }
}