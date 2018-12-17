package com.mojain.aircalc;

public class Stack {

    private final java.util.Stack<java.util.Stack<Real>> stacks;

    public Stack() {
        stacks = new java.util.Stack<>();
        stacks.push(new java.util.Stack<>());
    }

    private java.util.Stack<Real> currentStack() {
        return stacks.peek();
    }

    public void clear() {
        currentStack().clear();
    }

    public int size() {
        return currentStack().size();
    }

    public Real peek() {
        return currentStack().peek();
    }

    public String toString() {
        return currentStack().toString().replaceAll("[\\[\\],]", "");
    }

    public Real pop() {
        return currentStack().pop();
    }

    public void push(Real item) {
        currentStack().push(item);
    }

    public void undo() {
        // can't undo past first version
        if (stacks.size() > 1) {
            stacks.pop();
        } else {
            currentStack().clear();
        }
    }

    public void checkpoint() {
        java.util.Stack<Real> newStack = (java.util.Stack<Real>) currentStack().clone();
        stacks.push(newStack);
    }
}
