package com.plough.leetcode100;

import static org.junit.Assert.assertTrue;

import java.util.Stack;
import org.junit.Test;

/**
 * Created by plough on 2022/7/11.
 */
public class L10_RegexTest {

  @Test
  public void should_pass() {
    boolean res = isMatch("bbbbab", ".*a*a");
    assertTrue(res);
  }

  public boolean isMatch(String s, String p) {
    return isMatchFrom(s, 0, p, 0);
  }

  // p = "xxxxa*b*c*"
  private boolean isMatchFrom(String s, int i, String p, int j) {
    if (i == s.length()) {
      if (j == p.length()) {
        return true;
      }
      if (j < p.length()-1 && p.charAt(j+1) == '*') {
        return isMatchFrom(s, i, p, j+2);
      }
      return false;
    }
    if (j == p.length()) {
      return false;
    }
    if (isEqual(s.charAt(i), p.charAt(j))) {
      // .*,a*
      if (j < p.length()-1 && p.charAt(j+1) == '*') {
        return isMatchFrom(s, i+1, p, j) || isMatchFrom(s, i+1, p, j+2) || isMatchFrom(s, i, p, j+2);
      }
      return isMatchFrom(s, i+1, p, j+1);
    }
    if (j < p.length()-1 && p.charAt(j+1) == '*') {
      return isMatchFrom(s, i, p, j+2);
    }
    return false;
  }

  private boolean isEqual(char a, char b) {
    return a == b || b == '.';
  }
}
