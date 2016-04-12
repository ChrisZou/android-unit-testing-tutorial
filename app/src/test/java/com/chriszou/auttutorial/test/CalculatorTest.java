package com.chriszou.auttutorial.test;

import com.chriszou.auttutorial.Calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiaochuang on 4/12/16.
 */
public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1, 2);
        Assert.assertEquals(3, sum);
    }

}