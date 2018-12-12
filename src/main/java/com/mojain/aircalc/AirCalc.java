package com.mojain.aircalc;

import java.util.Scanner;
import java.util.Stack;

public class AirCalc {

    public static void main(String[] args) {
        System.out.println("Hello!");

        Stack<Real> stack = new Stack<>();
        Parser parser = new Parser();
        Scanner in = new Scanner(System.in);

        State state = State.RUNNING;
        while ((state == State.RUNNING && in.hasNext())) {
            for (Command command : parser.parse(in.nextLine())) {
                try {
                    state = command.invoke(stack);
                } catch (InsufficientOperandsException e) {
                    System.err.format("operator %s (position: %d): insufficient parameters\n", e.getMessage(), 0);
                }
            }
            System.out.println(stack.toString());
        }
    }
}
