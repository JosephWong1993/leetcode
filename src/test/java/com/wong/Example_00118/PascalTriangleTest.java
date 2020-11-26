package com.wong.Example_00118;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PascalTriangleTest {
    
    private PascalTriangle pascalTriangle;
    
    @Before
    public void setUp() throws Exception {
        pascalTriangle = new PascalTriangle();
    }
    
    @Test
    public void generate() {
        System.out.println(pascalTriangle.generate(5));
    }
}