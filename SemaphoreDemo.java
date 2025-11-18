package com.javastack.datastructures.test;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    // Suppose there are 3 permits: max 3 threads can use resource at once
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for(int i = 1; i <= 6; i++) {
            Thread t = new Thread(new Worker(i));
            t.start();
        }
    }

    static class Worker implements Runnable {
        int id;
        public Worker(int id) { this.id = id; }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + id + " wants to acquire permit");
                semaphore.acquire();
                System.out.println("Thread " + id + " got permit, doing work");
                // simulate work
                Thread.sleep(2000);
                System.out.println("Thread " + id + " releasing permit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }
    }
}
