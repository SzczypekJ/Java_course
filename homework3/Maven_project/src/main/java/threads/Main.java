package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(stream.reflection.Main.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // using synchronized to show that this thread cannot be interrupted
        Printer.print();

        OwnThread ownThread = new OwnThread();
        Thread runnableThread = new Thread(new RunnableThread());
        ownThread.start();
        runnableThread.start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(ownThread);
        executorService.execute(runnableThread);

        Future<String> future = executorService.submit(new CallableThread());
        String result = future.get();
        LOGGER.info("Callable result: " + result);

        executorService.shutdown();

        // using synchronized to show that this thread cannot be interrupted
        Printer.print();

        ExecutorService newExecutorService = Executors.newFixedThreadPool(1);
        Future<String> newFuture = newExecutorService.submit(new CallableThread2());
        // testing future interface
        try {
            String newResult = newFuture.get();
            System.out.println(newResult);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            newExecutorService.shutdown();
        }
    }
}