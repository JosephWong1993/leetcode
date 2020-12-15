package com.wong.Example;

import com.wong.Example.Example_00020_ValidParentheses;
import org.junit.Before;
import org.junit.Test;

public class Example_00020_ValidParenthesesTest {
    private Example_00020_ValidParentheses example_00020_ValidParentheses;
    
    @Before
    public void setUp() throws Exception {
        example_00020_ValidParentheses = new Example_00020_ValidParentheses();
    }
    
    @Test
    public void isValid() {
        System.out.println(example_00020_ValidParentheses.isValid("()"));
    }
}