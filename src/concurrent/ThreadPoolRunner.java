package concurrent;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ThreadPoolRunner {

    public static void main(String[] args) {
        FixedThreadPool tp = new FixedThreadPool(3);
        tp.execute(() -> {
            System.out.println("TASK");
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tp.execute(() -> {
            System.out.println("TASK2");
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tp.execute(() -> {
            System.out.println("TASK3");
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        tp.execute(() -> {
            System.out.println("TASK4");
            System.out.println(Thread.currentThread().getName());
        });
        tp.shutdown();

    }
}

class FixedThreadPool {
    private class WorkerThread extends Thread {
        @Override
        public void run() {
            Runnable task;
            synchronized (taskQueue){
                while (true){
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = taskQueue.poll();
                    task.run();
                }
            }
        }
    }

    private final int size;
    private final LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private final WorkerThread[] workerThreads;
    FixedThreadPool(int size) {
        this.size = size;
        workerThreads = new WorkerThread[size];
        for (int i = 0; i<size; i++){
            workerThreads[i] = new WorkerThread();
            workerThreads[i].start();
        }
    }

    void execute(Runnable runnable) {
        synchronized (taskQueue) {
            taskQueue.offer(runnable);
            taskQueue.notify();
        }
    }

    void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < size; i++) {
            workerThreads[i] = null;
        }
    }

}
