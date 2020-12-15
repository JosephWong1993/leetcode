package com.wong.Example;

import com.wong.Example.Example_00190_ReverseBits;
import org.junit.Before;
import org.junit.Test;

public class Example_00190_ReverseBitsTest {
    private Example_00190_ReverseBits instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00190_ReverseBits();
    }
    
    @Test
    public void reverseBits_1() {
        int n = 964176192;
        System.out.println(n + ":" + instance.reverseBits_1(n));
    }
    
    @Test
    public void reverseBits_2() {
        int n= 43261596;
        System.out.println(n + ":" + instance.reverseBits_2(n));
    }
}