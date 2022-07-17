package com.plough.leetcode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Created by plough on 2022/7/16.
 */
public class L40_combination2 {

  @Test
  public void should_pass() {
    List<List<Integer>> res = combinationSum2(new int[]{1,6}, 7);
    System.out.println(res);
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<int[]> freqList = new ArrayList<>();
    for (int num : candidates) {
      if (freqList.isEmpty() || num != freqList.get(freqList.size()-1)[0]) {
        freqList.add(new int[] {num, 1});
      } else {
        freqList.get(freqList.size()-1)[1]++;
      }
    }

    List<List<Integer>> res = new ArrayList<>();
    dfs(res, new ArrayList<>(), freqList, 0, target);
    return res;
  }

  private void dfs(List<List<Integer>> res, List<Integer> curRes, List<int[]> freqList, int curIdx, int target) {
    if (target == 0) {
      res.add(new ArrayList<>(curRes));
      return;
    }
    if (curIdx == freqList.size()) {
      return;
    }
    int num = freqList.get(curIdx)[0];
    int mostTimes = Math.min(target / num, freqList.get(curIdx)[1]);
    for (int i = 0; i <= mostTimes; i++) {
      for (int j = 0; j < i; j++) {
        curRes.add(num);
      }
      dfs(res, curRes, freqList, curIdx+1, target-num*i);
      for (int j = 0; j < i; j++) {
        curRes.remove(curRes.size()-1);
      }
    }
  }
}
