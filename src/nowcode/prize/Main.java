package nowcode.prize;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ReviewEncourage r = new ReviewEncourage(n);
        ReviewEncourage.PrizePool pool = new ReviewEncourage.PrizePool();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.bonus(pool);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.coupon(pool);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.contribution(pool);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
class ReviewEncourage{
    int n;
    int start;
    int flag = 1;
    volatile boolean odd = false;

    public ReviewEncourage(int n) {
        this.start =1;
        this.n = n;
    }
    public static class PrizePool{
        public void send(String input){
            System.out.print(input);
        }
    }
    public void bonus(PrizePool prizePool) throws InterruptedException {
        while (start <= n){
                synchronized (this){
                while (start % 2 != 1 || flag != 1){
                    this.wait();
                }
                prizePool.send("A");
                start++;
                flag = 2;
                if (start > n) return;
                this.notifyAll();
            }
        }
    }
    public void coupon(PrizePool prizePool) throws InterruptedException {
        while (start <= n){
                synchronized (this){
                while (start % 2 != 0 || odd || flag != 2){
                    this.wait();
                }
                prizePool.send("B");
                odd = !odd;
                start++;
                flag = 1;
                if (start > n) return;
                this.notifyAll();
            }
        }
    }
    public void contribution(PrizePool prizePool) throws InterruptedException {
        while (start <= n){
                synchronized (this){
                while (start % 2 != 0 || !odd || flag != 2){
                    this.wait();
                }
                prizePool.send("C");
                odd = !odd;
                start++;
                flag = 1;
                if (start > n) return;
                this.notifyAll();
            }
        }
    }
}
