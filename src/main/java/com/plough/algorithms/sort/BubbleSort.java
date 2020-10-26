package com.plough.algorithms.sort;

import com.plough.algorithms.sort.utils.SortHelper;

/**
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j+1] < input[j]) {
                    SortHelper.swap(input, j, j+1);
                }
            }
        }
        return input;
    }
}
