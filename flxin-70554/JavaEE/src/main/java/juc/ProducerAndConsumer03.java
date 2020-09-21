package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 需求：使用lock锁实现业务逻辑。
 * 		synchronized -> lock
 * 		wait -> await
 * 		nofityAll -> signalAll
 *
 * 		1.高内聚，低耦合的前提下，线程操作资源类。
 * 		2.判断（标志位）、工作、通知。
 *
 * 		***3.防止虚假唤醒，不允许使用if判断，应该使用while。
 * 		***3.多线程的横向通信调用，使用while。
 *
 */
public class ProducerAndConsumer03 {

    public static void main(String[] args) throws Exception{

        Aircondition03 air = new Aircondition03();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    air.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    air.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    air.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    air.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();


    }

}


class Aircondition03{

    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // 先成产，再消费。
    public void increment() throws Exception{

        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 0) {
                condition.await();
            }

            // 2.工作。
            number++;
            System.out.println(Thread.currentThread().getName() + "\t:number:\t" + number);

            // 3.通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }


    // 先成产，再消费。
    public void decrement() throws Exception{

        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number == 0) {
                condition.await();
            }

            // 2.工作。
            number--;
            System.out.println(Thread.currentThread().getName() + "\t:number:\t" + number);

            // 3.通知
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

}