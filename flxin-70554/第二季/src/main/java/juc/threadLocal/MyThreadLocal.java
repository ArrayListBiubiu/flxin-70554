package juc.threadLocal;


import java.util.concurrent.TimeUnit;

public class MyThreadLocal {

    // 创建 ThreadLocal 对象
    static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        // 第一个线程：存值
        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(1); } catch (Exception e) { e.printStackTrace(); }
            threadLocal.set("hello");
        }).start();

        // 第二个线程：获取
        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(2); } catch (Exception e) { e.printStackTrace(); }
            System.out.println(threadLocal.get());
        }).start();
    }
}
