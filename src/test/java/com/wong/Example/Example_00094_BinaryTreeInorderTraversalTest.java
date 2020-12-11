package com.wong.Example;

import com.wong.model.TreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00094_BinaryTreeInorderTraversalTest {
    
    @Autowired
    private Example_00094_BinaryTreeInorderTraversal instance;
    
    private TreeNode treeNode;
    
    @Before
    public void setUp() throws Exception {
        treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
    }
    
    @Test
    public void inorderTraversal_1() {
        System.out.println(instance.inorderTraversal_1(treeNode));
    }
    
    @Test
    public void inorderTraversal_2() {
        System.out.println(instance.inorderTraversal_2(treeNode));
    }
    
    @Test
    public void inorderTraversal_3() {
        System.out.println(instance.inorderTraversal_3(treeNode));
    }
}