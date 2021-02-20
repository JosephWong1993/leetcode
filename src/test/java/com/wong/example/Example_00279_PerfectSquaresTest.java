package com.wong.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:ApplicationContext.xml")
class Example_00279_PerfectSquaresTest {
    
    @Autowired
    private Example_00279_PerfectSquares instance;
    
    @Test
    void numSquares() {
        System.out.println(instance.numSquares_1(12));
    }
}