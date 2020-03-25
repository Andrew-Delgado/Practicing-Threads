package ThreadVsProcess;

import static java.lang.Thread.sleep;

public class ThreadAndRunnable {
    public static void main(String[] args) {

        NewYear ny = new NewYear();
        Thread t = new Thread(ny);
        t.start();
        System.out.println("dogs");
    }
}

class NewYear implements Runnable {
    public void run() {
        countDown();
    }

    public void countDown() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Happy New Year");
    }
}

//Can also do with thread, Runnable is better if you need multiple inheritance

//public class ThreadAndRunnable {
//    public static void main(String[] args) {
//
//        NewYear ny = new NewYear();
//        ny.start();
//        // This is to show the main thread is still running
//        System.out.println("dogs");
//    }
//}
//
//class NewYear extends Thread {
//    public void run() {
//        countDown();
//    }
//
//    public void countDown() {
//        for (int i = 10; i > 0; i--) {
//            System.out.println(i);
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("Happy New Year");
//    }
//}