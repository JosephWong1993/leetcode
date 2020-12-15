package com.wong.Example;

import com.wong.Example.Example_00118_PascalTriangle;
import org.junit.Before;
import org.junit.Test;

public class Example_00118_PascalTriangleTest {
    
    private Example_00118_PascalTriangle instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00118_PascalTriangle();
    }
    
    @Test
    public void generate() {
        System.out.println(instance.generate(5));
    }
}