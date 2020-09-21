package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo01 {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(5);   // 1池5线程。
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();  // 1池1线程。
        ExecutorService threadPool3 = Executors.newCachedThreadPool();  // 1池n线程。


        for(int i = 0; i < 10; i++) {
            threadPool3.execute(() ->{
                System.out.println(Thread.currentThread().getName() + "\t办理业务。");
            });
        }

        // 关闭线程池。
        threadPool3.shutdown();

    }
}
