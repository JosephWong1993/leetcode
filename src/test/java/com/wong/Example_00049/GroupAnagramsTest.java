package com.wong.Example_00049;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupAnagramsTest {
    private GroupAnagrams groupAnagrams;
    
    @Before
    public void setUp() throws Exception {
        groupAnagrams = new GroupAnagrams();
    }
    
    @Test
    public void groupAnagrams_1() {
        System.out.println(groupAnagrams.groupAnagrams_1(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
    
    @Test
    public void groupAnagrams_2() {
        System.out.println(groupAnagrams.groupAnagrams_2(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}