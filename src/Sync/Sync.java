package Sync;

public class Sync {

    private int balance = 0;

    public static void main(String[]args){
        Sync sync = new Sync();
        sync.keepingBalance();
    }

    public void keepingBalance(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100000; i++){
                    add();
                }
            }
        });

        // Showing that we can use lambda for the new Runnable
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100000; i++){
                subtract();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("Balance = " + balance);
    }

    //These methods must be synchronized or else we won't get 0
    private synchronized void add(){balance++;}
    private synchronized void subtract(){balance--;}
}
