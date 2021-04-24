package com.company.Sorting;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableSorter implements Callable<List<Integer>> {
    public Integer[] arr;
    public Integer[] sorted_arr;
    @Override
    public List<Integer> call() throws Exception {
        BubbleSort sort = new BubbleSort();
        this.sorted_arr = sort.bubbleSort(this.arr);
        return Arrays.asList(this.sorted_arr);
    }

    public CallableSorter(Integer[] arr) {
        this.arr = arr;
    }
}
