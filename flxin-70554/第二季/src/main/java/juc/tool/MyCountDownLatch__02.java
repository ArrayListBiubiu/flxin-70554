package juc.tool;
import java.util.concurrent.CountDownLatch;

/**
 * 工具类使用2：CountDownLatch，引入枚举的概念
 */
public class MyCountDownLatch__02 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 灭亡");
                countDownLatch.countDown();
            },MyCountry__03.method(i).getCountryName()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t *****秦国统一天下");

    }
}
