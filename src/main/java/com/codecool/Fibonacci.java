package com.codecool;

import java.util.function.Supplier;

public class Fibonacci implements Supplier<Integer> {

    private int previous = 0;
    private int current = 1;
    private int next;

    @Override
    public Integer get() {
        next = previous+current;
        int temp = previous;
        previous = current;
        current = next;
        return temp;
    }
}
