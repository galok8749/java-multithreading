package com.alok.addersubtractoratomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Value {
    private AtomicInteger atomicValue = new AtomicInteger(0);
    public void add(int i) {
        atomicValue.addAndGet(i);
    }
    public void subtract(int i) {
        atomicValue.addAndGet(-i);
    }
    public int get() {
        return atomicValue.get();
    }
    public void set(int x) {
        atomicValue.set(x);
    }
    public void add1() {
        atomicValue.incrementAndGet();
    }
    public void subtract1() {
        atomicValue.decrementAndGet();
    }
}
