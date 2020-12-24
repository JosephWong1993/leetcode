package com.wong.example;

public class Test {
    public static void main(String[] args) {
        System.out.println(cutbar(5, 100, 1));
    }
    
    private static int cutbar(int m, int n, int current) {
        if (current >= n) {
            return 0;
        } else if (current < m) {
            return 1 + cutbar(m, n, 2 * current);
        } else {
            return 1 + cutbar(m, n, current + m);
        }
    }
    
    private static int cutbar(int m, int n) {
        int count = 0;
        int current = 1;
        while (n > current) {
            current += current < m ? current : m;
            count += 1;
        }
        return count;
    }
}
