package com.wong.Example;

import com.wong.model.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00116_PopulatingNextRightPointersInEachNodeTest {
    
    @Autowired
    private Example_00116_PopulatingNextRightPointersInEachNode instance;
    
    private Node tree;
    
    @Before
    public void setUp() throws Exception {
        tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
    }
    
    @Test
    public void connect_1() {
        tree = instance.connect_1(tree);
    }
    
    @Test
    public void connect_2() {
        tree = instance.connect_2(tree);
    }
}