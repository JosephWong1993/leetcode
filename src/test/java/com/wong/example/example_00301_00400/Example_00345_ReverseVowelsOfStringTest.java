package com.wong.example.example_00301_00400;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(locations = "classpath:ApplicationContext.xml")
class Example_00345_ReverseVowelsOfStringTest {

    @Autowired
    private Example_00345_ReverseVowelsOfString instance;

    private final String testStr = "hello";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseVowels() {
        instance.reverseVowels(testStr);
    }
}