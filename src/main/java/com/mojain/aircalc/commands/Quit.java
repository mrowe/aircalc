package com.mojain.aircalc.commands;

import com.mojain.aircalc.Command;
import com.mojain.aircalc.State;

import java.util.Stack;

public class Quit implements Command {
    @Override
    public State invoke(Stack stack) {
        return State.QUIT;
    }
}
