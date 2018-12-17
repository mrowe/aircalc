package com.mojain.aircalc;

import com.mojain.aircalc.operators.Plus;
import com.mojain.aircalc.operators.SquareRoot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvaluatorTest {

    private Evaluator evaluator;
    private Stack stack;

    @Before
    public void setUp() {
        evaluator = new Evaluator();
        stack = new Stack();
        stack.push(new Real(1));
        stack.push(new Real(2));
    }

    @Test
    public void shouldEvaluateASimpleOperation() throws InsufficientOperandsException {
        evaluator.evaluate(stack, new Plus());
        assertEquals(new Real(3), stack.peek());
    }

    @Test
    public void unaryOperatorShouldConsumeAndReplaceOneElement() throws InsufficientOperandsException {
        evaluator.evaluate(stack, new SquareRoot());
        assertEquals(2, stack.size());
    }

    @Test
    public void binaryOperatorShouldConsumeTwoElementsAndReplaceResult() throws InsufficientOperandsException {
        evaluator.evaluate(stack, new Plus());
        assertEquals(1, stack.size());
    }

    @Test(expected = InsufficientOperandsException.class)
    public void shouldThrowExceptionWhenInsufficientOperands() throws InsufficientOperandsException {
        stack.pop();
        evaluator.evaluate(stack, new Plus());
    }

    @Test
    public void errorShouldNotConsumeOperand() {
        stack.pop();
        try {
            evaluator.evaluate(stack, new Plus());
        } catch (InsufficientOperandsException e) {
            // expected
        }
        assertEquals(1, stack.size());
    }
}