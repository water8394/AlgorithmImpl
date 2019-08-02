package conncurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(()->{
            lock.lock();
            System.out.println("-----Thread 1 start ------");
            try {
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----Condition 1-----");


            System.out.println("----Condition 2-----");

            lock.unlock();

        }).start();

        System.out.println("----Main start----");

    }

}
