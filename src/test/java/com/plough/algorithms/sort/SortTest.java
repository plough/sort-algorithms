package com.plough.algorithms.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author zgtian
 * @version 1.0
 * @date 2020/10/26
 **/
public class SortTest {
    private static final int[] INPUT = new int[] {5, 2, 1, 56, 3, 11};
    private static final int[] OUTPUT = new int[] {1, 2, 3, 5, 11, 56};

    @Test
    public void testSimpleSort() {
        doSortTest(new SelectionSort());
        doSortTest(new InsertionSort());
        doSortTest(new BubbleSort());
    }

//    @Test
//    public void testSeniorSort() {
//
//    }

    private void doSortTest(Sort sort) {
        int[] res = sort.sort(Arrays.copyOf(INPUT, INPUT.length));
        assertArrayEquals(OUTPUT, res);
    }
}
