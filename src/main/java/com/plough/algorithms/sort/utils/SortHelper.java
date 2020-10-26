package com.plough.algorithms.sort.utils;

/**
 *
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class SortHelper {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
