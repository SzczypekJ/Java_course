package threads;

public class Printer {

    private static volatile boolean isPrinting = false;

    public synchronized static void print() {
        if (!isPrinting) {
            isPrinting = true;

            for (int i = 10; i >= 1; i--) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            isPrinting = false;
        } else {
            System.out.println(Thread.currentThread().getName() + " is waiting to print.");
        }
    }
}
