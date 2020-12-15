package com.wong.Example;

import com.wong.Example.Example_00334_IncreasingTripletSubsequence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00334_IncreasingTripletSubsequenceTest {
    @Autowired
    private Example_00334_IncreasingTripletSubsequence instance;
    
    @Test
    public void increasingTriplet_1() {
        System.out.println(instance.increasingTriplet_1(new int[] { 1, 2, 3, 4, 5 }));
    }
    
    @Test
    public void increasingTriplet_2() {
        System.out.println(instance.increasingTriplet_2(new int[] { 1, 2, 3, 4, 5 }));
    }
    
    @Test
    public void increasingTriplet_3() {
        System.out.println(instance.increasingTriplet_3(new int[] { 1, 2, 3, 4, 5 }));
    }
}