package juc.volatil;


import java.util.concurrent.TimeUnit;


/**
 * 验证volatile的可见性
 */
public class MyVolatile__01 {

    static volatile int i = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            // 测试2秒后能否得到通知
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {  e.printStackTrace(); }
            i = 1;
            System.out.println(0/0);
            System.out.println("t1线程结束，i的值修改为：" + i);
        }, "t1").start();

        //创造死循环，若i=1赋值成功，则跳出死循环
        new Thread(() -> {
            while (i == 0) {

            }
            System.out.println("t2线程结束");
        }, "t2").start();

    }
}
