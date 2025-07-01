package multithreading;

import static java.lang.Thread.sleep;

class Counter1 implements Runnable{
    private int counterNumber ;

    @Override
    public void run(){
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("Counter No.: " +counterNumber + " ; count : " + i);
                sleep(1000);
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public Counter1(){
         this.counterNumber = 0;
    }
    public Counter1(int counterNumber) {
        this.counterNumber = counterNumber ;

    }

}




public class Main {

    public static void main(String[] args) {


        Thread t1= new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    for(int i =0 ; i<11 ; i++)  {
                        System.out.println(i) ;
                        sleep(1000) ;
                    }
                }catch(InterruptedException e ) {
                    e.printStackTrace() ;
                }
            }
        });
        t1.start() ;

        Thread t2 = new Thread(new Runnable(){

            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                        sleep(1000);
                    }
                }catch(InterruptedException e ){
                    e.printStackTrace();
                }
            }
        }) ;
        t2.start() ;


    }
}
