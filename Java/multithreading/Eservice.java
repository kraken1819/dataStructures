package multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService ;

public class  Eservice extends Thread {

    private String name ;

    public Eservice(String name){
        this.name = name ;
    }
    @Override
    public void run(){
        System.out.println(name + " started...") ;
        try {
            sleep(1) ;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " ended..") ;
    }

    public static void main(String[] args){
        Eservice e1 = new Eservice("t1") ;
        Eservice e2 = new Eservice("t2") ;
        Eservice e3 = new Eservice("t3") ;
        Eservice e4 = new Eservice("t4") ;
        Eservice e5 = new Eservice("t5") ;
        Eservice e6 = new Eservice("t6") ;
        Eservice e7 = new Eservice("t7") ;

        ExecutorService es = Executors.newFixedThreadPool(3) ;

        es.execute(e1) ;
        es.execute(e2) ;
        es.execute(e3) ;
        es.execute(e4) ;
        es.execute(e5) ;
        es.execute(e6) ;
        es.execute(e7) ;

        es.shutdown() ;




    }
}
