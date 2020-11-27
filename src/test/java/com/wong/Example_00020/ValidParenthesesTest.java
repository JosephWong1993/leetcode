package com.wong.Example_00020;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesesTest {
    private ValidParentheses validParentheses;
    
    @Before
    public void setUp() throws Exception {
        validParentheses = new ValidParentheses();
    }
    
    @Test
    public void isValid() {
        System.out.println(validParentheses.isValid("()"));
    }
}