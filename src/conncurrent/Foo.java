package conncurrent;

public class Foo {

    private int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this){
            while (flag != 1 ){
                this.wait();
            }
                printFirst.run();
                flag = 2;
                this.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this){
            while (flag != 2 ){
                this.wait();
            }
            printSecond.run();
            flag = 3;
            this.notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this){
            while (flag != 2 ){
                this.wait();
            }
            printThird.run();
            flag = 3;
            this.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
    }
}
