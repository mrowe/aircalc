package com.mojain.aircalc.commands;

import com.mojain.aircalc.Evaluator;
import com.mojain.aircalc.Operator;
import com.mojain.aircalc.Real;
import com.mojain.aircalc.State;

import java.util.Stack;

public class Eval implements com.mojain.aircalc.Command {
    private final Operator operator;
    private final Evaluator evaluator;

    public Eval(Operator operator) {
        this.operator = operator;
        evaluator = new Evaluator();
    }

    @Override
    public State invoke(Stack<Real> stack) {
        evaluator.evaluate(stack, operator);
        return State.RUNNING;
    }
}
