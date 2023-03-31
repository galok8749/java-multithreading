package com.alok.addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable {
    Value value;
    Lock lockForValue;
    public Subtractor(Value value, Lock lockForValue) {
        this.value = value;
        this.lockForValue = lockForValue;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(5L);
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
            // get the lock
            lockForValue.lock();
            int current = value.get();
            int next = current - i;
            value.set(next);
            lockForValue.unlock();
        }
    }
}
