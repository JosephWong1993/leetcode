package com.wong.Example;

import com.wong.Example.Example_00003_LongestSubstringWithoutRepeatingCharacters;
import org.junit.Before;
import org.junit.Test;

public class Example_00003_LongestSubstringWithoutRepeatingCharactersTest {
    private Example_00003_LongestSubstringWithoutRepeatingCharacters instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00003_LongestSubstringWithoutRepeatingCharacters();
    }
    
    @Test
    public void lengthOfLongestSubstring() {
        int length = instance.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);
    }
}