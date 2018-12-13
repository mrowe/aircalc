package com.mojain.aircalc.commands;

import com.mojain.aircalc.*;

import java.util.Objects;

public class Push implements Command {
    private final Real number;

    public Push(Real number) {
        this.number = number;
    }

    @Override
    public State invoke(Stack stack) {
        stack.push(number);
        return State.RUNNING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Push push = (Push) o;
        return number.equals(push.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
