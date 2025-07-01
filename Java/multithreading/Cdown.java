package multithreading;

import java.util.concurrent.CountDownLatch ;

public class Cdown extends Thread {

    private CountDownLatch l1 ;

    public Cdown(CountDownLatch l1) {
        this.l1 = l1 ;
    }

    @Override
    public void run(){
        System.out.println("Started Thread" + Thread.currentThread().getName()) ;
        System.out.println("Ended Thread" + Thread.currentThread().getName()) ;
        System.out.println("******************") ;
        l1.countDown() ;
    }


    public static void main (String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3) ;
        Cdown t1 = new Cdown(latch) ;
        Cdown t2 = new Cdown(latch) ;
        Cdown t3 = new Cdown(latch) ;

        t1.start() ;
        t2.start() ;
        t3.start() ;
        // if we comment this line , the countdown does not get completed and the
        //latch is never released

        latch.await() ;
        /*
            this await() function makes the main thread wait till the latch is unlocked in the above threads .
            since we wrote the countdown at the end of the thread . this latch gets unlocked only after all the
            3 threads gets completed .
         */
        System.out.println("Main Thread: " + Thread.currentThread().getName()) ;

    }
}
