package com.solvd.threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread myThread = new MyThread();
        myThread.start();

        Thread myThreadRunnable = new Thread(new MyThreadRunnable());
        myThreadRunnable.start();

        Printer.print();

        Thread newThread = new Thread(() -> System.out.println("Hello from lambda"));
        newThread.start();

        Thread newThread2 = new Thread(() -> {
            for (int i=0; i<100; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        });
        newThread2.start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new MyThread());

        Future<Integer> a = executorService.submit(new CallThread());

        System.out.println(a.get());

    }
}
