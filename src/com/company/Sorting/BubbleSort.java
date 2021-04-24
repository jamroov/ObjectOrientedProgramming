package com.company.Sorting;

public class BubbleSort {
    public Integer[] bubbleSort(Integer[] arr)
    {
        Integer[] sorted_arr = new Integer[arr.length];
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.arraycopy(arr, 0, sorted_arr, 0, arr.length);
        return sorted_arr;
    }

    public void printArr(Integer[] arr)
    {
        for (Integer i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
