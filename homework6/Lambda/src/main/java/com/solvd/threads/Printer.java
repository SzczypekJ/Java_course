package com.solvd.threads;

public class Printer {
    public synchronized static void  print() {
        for (int i=0; i<100; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
