package com.alok.addersubtractorlock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Value value;
    Lock lockForValue1;
    Lock lockForValue2;
    public Adder(Value value, Lock lockForValue1, Lock lockForValue2) {
        this.value = value;
        this.lockForValue1 = lockForValue1;
        this.lockForValue2 = lockForValue2;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            // sleeping to see the race condition
            try {
                Thread.sleep(5L);
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }

            // take lock
            lockForValue1.lock();
            int current = value.get1();
            int next = current + i;
            value.set1(next);
            lockForValue1.unlock();
        }
    }
}
