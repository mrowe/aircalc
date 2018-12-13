package com.mojain.aircalc.commands;

import com.mojain.aircalc.Command;
import com.mojain.aircalc.Stack;
import com.mojain.aircalc.State;


public class Quit implements Command {
    @Override
    public State invoke(Stack stack) {
        return State.QUIT;
    }

    /**
     * All instances of Quit are effectively the same thing.
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Quit;
    }
}
