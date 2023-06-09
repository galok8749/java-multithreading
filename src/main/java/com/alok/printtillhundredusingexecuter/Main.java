package com.alok.printtillhundredusingexecuter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors
                .newFixedThreadPool(10);

        for (int i = 1; i <= 100; i++) {
            if(i == 80) {
                System.out.println("STOP");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.execute(numberPrinter);
        }

        executorService.shutdown();
    }
}
