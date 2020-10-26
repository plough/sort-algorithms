package com.plough.algorithms.sort;

/**
 * TODO
 *
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class MergeSortBU implements Sort {
    @Override
    public int[] sort(int[] input) {
        for (int size = 1; size < input.length; size += size) {
            for (int i = 0; i + size < input.length; i += 2*size) {
                int m = i + size - 1;
                merge(input, i, m, Math.min(i+2*size-1, input.length-1));
            }
        }
        return input;
    }

    private void merge(int[] arr, int l, int m, int r) {
        System.out.println(String.format("l: %s, m: %s, r: %s, len: %s", l, m, r, r-l+1));
        int[] tmp = new int[r-l+1];
        int k = 0;
        int i = l;
        int j = m+1;
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
