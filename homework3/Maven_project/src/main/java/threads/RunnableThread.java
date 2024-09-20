package threads;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Task2 (RunnableThread) - Thread: " + Thread.currentThread().getName() + " is running. Iteration: " + i);
        }
    }
}
