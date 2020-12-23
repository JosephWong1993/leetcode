package com.wong.example.example_00001_00100;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class Example_00003_LongestSubstringWithoutRepeatingCharacters {
    /**
     * 方法一：滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        Set<Character> occ = new HashSet<>();
        int rk = -1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk < n - 1 && !occ.contains(s.charAt(rk + 1))) {
                occ.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}