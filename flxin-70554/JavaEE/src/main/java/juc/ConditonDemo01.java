package juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 需求：A线程打印5次，B线程打印10次，C线程打印15次。
 * 		这样的循环执行10次。
 *
 * 		1.高内聚，低耦合的前提下，线程操作资源类。
 * 		2.判断（标志位）、工作、通知。
 *
 * 		***3.防止虚假唤醒，不允许使用if判断，应该使用while。
 * 		***3.多线程的横向通信调用，使用while。
 *
 */
public class ConditonDemo01 {

    public static void main(String[] args) throws Exception{

        ShareData shareData = new ShareData();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    shareData.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    shareData.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    shareData.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();


    }

}


class ShareData{

    private int number =1;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() throws Exception{
        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 1) {
                c1.await();
            }
            // 2.工作。
            for(int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+i);
            }
            // 3.通知
            number = 2;
            c2.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void print10() throws Exception{
        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 2) {
                c2.await();
            }
            // 2.工作。
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+i);
            }
            // 3.通知
            number = 3;
            c3.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void print15() throws Exception{
        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 3) {
                c3.await();
            }
            // 2.工作。
            for(int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t"+i);
            }
            // 3.通知
            number = 1;
            c1.signalAll();
        } finally {
            lock.unlock();
        }
    }

}