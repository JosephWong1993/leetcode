package com.wong.Example_00073;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SetMatrixZeroesTest {
    
    private SetMatrixZeroes setMatrixZeroes;
    
    @Before
    public void setUp() throws Exception {
        setMatrixZeroes = new SetMatrixZeroes();
    }
    
    @Test
    public void setZeroes_1() {
        int[][] ary = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setMatrixZeroes.setZeroes_1(ary);
        for (int[] row : ary) {
            System.out.println(Arrays.toString(row));
        }
    }
    
    @Test
    public void setZeroes_2() {
        int[][] ary = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setMatrixZeroes.setZeroes_2(ary);
        for (int[] row : ary) {
            System.out.println(Arrays.toString(row));
        }
    }
}