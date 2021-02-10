package com.wong.example;

import java.util.*;

/**
 * 621. 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 */
public class Example_00621_TaskScheduler {
    /**
     * 方法一：模拟
     */
    public int leastInterval_1(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>(); //<任务名称,任务需要执行的次数>
        for (Character ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int m = freq.size();    //任务总数
        List<Integer> nextValid = new ArrayList<>();    //第i个任务，因其冷却限制，最早可以执行的时间
        List<Integer> rest = new ArrayList<>(); //第i个任务，剩余执行次数
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; ++i) {
            ++time;

            //获取最早可以执行任务的时间
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }

            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < m; ++j) {
                if (rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if (best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }

    //TODO:方法二：构造
}
