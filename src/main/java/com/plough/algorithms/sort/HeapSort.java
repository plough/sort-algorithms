package com.plough.algorithms.sort;

import com.plough.algorithms.sort.utils.SortHelper;

/**
 * Created by plough on 2021/5/20.
 */
public class HeapSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        // 1. 构造一个下标从 0 开始的大顶堆
        int N = input.length;
        for (int k = (N-2)/2; k >= 0; k--) {
            sink(input, k, N);
        }

        // 2. 排序
        while (N > 0) {
            SortHelper.swap(input, 0, --N);
            sink(input, 0, N);
        }
        return input;
    }

    private void sink(int[] arr, int k, int N) {
        while (k*2+1 < N) {
            int j = k*2+1;
            if (j+1 < N && arr[j+1] > arr[j]) {
                j = j+1;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            SortHelper.swap(arr, k, j);
            k = j;
        }
    }
}
