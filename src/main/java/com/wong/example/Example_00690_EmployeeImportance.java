package com.wong.example;

import java.util.*;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

/**
 * 690. 员工的重要性
 * https://leetcode-cn.com/problems/employee-importance/
 */
public class Example_00690_EmployeeImportance {
    //region 方法一：深度优先搜索
    public int getImportance_1(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return dfs(map, id);
    }

    public int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        if (subordinates != null) {
            for (Integer subordinate : subordinates) {
                total += dfs(map, subordinate.intValue());
            }
        }
        return total;
    }
    //endregion

    /**
     * 方法二：广度优先搜索
     */
    public int getImportance_2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        int total = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            Employee employee = map.get(curId);
            total += employee.importance;
            List<Integer> subordinates = employee.subordinates;
            if(subordinates!=null){
                for (Integer subordinate : subordinates) {
                    queue.offer(subordinate);
                }
            }
        }
        return total;
    }
}
