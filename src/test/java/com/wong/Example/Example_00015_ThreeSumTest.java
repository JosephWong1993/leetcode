package com.wong.Example;

import com.wong.Example.Example_00015_ThreeSum;
import org.junit.Before;
import org.junit.Test;

public class Example_00015_ThreeSumTest {
    
    private Example_00015_ThreeSum instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00015_ThreeSum();
    }
    
    @Test
    public void threeSum() {
        System.out.println(instance.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}