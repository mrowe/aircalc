package com.mojain.aircalc;

public interface Command {
    State invoke(Stack stack);
}
