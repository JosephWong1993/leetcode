package com.wong.Example_00190;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {
    /**
     * 方法一：逐位颠倒
     */
    public int reverseBits_1(Integer n) {
        int ret = 0;
        int power = 31;
        while (n != 0) {
            ret += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        return ret;
    }
    
    /**
     * 方法二：带记忆化的按字节颠倒
     */
    public int reverseBits_2(Integer n) {
        int ret = 0;
        int power = 24;
        Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
        while (n != 0) {
            ret += reverseByte((n & 0xff), cache) << power;
            n = n >> 8;
            power -= 8;
        }
        return ret;
    }
    
    private Integer reverseByte(Integer byteParameter, Map<Integer, Integer> cache) {
        if (cache.containsKey(byteParameter)) {
            return cache.get(byteParameter);
        }
        Integer value = 0;
        Integer power = 7;
        Integer n = byteParameter;
        while (n != 0) {
            value += (n & 1) << power;
            n = n >> 1;
            power -= 1;
        }
        cache.put(byteParameter, value);
        return value;
    }
}
