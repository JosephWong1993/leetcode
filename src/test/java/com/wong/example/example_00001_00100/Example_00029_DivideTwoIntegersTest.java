package com.wong.example.example_00001_00100;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00029_DivideTwoIntegersTest {

    @Autowired
    private Example_00029_DivideTwoIntegers instance;

    @Test
    public void divide() {
        instance.divide(7, -3);
    }
}