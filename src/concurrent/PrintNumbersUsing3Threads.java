package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNumbersUsing3Threads {
    final static int MAX_NUMBERS = 10;

    public static void main(String[] args) {
        // shared object
        Lock obj = new ReentrantLock();
        // Creating 3 threads
        Thread t1 = new Thread(new NumberRunnable(obj, 0, MAX_NUMBERS), "T1");
        Thread t2 = new Thread(new NumberRunnable(obj, 1, MAX_NUMBERS), "T2");
        Thread t3 = new Thread(new NumberRunnable(obj, 2, MAX_NUMBERS), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class NumberRunnable implements Runnable{
    Lock obj;
    int threadNumber;
    int maxNumber;
    static int number = 0;
    NumberRunnable(Lock obj, int result, int maxNumber){
        this.obj = obj;
        this.maxNumber = maxNumber;
        this.threadNumber = result;
    }
    @Override
    public void run() {
        while (number < maxNumber) {
            synchronized(obj) {
                if(number % 3 == threadNumber && number < maxNumber){
                    System.out.println(Thread.currentThread().getName() + " - " + ++number);
                }
            }
        }
    }
}
