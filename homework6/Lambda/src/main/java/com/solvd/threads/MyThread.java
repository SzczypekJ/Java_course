package com.solvd.threads;

public class MyThread extends Thread{

    @Override
    public void run() {
        Printer.print();
    }
}
