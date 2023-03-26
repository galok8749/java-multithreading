package com.alok.mergesortinmultithreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrToSort = List.of(
                10, 2, 8, 9, 11, 3, 17, 4
        );

        Sorter sorter = new Sorter(arrToSort);

        ExecutorService executorService = Executors
                .newCachedThreadPool();

        Future<List<Integer>> sortedArrayFuture = executorService.submit(sorter);

        List<Integer> sortedArray = sortedArrayFuture.get();

        System.out.println(sortedArray);
    }
}
