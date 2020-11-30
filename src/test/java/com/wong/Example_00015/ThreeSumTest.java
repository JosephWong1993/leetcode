package com.wong.Example_00015;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ThreeSumTest {
    
    private ThreeSum instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new ThreeSum();
    }
    
    @Test
    public void threeSum() {
        System.out.println(instance.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}