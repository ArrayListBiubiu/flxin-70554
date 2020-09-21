package juc.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;


/**
 * SynchronousQueue：不存储元素的阻塞队列，也即单个元素的队列
 */
public class MyBlockingQueue__05 {

    public static void main(String[] args) throws Exception {

        //参数是界值
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                blockingQueue.put("a");
                System.out.println(1);

                blockingQueue.put("a");
                System.out.println(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();






    }
}
