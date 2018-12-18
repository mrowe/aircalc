package com.mojain.aircalc.operators;

import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlusTest {

    private Operator operator;

    @Before
    public void setUp() {
        operator = new Plus(1);
    }

    @Test
    public void shouldEvaluateOperation() {
        assertEquals(new Real(3), operator.evaluate(new Real(2), new Real(1)));
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
        assertEquals(new Plus(1), new Plus(1));
    }
}