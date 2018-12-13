package com.mojain.aircalc;

import java.util.Stack;

public class Evaluator {
    public void evaluate(Stack<Real> stack, Operator operator) {
        Real result;
        if (stack.size() < operator.arity()) {
            throw new InsufficientOperandsException(operator.tokenNumber(), String.format("%s", operator));
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
