package conncurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {

        Semaphore sp = new Semaphore(2);

        new Thread(()->{

            try {
                sp.acquire();
                System.out.println("-------Thread 1 start---------");
                Thread.sleep(5000L);
                sp.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{

            try {
                sp.acquire();
                System.out.println("-------Thread 2 start---------");
                Thread.sleep(5000L);
                sp.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{

            try {
                sp.acquire();
                System.out.println("-------Thread 3 start---------");
                Thread.sleep(5000L);
                sp.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
