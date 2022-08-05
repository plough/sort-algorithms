package com.plough.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by plough on 2022/8/4.
 */
public class ProducerConsumer {

  private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

  private static class Producer extends Thread {
    @Override
    public void run() {
      try {
        queue.put("product");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.print("produce..");
    }
  }

  private static class Consumer extends Thread {

    @Override
    public void run() {
      try {
        String product = queue.take();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.print("consume..");
    }
  }
}