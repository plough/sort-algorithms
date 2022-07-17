package com.plough.leetcode100;

import org.junit.Test;

/**
 * Created by plough on 2022/7/16.
 */
public class L45_JumpGame {
  private int minSteps = Integer.MAX_VALUE;

  @Test
  public void should_jump() {
      int res = jump(new int[] {2, 3, 1, 1, 4});
    System.out.println(res);
  }


  public int jump(int[] nums) {
    dfs(nums, 0, 0);
    return minSteps;
  }

  private void dfs(int[] nums, int curIdx, int stepCount) {
    if (curIdx >= nums.length-1) {
      minSteps = Math.min(minSteps, stepCount);
      return;
    }
    if (stepCount >= minSteps) {
      return;
    }
    for (int i = 1; i <= nums[curIdx]; i++) {
      dfs(nums, curIdx+i, stepCount+1);
    }
  }

}
