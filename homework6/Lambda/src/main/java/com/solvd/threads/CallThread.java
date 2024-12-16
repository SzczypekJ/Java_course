package com.solvd.threads;

import java.util.concurrent.Callable;

public class CallThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 10;
    }
}
