package com.mojain.aircalc.commands;

import com.mojain.aircalc.Command;
import com.mojain.aircalc.State;

import java.util.Stack;

import static com.mojain.aircalc.State.RUNNING;

public class Clear implements Command {
    @Override
    public State invoke(Stack stack) {
        stack.clear();
        return RUNNING;
    }
}
