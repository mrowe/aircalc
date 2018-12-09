package com.mojain.aircalc.commands;

import com.mojain.aircalc.Command;
import com.mojain.aircalc.Real;
import com.mojain.aircalc.State;

import java.util.Stack;

public class Push implements Command {
    private final Real number;

    public Push(Real number) {
        this.number = number;
    }

    @Override
    public State invoke(Stack<Real> stack) {
        stack.push(number);
        return State.RUNNING;
    }
}
