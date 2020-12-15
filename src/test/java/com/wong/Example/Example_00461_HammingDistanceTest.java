package com.wong.Example;

import com.wong.Example.Example_00461_HammingDistance;
import junit.framework.TestCase;

public class Example_00461_HammingDistanceTest extends TestCase {
    private Example_00461_HammingDistance instance;
    
    public void setUp() throws Exception {
        instance = new Example_00461_HammingDistance();
        super.setUp();
    }
    
    /**
     * 方法一：内置位计数功能
     */
    public void testHammingDistance_1() {
        System.out.println(instance.hammingDistance_1(1, 4));
    }
    
    /**
     * 方法二：移位
     */
    public void testHammingDistance_2() {
        System.out.println(instance.hammingDistance_2(1, 4));
    }
    
    /**
     * 方法三：布赖恩·克尼根算法
     */
    public void testHammingDistance_3() {
        System.out.println(instance.hammingDistance_3(1, 4));
    }
}