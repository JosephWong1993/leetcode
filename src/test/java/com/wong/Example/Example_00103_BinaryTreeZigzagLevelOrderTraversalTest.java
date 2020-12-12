package com.wong.Example;

import com.wong.model.TreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00103_BinaryTreeZigzagLevelOrderTraversalTest {
    
    @Autowired
    private Example_00103_BinaryTreeZigzagLevelOrderTraversal instance;
    
    private TreeNode treeNode;
    
    @Before
    public void setUp() throws Exception {
        treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
    }
    
    @Test
    public void zigzagLevelOrder_1() {
        List<List<Integer>> list = instance.zigzagLevelOrder_1(treeNode);
        System.out.println(list);
    }
    
    @Test
    public void zigzagLevelOrder_2() {
        List<List<Integer>> list = instance.zigzagLevelOrder_2(treeNode);
        System.out.println(list);
    }
}