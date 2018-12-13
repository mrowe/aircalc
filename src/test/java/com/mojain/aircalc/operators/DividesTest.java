package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DividesTest {

    private Operator operator;

    @Before
    public void setUp() {
        operator = new Divides(1);
    }

    @Test
    public void shouldEvaluateOperation() {
        assertEquals(new Real(0.333333333333333), operator.evaluate(new Real(3), new Real(1)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenOneOperand() {
        operator.evaluate(new Real(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNoOperand() {
        operator.evaluate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenAdditionalOperands() {
        assertEquals(new Real(1), operator.evaluate(new Real(1), new Real(1), new Real(1)));
    }

    @Test
    public void equals() {
        assertEquals(new Divides(1), new Divides(1));
    }
}