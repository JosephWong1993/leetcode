package com.wong.example;

import com.wong.example.example_00001_00100.Example_00078_Subsets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00078_SubsetsTest {
    
    @Autowired
    private Example_00078_Subsets instance;
    
    private int[] testExample;
    
    @Before
    public void setUp() throws Exception {
        testExample = new int[] { 1, 2, 3 };
    }
    
    @Test
    public void subsets() {
        List<List<Integer>> res = instance.subsets_2(testExample);
        System.out.println(res);
    }
}