package com.solvd.threads;

public class MyThreadRunnable implements Runnable{
    @Override
    public void run() {
        Printer.print();
    }
}
