package conncurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cb = new CyclicBarrier(2);

        new Thread(() -> {
            System.out.println("------Thread 1 start-------");
            try {
                Thread.sleep(1000L);
                cb.await();
                System.out.println("---------Thread 1 finish-----------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            System.out.println("------Thread 2 start-------");
            try {
                Thread.sleep(10000L);
                cb.await();
                System.out.println("---------Thread 2 finish-----------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }

}
