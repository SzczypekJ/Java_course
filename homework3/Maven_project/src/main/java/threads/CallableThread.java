package threads;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("Task3 (CallableThread) - Thread: " + Thread.currentThread().getName() + " is running. Iteration: " + i);
        }
        return "Task3 Completed";
    }
}
