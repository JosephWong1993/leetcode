package com.wong.example.example_00201_00300;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * https://leetcode-cn.com/problems/word-pattern/
 */
public class Example_00290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        int length = s.length();
        int j = 0;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (j > length) {
                return false;
            }
            int endIndex = j;
            while (endIndex < length && s.charAt(endIndex) != ' ') {
                endIndex++;
            }
            String tmp = s.substring(j, endIndex);

            if (patternMap.containsKey(c) && !patternMap.get(c).equals(tmp)) {
                return false;
            }
            if (sMap.containsKey(tmp) && sMap.get(tmp) != c) {
                return false;
            }
            patternMap.put(c, tmp);
            sMap.put(tmp, c);
            j = endIndex + 1;
        }
        return j > length;
    }
}