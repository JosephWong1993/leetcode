package com.wong.Example_00268;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {
    
    private MissingNumber missingNumber;
    
    @Before
    public void setUp() throws Exception {
        missingNumber = new MissingNumber();
    }
    
    @Test
    public void missingNumber_1() {
        System.out.println(missingNumber.missingNumber_1(new int[] { 3, 0, 1 }));
    }
    
    @Test
    public void missingNumber_2() {
        System.out.println(missingNumber.missingNumber_2(new int[] { 3, 0, 1 }));
    }
    
    @Test
    public void missingNumber_3() {
        System.out.println(missingNumber.missingNumber_3(new int[] { 3, 0, 1 }));
    }
    
    @Test
    public void missingNumber_4() {
        System.out.println(missingNumber.missingNumber_4(new int[] { 3, 0, 1 }));
    }
}