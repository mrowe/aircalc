package com.mojain.aircalc.commands;

import com.mojain.aircalc.Command;
import com.mojain.aircalc.Stack;
import com.mojain.aircalc.State;

import static com.mojain.aircalc.State.RUNNING;

public class Undo implements Command {
    @Override
    public State invoke(Stack stack) {
        stack.undo();
        return RUNNING;
    }

    /**
     * All instances of Undo are effectively the same thing.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Undo;
    }
}
