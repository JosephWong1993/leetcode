package com.wong.example;

import com.wong.model.TreeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class Example_00294_SerializeAndDeserializeBinaryTreeTest {

    @Autowired
    private Example_00294_SerializeAndDeserializeBinaryTree instance;

    private TreeNode testNode;

    @Before
    public void setUp() throws Exception {
        testNode = new TreeNode(1);
        testNode.left = new TreeNode(2);
        testNode.right = new TreeNode(3);
        testNode.right.left = new TreeNode(4);
        testNode.right.right = new TreeNode(5);
    }

    @Test
    public void test_1() {
        String str = instance.serialize_1(testNode);
        TreeNode ansNode = instance.deserialize_1(str);
        System.out.println(ansNode);
    }
}