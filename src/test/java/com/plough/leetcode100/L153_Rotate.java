package com.plough.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * Created by plough on 2022/7/19.
 */
public class L153_Rotate {

  @Test
  public void should_pass() {
    int res = findMin(new int[] {3, 1, 2});
    System.out.println(res);
    List<Integer> l = new ArrayList<>();
    l.toArray(new Integer[0]);
    l.stream().max(Comparator.comparingInt(o -> o)).get();
    Deque<Integer> dq = new LinkedList<>();
    dq.peekFirst();
    Map<Integer, Integer> m = new HashMap<>();
  }

  public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + (r-l)/2;
      if (nums[mid] < nums[r]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return nums[l];
  }
}
