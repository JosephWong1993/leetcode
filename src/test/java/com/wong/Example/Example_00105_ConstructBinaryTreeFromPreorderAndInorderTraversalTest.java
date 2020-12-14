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
public class Example_00105_ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    
    @Autowired
    private Example_00105_ConstructBinaryTreeFromPreorderAndInorderTraversal instance;
    
    private int[] preorder;
    
    private int[] inorder;
    
    @Before
    public void setUp() throws Exception {
        preorder = new int[] { 3, 9, 20, 15, 7 };
        inorder = new int[] { 9, 3, 15, 20, 7 };
    }
    
    @Test
    public void buildTree() {
        TreeNode tree = instance.buildTree_1(preorder, inorder);
        System.out.println(tree);
    }
}