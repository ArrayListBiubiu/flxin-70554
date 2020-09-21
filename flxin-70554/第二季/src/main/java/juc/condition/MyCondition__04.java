package juc.condition;

import java.util.concurrent.TimeUnit;

public class MyCondition__04 {

    public static void main(String[] args) {

        Duck duck = new Duck();
        new Thread(() -> {
            for(int i = 0; i < 50; i++) {

                duck.method();
            }
        }, "t1").start();

        new Thread(() -> {
            for(int i = 0; i < 50; i++) {

                duck.method();
            }
        }, "t2").start();

    }
}

class Duck {
    int i = 0;
    void method() {
        synchronized (this) {
            try {
                if (i % 2 != 0) {
                    wait();
                }
                TimeUnit.MILLISECONDS.sleep(10);
                System.out.println(Thread.currentThread().getName() + "：\t" + i++);
                notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}