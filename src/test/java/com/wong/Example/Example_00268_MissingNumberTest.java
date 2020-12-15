package com.wong.Example;

import org.junit.Before;
import org.junit.Test;

public class Example_00268_MissingNumberTest {
    
    private Example_00268_MissingNumber instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00268_MissingNumber();
    }
    
    @Test
    public void missingNumber_1() {
        System.out.println(instance.missingNumber_1(new int[] { 3, 0, 1 }));
    }
    
    @Test
    public void missingNumber_2() {
        System.out.println(instance.missingNumber_2(new int[] { 3, 0, 1 }));
    }
    
    @Test
    public void missingNumber_3() {
        System.out.println(instance.missingNumber_3(new int[] { 3, 0, 1 }));
    }
    
    @Test
    public void missingNumber_4() {
        System.out.println(instance.missingNumber_4(new int[] { 3, 0, 1 }));
    }
}