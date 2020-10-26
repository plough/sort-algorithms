package com.plough.algorithms.sort;

import com.plough.algorithms.sort.utils.SortHelper;

/**
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class FastSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        fastSort(input, 0, input.length-1);
        return input;
    }

    private void fastSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(arr, l, r);
        fastSort(arr, l, pivot);
        fastSort(arr, pivot + 1, r);
    }

    private int partition(int[] arr, int l, int r) {
        // 定义：
        // arr[l+1, i] 都小于 v
        // arr[i+1, j] 都大于等于 v
        int v = arr[l];
        int i = l;
        for (int j = l+1; j <= r; j++) {
            if (arr[j] < v) {
                SortHelper.swap(arr, ++i, j);
            } else {
                // do nothing
            }
        }
        SortHelper.swap(arr, l, i);
        return i;
    }
}
