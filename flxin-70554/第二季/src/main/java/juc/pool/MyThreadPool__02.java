package juc.pool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class MyThreadPool__02 {

    public static void main(String[] args) {
        //一池多线程
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        //可扩展线程池
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        try {
            for(int i = 0; i < 5; i++) {
                threadPool2.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool2.shutdown();
        }

    }
}
