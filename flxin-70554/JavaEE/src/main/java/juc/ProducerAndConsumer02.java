package juc;


/**
 * 需求：由2个线程增加至4个线程，两个加1,两个减1
 *
 * 		1.高内聚，低耦合的前提下，线程操作资源类。
 * 		2.判断（标志位）、工作、通知。
 *
 * 		***3.防止虚假唤醒，不允许使用if判断，应该使用while。
 * 		***3.多线程的横向通信调用，使用while。
 *
 */
public class ProducerAndConsumer02 {

    public static void main(String[] args) throws Exception{

        Aircondition02 air = new Aircondition02();

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


class Aircondition02{

    private int number = 0;

    // 先成产，再消费。
    public synchronized void increment() throws Exception{

        // 1. 判断，为防止虚假唤醒，if修改为while。
        while(number != 0) {
            this.wait();
        }

        // 2.工作。
        number++;
        System.out.println(Thread.currentThread().getName() + "\t:number:\t" + number);

        // 3.通知
        this.notifyAll();
    }

    // 先成产，再消费。
    public synchronized void decrement() throws Exception{

        // 1. 判断，为防止虚假唤醒，if修改为while。
        while(number == 0) {
            this.wait();
            System.out.println("===0==");

        }

        // 2.工作。
        number--;
        System.out.println(Thread.currentThread().getName() + "\t:number:\t" + number);

        // 3.通知
        this.notifyAll();
    }

}