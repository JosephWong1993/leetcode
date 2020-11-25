package com.wong.Example_00190;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class ReverseBitsTest {
    private ReverseBits reverseBits;
    
    @Before
    public void setUp() throws Exception {
        reverseBits = new ReverseBits();
    }
    
    @Test
    public void reverseBits_1() {
        int n = 964176192;
        System.out.println(n + ":" + reverseBits.reverseBits_1(n));
    }
    
    @Test
    public void reverseBits_2() {
        int n= 43261596;
        System.out.println(n + ":" + reverseBits.reverseBits_2(n));
    }
}