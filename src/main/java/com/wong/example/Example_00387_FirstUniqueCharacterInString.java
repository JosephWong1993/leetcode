package com.wong.example;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class Example_00387_FirstUniqueCharacterInString {
    /**
     * 方法一：使用哈希表存储频数
     */
    public int firstUniqChar_1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
