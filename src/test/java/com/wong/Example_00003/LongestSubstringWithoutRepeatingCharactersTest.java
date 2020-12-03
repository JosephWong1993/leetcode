package com.wong.Example_00003;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new LongestSubstringWithoutRepeatingCharacters();
    }
    
    @Test
    public void lengthOfLongestSubstring() {
        int length = instance.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}