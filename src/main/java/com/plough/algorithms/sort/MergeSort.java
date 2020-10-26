package com.plough.algorithms.sort;

/**
 * TODO
 *
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class MergeSort implements Sort {
    @Override
    public int[] sort(int[] input) {
        mergeSort(input, 0, input.length-1);
        return input;
    }

    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = l + (r-l) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    /**
     * 对 arr[l, m] 和 arr[m+1, r] 进行归并
     */
    private void merge(int[] arr, int l, int m, int r) {
        int[] tmp = new int[r-l+1];
        int k=0, i=l, j=m+1;
        while (i <= m || j <= r) {
            if (i > m) {
                tmp[k++] = arr[j++];
                continue;
            }
            if (j > r) {
                tmp[k++] = arr[i++];
                continue;
            }
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        System.arraycopy(tmp, 0, arr, l, r-l+1);
    }
}
