package com.mojain.aircalc;

import com.mojain.aircalc.operators.Plus;
import com.mojain.aircalc.operators.SquareRoot;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class EvaluatorTest {

    private Evaluator evaluator;
    private Stack<Real> stack;

    @Before
    public void setUp() {
        evaluator = new Evaluator();
        stack = new Stack<>();
        stack.push(new Real(1));
        stack.push(new Real(2));
    }

    @Test
    public void shouldEvaluateASimpleOperation() throws InsufficientOperandsException {
        evaluator.evaluate(stack, new Plus(1));
        assertEquals(new Real(3), stack.peek());
    }

    @Test
    public void unaryOperatorShouldConsumeAndReplaceOneElement() throws InsufficientOperandsException {
        evaluator.evaluate(stack, new SquareRoot(1));
        assertEquals(2, stack.size());
    }

    @Test
    public void binaryOperatorShouldConsumeTwoElementsAndReplaceResult() throws InsufficientOperandsException {
        evaluator.evaluate(stack, new Plus(1));
        assertEquals(1, stack.size());
    }

    @Test
    public void shouldThrowExceptionWhenInsufficientOperands() throws InsufficientOperandsException {
        stack.pop();
        try {
            evaluator.evaluate(stack, new Plus(1));
            fail("Should throw InsufficientOperandsException");
        } catch (InsufficientOperandsException e) {
            assertEquals(1, e.tokenNumber);
        }
    }

    @Test
    public void errorShouldNotConsumeOperand() {
        stack.pop();
        try {
            evaluator.evaluate(stack, new Plus(1));
        } catch (InsufficientOperandsException e) {
            // expected
        }
        assertEquals(1, stack.size());
    }
}