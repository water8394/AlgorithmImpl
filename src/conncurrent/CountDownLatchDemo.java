package conncurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(2);

        new Thread(()->{
            try {
                System.out.println("-----Thread1 start---------");
                Thread.sleep(5000L);
                System.out.println("-----Thread1 finish---------");
                cd.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                System.out.println("-----Thread1 start---------");
                Thread.sleep(5000L);
                System.out.println("-----Thread1 finish---------");
                cd.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("-----Main start---------");
        cd.await();
        System.out.println("=======await======");

    }

}
