package conncurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {


    private int n;
    private Lock lock = new ReentrantLock();
    private Condition zeroCondition = lock.newCondition();
    private Condition oddCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();
    private volatile int i = 0;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {

            lock.lock();
            if (i == n) break;
            printNumber.accept(0);
            if (i == 0) i++;
            if (i % 2 == 0) {
                evenCondition.signal();
            } else {
                oddCondition.signal();
            }
            zeroCondition.await();
         }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            lock.lock();
            if (i == 0 || i % 2 != 0) {
                evenCondition.await();
            }
            printNumber.accept(i++);
            zeroCondition.signal();
            if (i == n) break;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (i <= n) {
            lock.lock();
            if (i == 0 || i % 2 == 0) {
                oddCondition.await();
            }
            printNumber.accept(i++);
            zeroCondition.signal();
            if (i == n) break;
        }
    }

    public static void main(String[] args) {

        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);

        new Thread(() -> {
            try {
                zeroEvenOdd.zero((i) -> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd((i) -> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even((i) -> System.out.println(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
