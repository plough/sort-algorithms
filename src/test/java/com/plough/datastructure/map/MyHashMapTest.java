package com.plough.datastructure.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Created by plough on 2022/7/30.
 */
public class MyHashMapTest {

  @Test
  public void should_work() {
    MyMap<Integer, Integer> m = new MyHashMap<>();
    m.put(1, 1001);
    m.put(2, 1002);
    m.put(1, 1003);
    m.put(3, 1004);
    m.remove(3);
    assertEquals(2, m.size());
    assertEquals(1002, (int)m.get(2));
    assertEquals(1003, (int)m.get(1));
    assertTrue(m.containsKey(1));
    assertTrue(m.containsValue(1003));
    assertFalse(m.containsKey(3));
    assertFalse(m.containsValue(1004));
  }

  @Test
  public void should_resize() {
    MyHashMap<Integer, Integer> m = new MyHashMap<>();
    for (int i = 0; i < 50; i++) {
      m.put(i, i+1000);
    }
    assertEquals(128, m.getCapacity());

    for (int i = 50; i < 100; i++) {
      m.put(i, i+1000);
    }
    assertEquals(256, m.getCapacity());
  }
}
