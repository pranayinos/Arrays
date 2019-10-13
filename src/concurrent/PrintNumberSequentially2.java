package concurrent;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumberSequentially2 {
    public static void main(String... args) {
        AtomicBoolean aBoolean = new AtomicBoolean(true);
        int max = 100;
        Object lock = new Object();
        Thread t1 = new Thread(new Odd(aBoolean, lock, max));
        Thread t2 = new Thread(new Even(aBoolean, lock, max));
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

        AtomicBoolean flag;
        private final Object lock;
        private int max;

        Odd(AtomicBoolean flag, Object lock, int max) {
            this.flag = flag;
            this.lock = lock;
            this.max = max;

        }

        @Override
        public void run() {
            for (int i=1; i<max; i=+2){
                synchronized (lock){
                    if(flag.get()){
                        try {
                            System.out.println("T1: " + i);
                            flag.getAndSet(false);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        flag.getAndSet(false);
                        lock.notifyAll();
                    }
                }
            }
        }
    }

    private static class Even implements Runnable {

        AtomicBoolean flag;
        private final Object lock;
        private int max;

        Even(AtomicBoolean flag, Object lock, int max) {
            this.flag = flag;
            this.lock = lock;
            this.max = max;
        }

        @Override
        public void run() {
            for(int i = 2; i < max ; i=+2){
                synchronized (lock){
                    if(!flag.get()){
                        try {
                            System.out.println("T2: " + i);
                            flag.getAndSet(true);
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    else {
                        flag.getAndSet(true);
                        lock.notifyAll();
                    }
                }
            }
        }
    }
}
