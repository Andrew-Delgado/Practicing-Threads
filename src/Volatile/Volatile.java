package Volatile;

// Volatile makes sure a variable gets checked by a thread and not a cached version of it.

import java.util.Scanner;

public class Volatile {

    public static void main(String[]args){
        Counter c = new Counter();
        c.start();

        Scanner s = new Scanner(System.in);
        s.nextLine();

        c.stopCounting();
    }

}

class Counter extends Thread{

    // Use volatile for flags(booleans) and AtomicInteger / AtomicLong for counters
    private volatile boolean counting = true;
    private int counter = 1;

    public void run(){
        while(counting){
            System.out.println(counter);
            counter++;
            try{
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void stopCounting(){
        counting = false;
    }
}
