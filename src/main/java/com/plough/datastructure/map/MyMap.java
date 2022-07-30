package com.plough.datastructure.map;

/**
 * Created by plough on 2022/7/30.
 */
public interface MyMap<K, V> {
  int size();
  void put(K key, V val);
  V get(K key);
  void remove(K key);
  boolean containsKey(K key);
  boolean containsValue(V val);

  interface Entry<K, V> {
    K getKey();
    V getValue();
    void setValue(V val);
    int hashCode();
  }
}
