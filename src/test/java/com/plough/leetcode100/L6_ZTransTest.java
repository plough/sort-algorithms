package com.plough.leetcode100;

import org.junit.Test;

/**
 * Created by plough on 2022/7/11.
 */
public class L6_ZTransTest {

  @Test
  public void should_Convert() {
    String res = convert("A", 1);
    System.out.println(res);
  }

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }

    StringBuilder[] rows = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      rows[i] = new StringBuilder();
    }

    int circleLen = 2 * numRows - 2;
    for (int i = 0; i < s.length(); i++) {
      char curChar = s.charAt(i);

      int j = i % circleLen;
      if (j < numRows) {
        rows[j].append(curChar);
      } else {
        rows[circleLen - j].append(curChar);
      }
    }

    StringBuilder res = new StringBuilder();
    for (int i = 0; i < numRows; i++) {
      res.append(rows[i]);
    }
    return res.toString();
  }
}
