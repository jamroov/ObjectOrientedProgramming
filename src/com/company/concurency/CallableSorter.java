package com.company.concurency;

import java.util.List;
import java.util.concurrent.Callable;
/*
* TASK 10
Callable
Create a CallableSorter with List of numbers as a parameter and as returned object
BubbleSort lists in call() method
create 4 different sized lists with random numbers
sort them one by one and measure time
sort them in the same time and measure time
Catch sorted lists into Future objects
*
*
* */
public class CallableSorter implements Callable<List<Integer>> {
    private Integer tempVar;
    private List<Integer> privNumbers;

    public CallableSorter(List<Integer> numbers) {
        this.privNumbers = numbers;
    }
    @Override
    public List<Integer> call() throws Exception {
        return null;
    }
}
