package concurrent;


import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumberSequentially {
    public static void main(String... args) {
        AtomicInteger num = new AtomicInteger(1);
        int max = 100;
        Object lock = new Object();
        Thread t1 = new Thread(new Odd(num, lock, max));
        Thread t2 = new Thread(new Even(num, lock, max));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Odd implements Runnable {

        AtomicInteger num;
        private Object lock;
        private int max;

        public Odd(AtomicInteger num, Object lock, int max) {
            this.num = num;
            this.lock = lock;
            this.max = max;

        }

        @Override
        public void run() {
            synchronized (lock){
                while(num.get()<max){
                    if(num.get() % 2 != 0){
                        try {
                            synchronized (num){
                                System.out.println("T1: " + num);
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        synchronized (num){
                            num.incrementAndGet();
                        }
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    private static class Even implements Runnable {

        AtomicInteger num;
        private Object lock;
        private int max;

        public Even(AtomicInteger num, Object lock, int max) {
            this.num = num;
            this.lock = lock;
            this.max = max;
        }

        @Override
        public void run() {
            synchronized (lock){
            while(num.get()<max){
                    if(num.get()%2 == 0){
                        try {
                            synchronized (num){
                                System.out.println("T2: " + num);
                            }
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    else {
                        synchronized (num){
                            num.incrementAndGet();
                        }
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
