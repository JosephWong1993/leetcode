package com.wong.example;

import com.wong.example.example_00001_00100.Example_00017_LetterCombinationsOfPhoneNumber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class Example_00017_LetterCombinationsOfPhoneNumberTest {
    
    @Autowired
    private Example_00017_LetterCombinationsOfPhoneNumber instance;
    
    @Test
    public void letterCombinations() {
        List<String> list = instance.letterCombinations("23");
        System.out.println(list);
    }
}