package com.alok.mergesortinmultithreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    Sorter(List<Integer> arrayToSort) {
        this.arrayToSort = arrayToSort;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(arrayToSort.size() < 2)
            return arrayToSort;

        int mid = arrayToSort.size() / 2;

        List<Integer> leftArray = new ArrayList<>();
        for(int i = 0; i < mid; i++)
            leftArray.add(arrayToSort.get(i));

        List<Integer> rightArray = new ArrayList<>();
        for (int i = mid; i < arrayToSort.size(); i++)
            rightArray.add(arrayToSort.get(i));

        Sorter leftArraySorter = new Sorter(leftArray);
        Sorter rightArraySorter = new Sorter(rightArray);

        ExecutorService executorService = Executors
                .newCachedThreadPool();

        Future<List<Integer>> sortedLeftArrayFuture = executorService.submit(leftArraySorter);
        Future<List<Integer>> sortedRightArrayFuture = executorService.submit(rightArraySorter);

        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get();
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();

        List<Integer> sortedArray = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < sortedLeftArray.size() && j < sortedRightArray.size()) {
            if(sortedLeftArray.get(i) < sortedRightArray.get(j)) {
                sortedArray.add(sortedLeftArray.get(i));
                i++;
            } else {
                sortedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        while(i < sortedLeftArray.size()) {
            sortedArray.add(sortedLeftArray.get(i));
            i++;
        }
        while (j < sortedRightArray.size()) {
            sortedArray.add(sortedRightArray.get(j));
            j++;
        }

        return sortedArray;
    }
}
