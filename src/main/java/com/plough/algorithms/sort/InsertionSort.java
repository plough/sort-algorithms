package com.plough.algorithms.sort;

/**
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        for (int i = 1; i < input.length; i++) {
            int val = input[i];
            int j = i-1;
            while (j >= 0 && input[j] > val) {
                input[j+1] = input[j];
                j--;
            }
            input[j+1] = val;
        }
        return input;
    }
}
