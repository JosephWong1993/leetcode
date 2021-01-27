package com.wong.example;

import java.util.*;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 */
public class Example_00380_InsertDeleteGetRandomO1 {
    //region 方法：哈希表 + 动态数组
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random random = new Random();

    /**
     * Initialize your data structure here.
     */
    public Example_00380_InsertDeleteGetRandomO1() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }

        int idx = dict.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    //endregion
}
