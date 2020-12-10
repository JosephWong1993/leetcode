package com.wong.Example;

import com.wong.Example.Example_00013_RomanToInteger;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00013_RomanToIntegerTest extends TestCase {
    @Autowired
    private Example_00013_RomanToInteger instance;
    
    @Test
    public void testRomanToInt() {
        System.out.println(instance.romanToInt("III"));
    }
}