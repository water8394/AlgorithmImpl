package conncurrent;

import java.util.LinkedList;

public class ProducerAndConsumer {


    public void demo() {

        LinkedList<Integer> list = new LinkedList<>();

        // producer
        new Thread(()->{
            synchronized (ProducerAndConsumer.class){
                while (list.size() > 9){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                    System.out.println("--------add ->" + i + "-----------");
                }
            }
        }).start();
        // consumer
        new Thread(()->{
            synchronized (ProducerAndConsumer.class){
                while (list.size() <= 0){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < 10; i++) {
                    int k = list.pop();
                    System.out.println("--------remove ->" + k + "-----------");
                }
            }
        }).start();


    }

    public static void main(String[] args) {
        ProducerAndConsumer demo = new ProducerAndConsumer();
        demo.demo();
    }

}
