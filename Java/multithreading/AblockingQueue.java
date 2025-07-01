package multithreading;

import java.util.concurrent.ArrayBlockingQueue ;

import static java.lang.Thread.sleep;

class Producer implements Runnable {
    ArrayBlockingQueue queue ;

    Producer(ArrayBlockingQueue queue) {
        this.queue = queue ;

    }

    @Override
    public void run(){
        while(true) {
            try {
                sleep(2000);
                queue.put(AblockingQueue.number);
                System.out.println("value added to the queue: " + AblockingQueue.number);
                AblockingQueue.number++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
class Consumer implements Runnable {
    ArrayBlockingQueue queue;

    Consumer(ArrayBlockingQueue queue) {
        this.queue = queue;

    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(5000);
                queue.take();
                System.out.println("value removed to the queue: " + (AblockingQueue.number-1));
                AblockingQueue.number--;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class AblockingQueue {
    static int number = 1 ;
    public static void main(String[] args) {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(5) ;
        Thread th1 = new Thread(new Producer(queue)) ;
        Thread th2 = new Thread(new Consumer(queue)) ;
        th1.start() ;
        th2.start() ;



    }
}
