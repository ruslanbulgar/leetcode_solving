package com.rbcode.solutions.java_features.functional_interface;

public class RunnableMain {
    public static void main(String[] args) {
        System.out.println("Main thread started: " + Thread.currentThread().getName());
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + ", starting run() method!");
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", finish run() method!");
        };

        new Thread(runnable).start();
        System.out.println("Main thread finished: " + Thread.currentThread().getName());
    }
}
