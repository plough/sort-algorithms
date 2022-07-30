package com.plough.datastructure.map;

import com.google.common.annotations.VisibleForTesting;
import java.util.Objects;

/**
 * Created by plough on 2022/7/30.
 */
public class MyHashMap<K, V> implements MyMap<K, V> {
  private static final int INIT_CAPACITY = 16;
  private static final double LOAD_FACTOR = 0.75;
  private int size = 0;
  private int capacity;
  private int threshold;
  private Node<K, V>[] table;

  private static int hash(Object o) {
    return Objects.hash(o);
  }

  public MyHashMap() {
    resize();
  }

  @VisibleForTesting
  int getCapacity() {
    return capacity;
  }

  @SuppressWarnings({"unchecked"})
  private void resize() {
    if (table == null) {
      capacity = INIT_CAPACITY;
      table = new Node[capacity];
      threshold = (int) (capacity * LOAD_FACTOR);
      return;
    }
    int newCap = capacity * 2;
    Node<K, V>[] newTable = new Node[newCap];
    for (Node<K, V> head : table) {
      while (head != null) {
        Node<K, V> next = head.next;
        int newIdx = head.hashCode() % newCap;
        head.next = newTable[newIdx];
        newTable[newIdx] = head;
        head = next;
      }
    }

    table = newTable;
    capacity = newCap;
    threshold = (int) (capacity * LOAD_FACTOR);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void put(K key, V val) {
    Node<K, V> node = findNode(key);
    if (node != null) {
      node.setValue(val);
      return;
    }
    int idx = getIndex(key);
    table[idx] = new Node<>(key, val, table[idx]);
    size++;
    if (size > threshold) {
      resize();
    }
  }

  private Node<K, V> findNode(K key) {
    int idx = getIndex(key);
    Node<K, V> node = table[idx];
    while (node != null) {
      if (Objects.equals(node.getKey(), key)) {
        return node;
      }
      node = node.next;
    }
    return null;
  }

  @Override
  public V get(K key) {
    Node<K, V> node = findNode(key);
    return node == null ? null : node.getValue();
  }

  @Override
  public void remove(K key) {
    int idx = getIndex(key);
    table[idx] = removeFromList(table[idx], key);
  }

  private Node<K, V> removeFromList(Node<K, V> head, K key) {
    Node<K, V> dummyHead = new Node<>(null, null, head);
    Node<K, V> pre = dummyHead;
    Node<K, V> cur = head;
    while (cur != null) {
      if (Objects.equals(cur.getKey(), key)) {
        pre.next = cur.next;
        size--;
        return dummyHead.next;
      }
      pre = cur;
      cur = cur.next;
    }
    return dummyHead.next;
  }

  @Override
  public boolean containsKey(K key) {
    return findNode(key) != null;
  }

  @Override
  public boolean containsValue(V val) {
    for (Node<K, V> head : table) {
      while (head != null) {
        if (Objects.equals(head.getValue(), val)) {
          return true;
        }
        head = head.next;
      }
    }
    return false;
  }

  private int getIndex(K key) {
    int hashCode = hash(key);
    return hashCode % table.length;
  }

  static class Node<K, V> implements MyMap.Entry<K, V> {
    private K key;
    private V val;
    private int hashCode;
    Node<K, V> next;

    Node(K key, V val, Node<K, V> next) {
      this.key = key;
      this.val = val;
      this.next = next;
      hashCode = hash(key);
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return val;
    }

    @Override
    public void setValue(V val) {
      this.val = val;
    }

    @Override
    public int hashCode() {
      return hashCode;
    }
  }
}
