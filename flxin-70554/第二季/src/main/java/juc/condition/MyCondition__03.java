package juc.condition;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用lock，condition实现精准通信
 */
public class MyCondition__03 {
    public static void main(String[] args) {

        Cat cat = new Cat();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    cat.method1();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    cat.method2();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for(int i = 0; i <10; i++) {
                try {
                    cat.method3();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }
}

class Cat{

    private int number =1;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void method1() throws Exception{
        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 1) {
                c1.await();
            }
            // 2.工作。
            System.out.println("method1");
            // 3.通知
            number = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    public void method2() throws Exception{
        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 2) {
                c2.await();
            }
            // 2.工作。
            System.out.println("method2method2");
            // 3.通知
            number = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }
    public void method3() throws Exception{
        lock.lock();
        try {
            // 1. 判断，为防止虚假唤醒，if修改为while。
            while(number != 3) {
                c3.await();
            }
            // 2.工作。
            System.out.println("method3method3method3");
            // 3.通知
            number = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }

}