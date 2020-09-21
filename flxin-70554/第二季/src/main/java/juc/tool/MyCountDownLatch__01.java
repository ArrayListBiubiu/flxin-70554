package juc.tool;
import java.util.concurrent.CountDownLatch;


/**
 * 工具类使用1：CountDownLatch
 */
public class MyCountDownLatch__01 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t *****班长最后关门走人");

    }
}
