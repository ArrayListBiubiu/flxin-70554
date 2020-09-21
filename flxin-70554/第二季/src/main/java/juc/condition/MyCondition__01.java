package juc.condition;

import java.util.concurrent.TimeUnit;


/**
 * 只使用synchronized实现线程通信，t1、t2交替执行
 */
public class MyCondition__01 {

    public static void main(String[] args) throws InterruptedException {

        Dog dog = new Dog();
        new Thread(() -> {
            while (true) {
                dog.decrement();
            }
        }, "t2").start();
        TimeUnit.MILLISECONDS.sleep(100);
        new Thread(() -> {
            while (true) {
                dog.increment();
            }
        }, "t1").start();

    }

}

/**
 * 资源类
 */
class Dog {
    int number = 0;
    int flag = 1;
    synchronized void increment() {
        try {
            if (flag != 1) {
                wait();
            }
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName() + "\t还剩下：" + ++number);
            flag = 2;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void decrement() {
        try {
            if (flag != 2) {
                System.out.println("=====" + flag);
                wait();
            }
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName() + "\t还剩下：" + --number);
            flag = 1;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}