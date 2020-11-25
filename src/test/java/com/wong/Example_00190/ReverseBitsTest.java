package com.wong.Example_00190;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseBitsTest {
    private ReverseBits reverseBits;
    
    @Before
    public void setUp() throws Exception {
        reverseBits = new ReverseBits();
    }
    
    @Test
    public void reverseBits_1() {
        System.out.println(reverseBits.reverseBits_1(43261596));
    }
}