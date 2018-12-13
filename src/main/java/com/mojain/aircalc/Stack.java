package com.mojain.aircalc;

public class Stack {

    private final java.util.Stack<Real> stack;

    public Stack() {
        stack = new java.util.Stack<>();
    }

    public void clear() {
        stack.clear();
    }

    public int size() {
        return stack.size();
    }

    public Real pop() {
        return stack.pop();
    }

    public void push(Real item) {
        stack.push(item);
    }

    public Real peek() {
        return stack.peek();
    }

    public String toString() {
        return stack.toString().replaceAll("[\\[\\],]", "");
    }
}
