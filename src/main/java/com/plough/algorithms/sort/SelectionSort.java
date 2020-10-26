package com.plough.algorithms.sort;

import com.plough.algorithms.sort.utils.SortHelper;

/**
 * 选择排序
 *
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class SelectionSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < input.length; j++) {
                if (input[j] < input[minIndex]) {
                    minIndex = j;
                }
            }
            SortHelper.swap(input, i, minIndex);
        }
        return input;
    }
}
