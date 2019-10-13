package concurrent;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ProducerSubscriberTest {

    public static void main(String[] args) {
    Queue<Double> doubles = new PriorityQueue<>();
    Thread t1 = new Thread(new Producer(doubles, " Producing ", 12));
    Thread t2 = new Thread(new Consumer(doubles, " Consuming "));
    t1.start();
    t2.start();
        try {
            t1.join();
            t2.join();
            System.gc();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable {
    private Queue<Double> taskQ;
    private String message;
    private Integer numberOfTasks;

    public Producer(Queue<Double> taskQ, String message, Integer numberOfTasks) {
        this.taskQ = taskQ;
        this.message = message;
        this.numberOfTasks = numberOfTasks;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (taskQ){
            int i = 0;
            while(i<numberOfTasks){
                if(taskQ.isEmpty()){
                    taskQ.add(Math.random()*10);
                    System.out.println(""+ i+ " "+message);
                    i++;
                    taskQ.notifyAll();
                } else {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        taskQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue<Double> taskQ;
    private String message;

    public Consumer(Queue<Double> taskQ, String message) {
        this.taskQ = taskQ;
        this.message = message;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        synchronized (taskQ) {
            while (true) {
                if(!taskQ.isEmpty()){
                    Double aDouble = taskQ.poll();
                    System.out.println(message.concat(" ").concat(aDouble.toString()));
                    taskQ.notifyAll();

                }else {
                    try {

                        taskQ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }
}
