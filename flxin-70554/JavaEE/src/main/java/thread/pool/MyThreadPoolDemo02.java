package thread.pool;

import java.util.concurrent.*;


/**
 * 线程池的拒绝策略：
 *      1. AbortPolicy（默认）：直接抛出java.util.concurrent.RejectedExecutionException异常，阻止系统正常运行。
 *      2. CallerRunsPolicy：“调用者运行”，一种调节机制，不会抛出异常，也不会抛弃任务，而是会把某些任务，回退到调用者，从而降低新任务量。
 *      3. DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入到队列中，尝试再次提交当前任务。
 *      4. DiscardPolicy：默默的丢弃无法处理的任务，不予以任何处理也不抛出异常，如果允许任务丢失者是最好的策略。
 */
public class MyThreadPoolDemo02 {

    public static void main(String[] args) {

        ExecutorService threadPool = new ThreadPoolExecutor(    // 超过8个，直接抛出异常。
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
                // new ThreadPoolExecutor.AbortPolicy()         超过8个，直接抛出异常。
                // new ThreadPoolExecutor.CallerRunsPolicy()    可能会出现1个或2个退回到main线程处理的结果。
                // new ThreadPoolExecutor.DiscardPolicy()       不抛出异常，存在任务丢失。
                // new ThreadPoolExecutor.DiscardOldestPolicy() 不抛出异常，存在任务丢失。



        for(int i = 0; i < 10; i++) {
            threadPool.execute(() ->{
                System.out.println(Thread.currentThread().getName() + "\t办理业务。");
            });
        }

        threadPool.shutdown();


    }

}
