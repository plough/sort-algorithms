package com.plough.algorithms.lru;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by plough on 2022/8/5.
 */
public class LRU<K, V> implements Iterable<K> {
  private Node head;
  private Node tail;
  private Map<K, Node> map;
  private int capacity;

  public LRU(int capacity) {
    head = new Node(null, null);
    tail = new Node(null, null);
    head.next = tail;
    tail.pre = head;
    map = new HashMap<>();
    this.capacity = capacity;
  }

  public V get(K k) {
    if (!map.containsKey(k)) {
      return null;
    }
    Node node = map.get(k);
    unlink(node);
    appendToHead(node);
    return node.v;
  }

  public void put(K k, V v) {
    Node node;
    if (map.containsKey(k)) {
      node = map.get(k);
      unlink(node);
    } else {
      node = new Node(k, v);
      map.put(k, node);
    }
    appendToHead(node);
    if (map.size() > capacity) {
      removeTail();
    }
  }

  private void unlink(Node node) {
    Node pre = node.pre;
    pre.next = node.next;
    node.next.pre = pre;
  }

  private void appendToHead(Node node) {
    Node next = head.next;
    node.next = next;
    if (next != null) {
      next.pre = node;
    }
    head.next = node;
    node.pre = head;
  }

  private void removeTail() {
    Node pre = tail.pre.pre;
    pre.next = tail;
    tail.pre = pre;
  }

  @Override
  public Iterator<K> iterator() {
    return new Iterator<K>() {
      Node cur = head.next;
      @Override
      public boolean hasNext() {
        return cur != tail;
      }

      @Override
      public K next() {
        K res = cur.k;
        cur = cur.next;
        return res;
      } };
  }

  private class Node {
    K k;
    V v;
    Node pre;
    Node next;

    Node(K k, V v) {
      this.k = k;
      this.v = v;
    }
  }

  public static void main(String[] args) {
    LRU<String, Integer> lru = new LRU<>(3);
    lru.put("1", 1);
    lru.put("2", 2);
    lru.put("3", 3);
    lru.put("4", 4);
    lru.get("3");
    for (String k : lru) {
      System.out.println(k);
    }
  }
}
