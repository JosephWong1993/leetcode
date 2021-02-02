package com.wong.example.example_00001_00100;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml"})
public class Example_00050_PowTest {

    @Autowired
    private Example_00050_Pow service;

    @Test
    public void myPow_2() {
        double answer = service.myPow_2(2.00000, 10);
        System.out.println(answer);
    }
}