package juc;


import java.util.concurrent.TimeUnit;


public class Lock8Demo {

    public static void main(String[] args) throws InterruptedException {

        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        // 保证A线程优先启动。
        Thread.sleep(200);
        new Thread(()->{
            try {
                phone2.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }

}

/**
 * 一个静态synchronized锁，一个synchronized锁，没有同步效果：同一个对象，一个锁class，一个锁this。
 * 一个静态synchronized锁，一个synchronized锁，没有同步效果：不同对象
 */
class Phone{
    public Phone() {
        System.out.println("构造方法");
    }
    public  synchronized void sendEmail() throws Exception {
        //java.util.concurrent.TimeUnit;
        TimeUnit.SECONDS.sleep(3);
        System.out.println("sendEmail");
    }

    public static synchronized  void sendMessage() throws Exception{
        TimeUnit.SECONDS.sleep(1);
        System.out.println("sendMessage");
    }
}