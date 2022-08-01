package com.plough.algorithms.sort;

import com.plough.algorithms.sort.utils.SortHelper;

/**
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class FastSortThreePath implements Sort {
    @Override
    public int[] sort(int[] input) {
        fastSortThreePath(input, 0, input.length-1);
        return input;
    }

    private void fastSortThreePath(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        // partition
        int v = arr[low];
        // 定义：
        // arr[low+1, l] 都是 < v
        // arr[l, i] 都是 = v
        // arr[r, high] 都是 > v
        int l = low;
        int r = high + 1;
        for (int i = low + 1; i < r;) {
            if (arr[i] < v) {
                SortHelper.swap(arr, i++, ++l);
            } else if (arr[i] > v) {
                SortHelper.swap(arr, i, --r);
            } else {
                // do nothing
                i++;
            }
        }
        SortHelper.swap(arr, l, low);

        fastSortThreePath(arr, low, l-1);
        fastSortThreePath(arr, r, high);
    }
}
