package concurrent;

import java.util.concurrent.LinkedBlockingQueue;

public class PubSubLBQTest {
    public static void main(String[] args) {
        PubSub ps = new PubSub();
        Thread t1 = new Thread(() -> {
            for (int i=0; i<100; i++){
                ps.produce();
            }
        });
        Thread t2 = new Thread(() -> ps.consume());

        t1.start();
        t2.start();
    }

}

class PubSub{
    LinkedBlockingQueue taskQ = new LinkedBlockingQueue(6);

    public void produce(){
        double randomNumber = Math.floor(Math.random()*50d);
        System.out.println("[Producer] Put : " + randomNumber);
        taskQ.offer(randomNumber);
        System.out.println("[Producer] Queue remainingCapacity : " + taskQ.remainingCapacity());
        Long sleepInterval = (long)(Math.random()*6000);
        System.out.println("Sleeping for : "+ sleepInterval/60+ " s");
        try {
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void consume(){
        while (true){
        System.out.println("[consume] get : " + taskQ.poll());
        System.out.println("[consume] Queue remainingCapacity : " + taskQ.remainingCapacity());
        Long sleepInterval = (long)(Math.random()*6000);
        System.out.println("Sleeping for : "+ sleepInterval/60+ " s");
        try {
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }

    }

}
