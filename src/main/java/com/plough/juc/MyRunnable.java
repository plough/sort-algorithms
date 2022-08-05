package com.plough.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by plough on 2022/8/1.
 */
public class MyRunnable implements Runnable {

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      Thread t = Thread.currentThread();
      System.out.println(t.getId() + ": " + i);
    }
  }

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    executorService.execute(new MyRunnable());
    executorService.execute(new MyRunnable());
    executorService.execute(new MyRunnable());
    executorService.shutdown();
  }
}
