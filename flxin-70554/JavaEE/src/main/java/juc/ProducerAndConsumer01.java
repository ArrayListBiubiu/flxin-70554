package juc;


/**
 * 需求：有2个线程，操作初始值为0的变量，一个加1，一个减1，实现交替操作的功能。
 *
 * 		1.高内聚，低耦合的前提下，线程操作资源类。
 * 		2.判断（标志位）、工作、通知。
 *
 */
public class ProducerAndConsumer01 {

    public static void main(String[] args) throws Exception{

        Aircondition air = new Aircondition();

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

    }

}


class Aircondition{

    private int number = 0;

    // 先成产，再消费。
    public synchronized void increment() throws Exception{

        // 1. 判断。
        if(number != 0) {
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

        // 1. 判断。
        if(number == 0) {
            this.wait();
        }

        // 2.工作。
        number--;
        System.out.println(Thread.currentThread().getName() + "\t:number:\t" + number);

        // 3.通知
        this.notifyAll();
    }

}