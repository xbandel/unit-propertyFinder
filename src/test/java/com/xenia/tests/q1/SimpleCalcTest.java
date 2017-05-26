package com.xenia.tests.q1;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleCalcTest {

    private double op1 = 10d;
    private double op2 = 20d;

    private SimpleCalc simpleCalc;

    @Before
    public void setUp() throws Exception {
        simpleCalc = new SimpleCalc();
    }

    @Test
    public void addCommutativeIsTrue() throws Exception {
        assertThat(simpleCalc.add(op1, op2), is(simpleCalc.add(op2, op1)));
    }

    @Test
    public void addTwoValsGivesSum() throws Exception {
        assertThat(simpleCalc.add(op1, op2), is(op2 + op1));
    }

    @Test
    public void addTwoMaxGivesInfinity() throws Exception {
        assertThat(simpleCalc.add(Double.MAX_VALUE, Double.MAX_VALUE), is(Double.POSITIVE_INFINITY));
    }

    @Test
    public void addZeroGivesLeftOp() throws Exception {
        assertThat(simpleCalc.add(op1, 0d), is(op1));
    }

    @Test
    public void addToZeroGivesRightOp() throws Exception {
        assertThat(simpleCalc.add(0d, op1), is(op1));
    }

    @Test
    public void addPositiveAndNagativeGiveZero() throws Exception {
        assertThat(simpleCalc.add(-op1, op1), is(0d));
    }


    @Test
    public void subtractDevidentGtDeviderIsPositive() throws Exception {
        assertThat(simpleCalc.subtract(op1, op2), is(op1 - op2));
    }

    @Test
    public void subtractDevidentGtDeviderIsNegative() throws Exception {
        assertThat(simpleCalc.subtract(op2, op1), is(op2 - op1));
    }

    @Test
    public void subtractMaxNegativeGivesOverflow() throws Exception {
        assertThat(simpleCalc.subtract(Double.MAX_VALUE, -Double.MAX_VALUE), is(Double.POSITIVE_INFINITY));
    }


    @Test
    public void subtractFromZeroNegatesDivider() throws Exception {
        assertThat(simpleCalc.subtract(0d, op1), is(-op1));
    }

    @Test
    public void subtractZeroDontChangeDevident() throws Exception {
        assertThat(simpleCalc.subtract(op2, 0), is(op2));
    }

    @Test
    public void multiply() throws Exception {
        assertThat(simpleCalc.multiply(op2, op1), is(op2 * op1));
    }

    @Test
    public void multiplyCommutativeIsTrue() throws Exception {
        assertThat(simpleCalc.multiply(op2, op1), is(simpleCalc.multiply(op1, op2)));
    }

    @Test
    public void multiplyByZeroIsZero() throws Exception {
        assertThat(simpleCalc.multiply(op2, 0d), is(0d));
    }

    @Test
    public void multiplyZeroIsZero() throws Exception {
        assertThat(simpleCalc.multiply(0, op1), is(0d));
    }

    @Test
    public void multiplyNegativesIsPositive() throws Exception {
        assertThat(simpleCalc.multiply(-op1, -op2), is(op1 * op2));
    }

    @Test
    public void divide() throws Exception {
        assertThat(simpleCalc.divide(op2, op1), is(op2 / op1));
    }

    @Test
    public void divideByZeroGivesInfinity() throws Exception {
        assertThat(simpleCalc.divide(op2, 0), is(Double.POSITIVE_INFINITY));
    }

}