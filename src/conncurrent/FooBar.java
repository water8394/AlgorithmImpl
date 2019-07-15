package conncurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

    private int n;
    private int flag = 0;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag != 0) c1.await();
                printFoo.run();
                flag = 1;
                c2.signal();
            }finally {
                lock.unlock();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
//            printFoo.run();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag != 1) c2.await();
                printBar.run();
                flag = 0;
                c1.signal();
            }finally {
                lock.unlock();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
//            printBar.run();
        }
    }

}
