package com.wong.Example;

import com.wong.Example.Example_00073_SetMatrixZeroes;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Example_00073_SetMatrixZeroesTest {
    
    private Example_00073_SetMatrixZeroes instance;
    
    @Before
    public void setUp() throws Exception {
        instance = new Example_00073_SetMatrixZeroes();
    }
    
    @Test
    public void setZeroes_1() {
        int[][] ary = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        instance.setZeroes_1(ary);
        for (int[] row : ary) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    @Test
    public void setZeroes_2() {
        int[][] ary = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        instance.setZeroes_2(ary);
        for (int[] row : ary) {
            System.out.println(Arrays.toString(row));
        }
    }
}