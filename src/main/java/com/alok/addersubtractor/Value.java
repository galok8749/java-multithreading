package com.alok.addersubtractor;

public class Value {
    private int value = 0;

    public synchronized void add(int i) {
        value += i;
    }
    public synchronized void subtract(int i) {
        value -= i;
    }
    public int get() {
        return value;
    }
}
