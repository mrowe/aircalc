package com.mojain.aircalc;

import com.mojain.aircalc.operators.SquareRoot;

import java.util.EmptyStackException;
import java.util.Stack;

public class Evaluator {
    public void evaluate(Stack<Real> stack, Operator operator) throws InsufficientOperandsException {
        Real result;
        if (stack.size() < operator.arity()) {
            throw new InsufficientOperandsException(String.format("%s", operator));
        }
        switch (operator.arity()) {
            case 1:
                result = operator.evaluate(stack.pop());
                break;
            case 2:
                result = operator.evaluate(stack.pop(), stack.pop());
                break;
            default:
                throw new RuntimeException(String.format("Unexpected operator: %s", operator));
        }
        stack.push(result);
    }
}
