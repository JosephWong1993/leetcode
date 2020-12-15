package com.wong.Example;

import com.wong.Example.Example_00049_GroupAnagrams;
import org.junit.Before;
import org.junit.Test;

public class Example_00049_GroupAnagramsTest {
    private Example_00049_GroupAnagrams instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00049_GroupAnagrams();
    }
    
    @Test
    public void groupAnagrams_1() {
        System.out.println(instance.groupAnagrams_1(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
    
    @Test
    public void groupAnagrams_2() {
        System.out.println(instance.groupAnagrams_2(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}