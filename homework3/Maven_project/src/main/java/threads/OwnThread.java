package threads;

public class OwnThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Task1 (OwnThread) - Thread: " + Thread.currentThread().getName() + " is running. Iteration: " + i);
        }
    }
}
