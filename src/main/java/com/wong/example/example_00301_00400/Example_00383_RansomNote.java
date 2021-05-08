package com.wong.example.example_00301_00400;

import java.util.HashMap;
import java.util.Map;

public class Example_00383_RansomNote {
    /**
     * 方法：哈希表
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = map.get(c);
            if (count == null || count <= 0) {
                return false;
            }
            map.put(c, count - 1);
        }
        return true;
    }

    public boolean canConstruct_1(String ransomNote, String magazine) {
        int caps[] = new int[26];
        char[] chars = ransomNote.toCharArray();
        for (char c : chars) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1) {
                return false;
            }
            caps[c - 97] = index + 1;
        }
        return true;
    }
}
