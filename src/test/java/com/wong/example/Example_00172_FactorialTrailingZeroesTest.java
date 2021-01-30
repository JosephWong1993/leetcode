package com.wong.example;

import com.wong.example.example_00101_00200.Example_00172_FactorialTrailingZeroes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class Example_00172_FactorialTrailingZeroesTest {

    @Autowired
    private Example_00172_FactorialTrailingZeroes service;

    @Test
    public void trailingZeroes() {
        service.trailingZeroes(0);
    }
}