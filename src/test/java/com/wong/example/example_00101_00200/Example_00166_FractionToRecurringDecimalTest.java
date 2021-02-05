package com.wong.example.example_00101_00200;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:ApplicationContext.xml")
class Example_00166_FractionToRecurringDecimalTest {
    
    @Autowired
    private Example_00166_FractionToRecurringDecimal instance;
    
    @Test
    void fractionToDecimal() {
        instance.fractionToDecimal(1, 2);
    }
}