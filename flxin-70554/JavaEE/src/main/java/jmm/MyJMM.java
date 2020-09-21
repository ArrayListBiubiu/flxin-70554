package jmm;

import java.util.concurrent.TimeUnit;

public class MyJMM {

    // 用volatile修饰，体现可见性，否则while循环变成死循环。
    static volatile int i = 0;

    public static void main(String[] args) {

        MyJMM myJMM = new MyJMM();

        new Thread (() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("i以修改为10.");
                i = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        while (i == 0) {

        }

        System.out.println("***出循环***");
    }
}
