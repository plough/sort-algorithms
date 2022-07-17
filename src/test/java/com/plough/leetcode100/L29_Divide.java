package com.plough.leetcode100;

import java.util.ArrayList;
import org.junit.Test;

/**
 * Created by plough on 2022/7/13.
 */
public class L29_Divide {
  @Test
  public void should_divide() {
    int res = divide(10, 3);
    System.out.println(res);
  }

  public int divide(int dividend, int divisor) {
    // 1. 判断结果的符号
    boolean isNegative = (((dividend >>> 31) ^ (divisor >>> 31)) == 1);
    // 2. 全部转换为负数，以简化逻辑
    if (dividend > 0) {
      dividend = -dividend;
    }
    if (divisor > 0) {
      divisor = -divisor;
    }
    // 3. 定义 mod 和 now，并初始化
    int mod = divisor;
    int now = -1;
    int minMod = dividend >> 1;
    while (mod >= minMod) {
      mod <<= 1;
      now <<= 1;
    }
    // 4. 计算结果
    int ans = 0;
    while (dividend <= divisor) {
      while (mod < dividend) {
        mod >>= 1;
        now >>= 1;
      }
      while (dividend <= mod) {
        dividend -= mod;
        ans += now;
      }
    }
    // 5. 边界检查
    if (ans == Integer.MIN_VALUE && !isNegative) {
      return Integer.MAX_VALUE;
    }
    // 6. 返回结果
    return isNegative ? ans : -ans;
  }

}
