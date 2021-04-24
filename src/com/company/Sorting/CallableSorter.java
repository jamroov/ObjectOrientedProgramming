package com.company.Sorting;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableSorter implements Callable<List<Integer>> {
    public Integer[] arr;
    public Integer[] sorted_arr;
    @Override
    public List<Integer> call() throws Exception {
        Long start = System.currentTimeMillis();
        Long finish;
        try {
            start = System.currentTimeMillis();
            BubbleSort sort = new BubbleSort();
            this.sorted_arr = sort.bubbleSort(this.arr);
        }
        finally {
            finish = System.currentTimeMillis();
            System.out.printf("Bubble took: %d milliseconds\n", finish - start);
        }
        return Arrays.asList(this.sorted_arr);
    }

    public CallableSorter(Integer[] arr) {
        this.arr = arr;
    }
}
