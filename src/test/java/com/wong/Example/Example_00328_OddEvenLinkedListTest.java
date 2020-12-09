package com.wong.Example;

import com.wong.Utils.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00328_OddEvenLinkedListTest {
    @Autowired
    private Example_00328_OddEvenLinkedList instance;
    
    @Test
    public void oddEvenList() {
        ListNode head = new ListNode(1);
        ListNode iteration = head;
        for (int i = 2; i < 6; i++) {
            iteration.next = new ListNode(i);
            iteration = iteration.next;
        }
        ListNode ans = instance.oddEvenList(head);
        iteration = ans;
        while (iteration != null) {
            System.out.print(iteration.val);
            iteration = iteration.next;
        }
        System.out.println();
    }
}