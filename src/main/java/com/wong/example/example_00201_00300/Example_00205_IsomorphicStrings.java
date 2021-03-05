package com.wong.example.example_00201_00300;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
public class Example_00205_IsomorphicStrings {
    /**
     * 方法一：哈希表
     */
    public boolean isIsomorphic(String s, String t) {
        if (s != t) {
            Map<Character, Character> s2t = new HashMap<>();
            Map<Character, Character> t2s = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                char y = t.charAt(i);
                if ((s2t.containsKey(s.charAt(i)) && s2t.get(x) != y) ||
                        (t2s.containsKey(t.charAt(i)) && t2s.get(y) != x)) {
                    return false;
                }
                s2t.put(x, y);
                t2s.put(y, x);
            }
        }
        return true;
    }
}
