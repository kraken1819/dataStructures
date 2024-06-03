package multithreading;

public class WaitNotify {
    private int balance ;

    public WaitNotify(){
        this.balance = 0 ;
    }
    public WaitNotify(int balance) {
        this.balance = balance;
    }

    synchronized public void withdrawl (int amount){
        if(balance<amount) {
            System.out.println("Waiting....") ;
            try {
                wait();
            }catch(InterruptedException e) {
                System.out.println("invalid amount deposit") ;
                return ;
            }

            System.out.println("Withdrawing $"+amount) ;
        }
        if(balance<amount) {
            System.out.println("Insufficient balance. Transaction aborted.") ;
        }else {
            balance -= amount ;
        }
        System.out.println("Available balance is $" + balance) ;
    }
    synchronized public boolean deposit(int amount) {
        if(amount>0) {
            System.out.println("Despositing...$" + amount);
            this.balance += amount;
            System.out.println("Available balance is $" + balance);
            notify() ;
            return true ;
        }else {
            return false;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        WaitNotify wn1 = new WaitNotify(1000) ;
        //WaitNotify wn2 = new WaitNotify() ;

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                wn1.withdrawl(2000) ;
            }
        }) ;

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){

                if(wn1.deposit(105)){
                    System.out.println("deposit Successfull..") ;

                }else {
                    t1.interrupt() ;
                }
            }
        }) ;
        t1.start();
        t2.start() ;

    }




}
