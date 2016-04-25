package com.chriszou.auttutorial.test.junit;

import com.chriszou.auttutorial.junit.Calculator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by xiaochuang on 4/12/16.
 */
public class CalculatorTest {
    Calculator mCalculator;

    @Before
    public void setup() {
        mCalculator = new Calculator();
    }

    @Test
    public void testAdd() throws Exception {
        int sum = mCalculator.add(1, 2);
        assertEquals(3, sum);
    }

    @Test
    public void testAdd2() throws Exception {
        int sum = mCalculator.add(3, 2);
        assertEquals(6, sum);
    }

    @Test
    public void testMultiply() throws Exception {
        int product = mCalculator.multiply(2, 4);
        assertEquals(8, product);
    }

    @Test
    @Ignore("not implemented yet")
    public void testFactorial() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void test() {
        mCalculator.divide(4, 0);
    }

}