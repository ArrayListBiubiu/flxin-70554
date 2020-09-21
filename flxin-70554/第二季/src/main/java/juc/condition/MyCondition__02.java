package juc.condition;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 只使用lock实现线程通信，t1、t2交替执行
 * 注意：使用lock，必须创建对应的Condition对象实现
 */
public class MyCondition__02 {
    public static void main(String[] args) throws InterruptedException {
        Pig pig = new Pig();
        new Thread(() -> {
            while (true) {
                pig.decrement();
            }
        }, "t2").start();
        TimeUnit.MILLISECONDS.sleep(100);
        new Thread(() -> {
            while (true) {
                pig.increment();
            }
        }, "t1").start();
    }
}

/**
 * 资源类
 */
class Pig {
    int number = 0;
    int flag = 1;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    void increment() {
        lock.lock();
        try {
            if (flag != 1) {
                condition.await();
            }
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName() + "\t还剩下：" + ++number);
            flag = 2;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void decrement() {
        lock.lock();
        try {
            if (flag != 2) {
                System.out.println("=====" + flag);
                condition.await();
            }
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName() + "\t还剩下：" + --number);
            flag = 1;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}