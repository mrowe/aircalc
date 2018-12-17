package com.mojain.aircalc.commands;

import com.mojain.aircalc.Command;
import com.mojain.aircalc.Stack;
import com.mojain.aircalc.State;

import static com.mojain.aircalc.State.RUNNING;

public class Clear implements Command {
    @Override
    public State invoke(Stack stack) {
        stack.checkpoint();
        stack.clear();
        return RUNNING;
    }

    /**
     * All instances of Clear are effectively the same thing.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Clear;
    }
}
