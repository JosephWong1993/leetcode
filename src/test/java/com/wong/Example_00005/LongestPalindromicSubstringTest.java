package com.wong.Example_00005;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new LongestPalindromicSubstring();
    }
    
    @Test
    public void longestPalindrome_1() {
        String ans = instance.longestPalindrome_1("babad");
        System.out.println(ans);
    }
    
    @Test
    public void longestPalindrome_2() {
        String ans = instance.longestPalindrome_2("babad");
        System.out.println(ans);
    }
}