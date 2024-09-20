package threads;

import java.util.concurrent.Callable;

public class CallableThread2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        synchronized (Printer.class) {
            Printer.print(); // Call the synchronized method
        }
        return "Printing completed by " + Thread.currentThread().getName();
    }
}
