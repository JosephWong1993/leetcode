package com.wong.Example;

import com.wong.Example.Example_00005_LongestPalindromicSubstring;
import org.junit.Before;
import org.junit.Test;

public class Example_00005_LongestPalindromicSubstringTest {
    private Example_00005_LongestPalindromicSubstring instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00005_LongestPalindromicSubstring();
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