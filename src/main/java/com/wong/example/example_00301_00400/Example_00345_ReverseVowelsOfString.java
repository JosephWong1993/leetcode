package com.wong.example.example_00301_00400;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 */
@Component
public class Example_00345_ReverseVowelsOfString {
    private final static Set<Character> set;

    static {
        set = new HashSet<>();
        Character[] characters = new Character[]{'a', 'o', 'e', 'i', 'u', 'A', 'O', 'E', 'I', 'U'};
        set.addAll(Arrays.asList(characters));
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (left < right && !set.contains(chars[left])) {
                left++;
            }
            while (left < right && !set.contains(chars[right])) {
                right--;
            }

            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;

            left++;
            right--;
        }
        return new String(chars);
    }
}
